package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.automatisationInc.pos.models.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Pavel Grudina on 07.04.2018.
 */
@Repository
public interface RestaurantDao extends CrudRepository<Restaurant, Long> {

    List<Dish> allDishOrderById (long id);

    List<Ingredient> allIngredientOrderById (long id);

    List<User> allUserOrderById (long id);

    List<Bill> allBillOrderById (long id);

}
