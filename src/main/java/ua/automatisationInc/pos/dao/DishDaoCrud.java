package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import ua.automatisationInc.pos.models.Dish;

/**
 * Created by Pavel Grudina on 25.03.2018.
 */
public interface DishDaoCrud extends CrudRepository<Dish, Long> {
}
