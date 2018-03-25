package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import ua.automatisationInc.pos.models.Ingredient;

/**
 * Created by Pavel Grudina on 25.03.2018.
 */
public interface IngredientDao extends CrudRepository<Ingredient, Long> {
}
