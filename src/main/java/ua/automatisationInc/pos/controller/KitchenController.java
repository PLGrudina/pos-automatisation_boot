package ua.automatisationInc.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.dao.impl.BillDaoImpl;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.BillStatus;
import ua.automatisationInc.pos.models.enums.DishType;
import ua.automatisationInc.pos.services.CashierService;
import ua.automatisationInc.pos.services.KitchenService;
import ua.automatisationInc.pos.services.impl.CashierServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KitchenController {
    @Autowired
    KitchenService kitchenService;
    @Autowired
    CashierService cashierService;

    @RequestMapping(path = "/kitchen", method = RequestMethod.GET)
    public String getKitchenPage(Model model) {
        List<Bill> bills = new ArrayList<>();
        for (Bill bill : kitchenService.showAllOrders()) {
            if (bill.getStatus().equals(BillStatus.DO)) {
                bills.add(bill);
            }
        }
        model.addAttribute("bills", bills);
        return "/kitchen";
    }

    @RequestMapping(path = "/kitchen", method = RequestMethod.POST)
    public String edit(@RequestParam(name = "id", required = false) Long id) {
        Bill bill = cashierService.getBill(id);
        bill.setStatus(BillStatus.DONE);
        cashierService.saveBill(bill);
        return "redirect:/kitchen";
    }
}
