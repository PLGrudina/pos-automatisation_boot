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
import ua.automatisationInc.pos.services.AdministratorService;
import ua.automatisationInc.pos.services.CashierService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
@Controller
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private CashierService cashierService;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getStartPage() {
        return "index";
    }

    @RequestMapping(path = "/administrator", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        List<Ingredient> ingredientList = administratorService.getAllIngredients();
        model.addAttribute("administratorService", administratorService);
        model.addAttribute("ingredientList", ingredientList);
        List<Dish> dishList = administratorService.getAllDishes();
        model.addAttribute("dishList", dishList);
        List<Bill> billList = administratorService.getAllBills();
        model.addAttribute("billList", billList);
        model.addAttribute("dateNow", LocalDate.now());
        return "/administrator";
    }

    @RequestMapping(path = "/administrator", method = RequestMethod.POST)
    public String deleteIngredient(@RequestParam(name = "id", required = false) Long id) {
        if (administratorService.findById(id) != null) {
            administratorService.deleteIngredientById(id);
        }
        if (cashierService.getDishById(id) != null) {
            administratorService.deleteDishById(id);
        }
        return "redirect:/administrator";
    }

    @RequestMapping(path = "/ingredient", method = RequestMethod.GET)
    public String addIngredient(@RequestParam(name = "id", required = false) Long id, Model model) {
        Ingredient ingredient;
        if (id != null) {
            ingredient = administratorService.findById(id);
        } else {
            ingredient = new Ingredient();
        }
        model.addAttribute("ingredient", ingredient);
        return "/ingredient";
    }

    @RequestMapping(path = "/ingredient", method = RequestMethod.POST)
    public String edit(@ModelAttribute Ingredient ingredient) {
        administratorService.saveIngredient(ingredient);
        return "redirect:/administrator";
    }


    @RequestMapping(path = "/dish", method = RequestMethod.GET)
    public String addDish(@RequestParam(name = "id", required = false) Long id, Model model) {
        Dish dish;
        List<Ingredient> ingredientList = administratorService.getAllIngredients();

        if (id != null) {
            dish = cashierService.getDishById(id);
            ingredientList.removeAll(dish.getIngredients());
        } else {
            dish = new Dish();
        }

        model.addAttribute("ingredientList", ingredientList);
        model.addAttribute("dish", dish);
        return "/dish";
    }

    @RequestMapping(path = "/dish", method = RequestMethod.POST)
    public String edit(@ModelAttribute Dish dish, @RequestParam(name = "url") String url, @RequestParam(name = "ingredientName[]") String[] ingredientName) {
        administratorService.saveDish(dish);
        if (url.equals("")) {
            dish.setUrl("/static/img/no-picture.png");
        }
        if (ingredientName.length > 1) {

            for (String nameIngr : ingredientName) {
                Ingredient ingredient = administratorService.findByName(nameIngr);
                dish.getIngredients().add(ingredient);
            }
        }


        administratorService.saveDish(dish);
        return "redirect:/administrator";
    }


}
