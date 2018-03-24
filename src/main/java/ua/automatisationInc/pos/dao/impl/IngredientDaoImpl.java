package ua.automatisationInc.pos.dao.impl;

import org.springframework.stereotype.Repository;
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.models.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
@Repository
public class IngredientDaoImpl implements IngredientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ingredient save(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        entityManager.merge(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient saveOrUpdate(Ingredient ingredient) {
        if (ingredient.getId() > 0) {
            update(ingredient);
        } else {
            save(ingredient);
        }
        return ingredient;
    }

    @Override
    public void delete(long id) {
        Ingredient ingredient = entityManager.find(Ingredient.class, id);
        entityManager.remove(ingredient);
    }

    @Override
    public Ingredient findByName(String name) {

        Ingredient ingredient = entityManager.createQuery("from Ingredient where name like:ingName", Ingredient.class)
                .setParameter("ingName", name).getSingleResult();

        return ingredient;
    }

    @Override
    public Ingredient findById(long id) {

        return entityManager.find(Ingredient.class, id);

    }

    @Override
    public List<Ingredient> findAll() {

        return entityManager.createQuery("from Ingredient", Ingredient.class).getResultList();

    }
}
