package ua.automatisationInc.pos.services;

import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
public interface AdministratorService {

//    ingredients
    List<Ingredient> getAllIngredients ();

    String getIngredientStatus (Ingredient ingredient);

    Ingredient findById (long id);

    Ingredient findByName (String name);

    Ingredient saveIngredient (Ingredient ingredient);

    void deleteIngredientById (long id);

//    dishes

    List<Dish> getAllDishes ();

    Dish saveDish (Dish dish);

    void deleteDishById (long id);

//    bills

    List<Bill> getAllBills ();

    double billSumByDate (LocalDate date);


}
