package ua.automatisationInc.pos.services;

import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;

import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
public interface DishService {

    List<Dish> getAllDishes ();

    Dish saveDish (Dish dish);

    void sellDish (Dish dish);

    Dish getDishById(long dishId);

    void deleteDishById (long id);

    List<Dish> getDishByType(DishType type);

    List<DishType> getDishTypes();

}
