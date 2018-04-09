package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import ua.automatisationInc.pos.models.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Pavel Grudina on 07.04.2018.
 */
public interface RestaurantDao extends CrudRepository<Restaurant, Long> {

    List<Dish> getDishListBOrderById (long restId);

    List<Ingredient> getIngredientListBOrderById (long restId);

    List<User> getUserListBOrderById (long restId);

    List<Bill> getBillListBOrderById (long restId);

    List<Bill> getBillListByDate (LocalDate date);
}
