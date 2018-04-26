package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;

import java.util.List;

/**
 * Created by Pavel Grudina on 25.03.2018.
 */
@Repository
public interface DishDao extends CrudRepository<Dish, Long> {

    List<Dish> getDishOrderByCategory (DishType dishType);
}
