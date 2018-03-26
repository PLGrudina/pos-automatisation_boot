package ua.automatisationInc.pos.exceptions;

import java.time.LocalDateTime;

/**
 * Created by Pavel Grudina on 26.03.2018.
 */
public class DishNotFoundEx extends ItemNotFoundEx {

    private String info = "Dish not found in database";

    DishNotFoundEx(){

    }

    DishNotFoundEx(Long id){
        info = LocalDateTime.now() + "Dish id " + id + " not found in database";
    }

    DishNotFoundEx(String name){
        info = LocalDateTime.now() + "Dish with name " + name + " not found in database";
    }

    public String getInfo() {
        return info;
    }
}
