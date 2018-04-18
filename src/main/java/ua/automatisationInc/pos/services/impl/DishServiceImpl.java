package ua.automatisationInc.pos.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.DishDao;
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.models.enums.DishType;
import ua.automatisationInc.pos.services.DishService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
@Service
@Transactional(readOnly = true)
public class DishServiceImpl implements DishService {

    @Autowired
    DishDao dishDao;

    @Autowired
    IngredientDao ingredientDao;


    @Override
    public List<Dish> getAllDishes() {
        return Lists.newArrayList(dishDao.findAll());
    }

    @Override
    public Dish saveDish(Dish dish) {
        return dishDao.save(dish);
    }

    @Override
    public void sellDish(Dish dish) {
        Set<String> ingredientNames = dish.getRecipe().keySet();
        for (String name : ingredientNames) {
            Double weight = dish.getRecipe().get(name);
            Ingredient ingr = ingredientDao.findOrderByName(name);
            ingr.setWeight((ingr.getWeight()-weight));
        }
    }

    @Override
    public Dish getDishById(long dishId) {
        return dishDao.findOne(dishId);
    }

    @Override
    public void deleteDishById(long id) {
        dishDao.delete(id);
    }

    @Override
    public List<Dish> getDishByType(DishType type) {
        return Lists.newArrayList(dishDao.getDishOrderByCategory(type));
    }

    @Override
    public List<DishType> getDishTypes() {
        List<DishType> dishTypes = new ArrayList<>();
        dishTypes.addAll(Arrays.asList(DishType.values()));
        return dishTypes;
    }
}

