package ua.automatisationInc.pos.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import ua.automatisationInc.pos.dao.DishDao;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;
import ua.automatisationInc.pos.services.DishService;

import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
public class DishServiceImpl implements DishService {

    @Autowired
    DishDao dishDao;


    @Override
    public List<Dish> getAllDishes() {
        return null;
    }

    @Override
    public Dish saveDish(Dish dish) {
        return null;
    }

    @Override
    public void sellDish(Dish dish, double... ingredientsWeight) {

    }

    @Override
    public Dish getDishById(long dishId) {
        return null;
    }

    @Override
    public void deleteDishById(long id) {

    }

    @Override
    public List<Dish> getDishByType(DishType type) {
        return null;
    }

    @Override
    public List<DishType> getDishTypes() {
        return null;
    }
}
