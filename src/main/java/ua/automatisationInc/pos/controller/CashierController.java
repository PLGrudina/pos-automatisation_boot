package ua.automatisationInc.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.models.enums.BillStatus;
import ua.automatisationInc.pos.models.enums.DishType;
import ua.automatisationInc.pos.services.CashierService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Man on 21.03.2017.
 */

@Controller
public class CashierController {
    @Autowired
    private CashierService cashierService;
    List<Dish> dishList = new ArrayList<>();
    double price;

    @RequestMapping(path = "/cashier", method = RequestMethod.GET)
    public String getCashierPage(Model model) {
        List<DishType> dishTypes = cashierService.getDishTypes();
        model.addAttribute("dishTypes", dishTypes);
        List<Dish> sandwiches = cashierService.getDishesByType(DishType.SANDWICH);
        model.addAttribute("sandwiches", sandwiches);
        return "/cashier";
    }

    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    public String getMenuByType(@RequestParam(name = "category") String category, Model model) {
        List<Dish> dishes = cashierService.getDishesByType(DishType.valueOf(category));
        model.addAttribute("dishes", dishes);
        return "/menu";
    }

    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public String chooseDish(@RequestParam(name = "dishId") String dishId, Model model) {
        Dish dish = cashierService.getDishById(Long.parseLong(dishId));
        price += dish.getPrice();
        dishList.add(dish);
        model.addAttribute("dishList", dishList);
        model.addAttribute("price", price);
        return "/check";
    }

    @RequestMapping(path = "/check", method = RequestMethod.POST)
    public String createBill(@RequestParam(name = "comment") String comment, @RequestParam(name = "doButton") String doButton) {
        switch (doButton) {
            case "CREATE": {
                Bill bill = cashierService.createBill();
                bill.setDate(LocalDate.now());
                bill.setDishList(dishList);
                bill.setComment(comment);
                bill.setStatus(BillStatus.DO);
                cashierService.saveBill(bill);
                bill.setNumber(cashierService.getAllBillsByToDay(LocalDate.now()).size());
                cashierService.saveBill(bill);
                break;
            }

            case "CLEAN": {
                dishList.clear();
                break;
            }
        }
        return "redirect:/cashier";
    }

}
