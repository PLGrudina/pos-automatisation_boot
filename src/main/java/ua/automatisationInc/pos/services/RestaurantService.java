package ua.automatisationInc.pos.services;

import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.models.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
public interface RestaurantService {

    List<Dish> getAllDish (long restId);

    List<Ingredient> getAllIngredient (long restId);

    List<Bill> getAllBill (long restId);
//
//    List<Bill> getBillByDate (LocalDate date);
//
//    double billSumByDate (LocalDate date);

    List<User> getAllUser (long restId);
}
