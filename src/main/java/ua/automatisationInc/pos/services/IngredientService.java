package ua.automatisationInc.pos.services;

import ua.automatisationInc.pos.models.Ingredient;

import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
public interface IngredientService {

    List<Ingredient> getAllIngredients ();

    String getIngredientStatus (Ingredient ingredient);

    Ingredient findById (long id);

    Ingredient findByName (String name);

    Ingredient saveIngredient (Ingredient ingredient);

    void deleteIngredientById (long id);

}
