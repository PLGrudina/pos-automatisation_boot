package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.dao.DishDao;
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.dao.UserDao;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.models.User;
import ua.automatisationInc.pos.services.RestaurantService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Pavel Grudina on 09.04.2018.
 */
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    DishDao dishDao;

    @Autowired
    BillDao billDao;

    @Autowired
    IngredientDao ingredientDao;

    @Autowired
    UserDao userDao;

    @Override
    public List<Dish> getAllDish(long restId) {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredient(long restId) {
        return null;
    }

    @Override
    public List<Bill> getAllBill(long restId) {
        return null;
    }

    @Override
    public List<Bill> getBillByDate(LocalDate date) {
        return null;
    }

    @Override
    public double billSumByDate(LocalDate date) {
        return 0;
    }

    @Override
    public List<User> getAllUser(long restId) {
        return null;
    }
}
