package ua.automatisationInc.pos.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.services.IngredientService;

import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
@Service
@Transactional(readOnly = true)
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientDao ingredientDao;


    @Override
    public List<Ingredient> getAllIngredients() {
        return Lists.newArrayList(ingredientDao.findAll());
    }

    @Override
    public String getIngredientStatus(Ingredient ingredient) {
        double weight = ingredient.getWeight();
        if (weight > 100) {
            return "enough";
        } else {
            return "need to add";
        }
    }

    @Override
    public Ingredient findById(long id) {
        return ingredientDao.findOne(id);
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientDao.findOrderByName(name);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientDao.save(ingredient);
    }

    @Override
    public void deleteIngredientById(long id) {
        ingredientDao.delete(id);
    }
}
