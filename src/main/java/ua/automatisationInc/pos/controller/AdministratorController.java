package ua.automatisationInc.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
@Controller
public class AdministratorController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Model model) {

        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @RequestMapping(value = "/")
    public String getRoot() {
        return "registration";
    }

    @RequestMapping(value = "/admin")
    public String getAdmin() {
        return "admin";
    }

}
