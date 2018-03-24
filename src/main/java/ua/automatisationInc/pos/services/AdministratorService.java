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

    List<Ingredient> getAllIngredients ();

    List<Dish> getAllDishes ();

    List<Bill> getAllBills ();

    String getIngredientStatus (Ingredient ingredient);

    Ingredient findById (long id);

    Ingredient findByName (String name);

    Ingredient saveIngredient (Ingredient ingredient);

    void deleteIngredientById (long id);

    Dish saveDish (Dish dish);

    void deleteDishById (long id);

    double billSumByDate (LocalDate date);


}
