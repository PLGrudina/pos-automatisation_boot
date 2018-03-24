package ua.automatisationInc.pos.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import ua.automatisationInc.pos.controller.editors.LocalDateEditor;

import java.time.LocalDate;

/**
 * Created by PavelGrudina on 05.04.2017.
 */

@ControllerAdvice
public class PropertyEditorAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
    }

//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "/cashier";
//    }
}

