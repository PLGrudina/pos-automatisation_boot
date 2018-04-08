package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.services.IngredientService;

import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientDao ingredientDao;


    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }

    @Override
    public String getIngredientStatus(Ingredient ingredient) {
        return null;
    }

    @Override
    public Ingredient findById(long id) {
        return null;
    }

    @Override
    public Ingredient findByName(String name) {
        return null;
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return null;
    }

    @Override
    public void deleteIngredientById(long id) {

    }
}
