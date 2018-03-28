package ua.automatisationInc.pos.exceptions;

import java.time.LocalDateTime;

/**
 * Created by Pavel Grudina on 27.03.2018.
 */
public class IngredientNotFoundEx extends ItemNotFoundEx {

    private String info = "Ingredient not found in database";

    public IngredientNotFoundEx() {

    }

    IngredientNotFoundEx(Long id) {
        info = LocalDateTime.now() + "Ingredient id " + id + " not found in database";
    }

    public String getInfo() {
        return info;
    }
}

