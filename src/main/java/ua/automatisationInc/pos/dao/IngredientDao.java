package ua.automatisationInc.pos.dao;


import ua.automatisationInc.pos.models.Ingredient;

import java.util.List;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
public interface IngredientDao {

    Ingredient save(Ingredient ingredient);

    Ingredient update(Ingredient ingredient);

    Ingredient saveOrUpdate(Ingredient ingredient);

    void delete(long id);

    Ingredient findByName(String name);

    Ingredient findById(long id);

    List<Ingredient> findAll();

}
