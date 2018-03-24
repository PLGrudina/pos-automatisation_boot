package ua.automatisationInc.pos.dao.impl;

import org.springframework.stereotype.Repository;
import ua.automatisationInc.pos.dao.DishDao;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
@Repository
public class DishDaoImpl implements DishDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Dish save(Dish dish) {
        entityManager.persist(dish);
        return dish;
    }

    @Override
    public Dish update(Dish dish) {
        entityManager.merge(dish);
        return dish;
    }

    @Override
    public Dish saveOrUpdate(Dish dish) {
        if (dish.getId() > 0) {
            update(dish);
        } else {
            save(dish);
        }
        return dish;
    }

    @Override
    public void delete(long id) {
        Dish dish = entityManager.find(Dish.class, id);
        entityManager.remove(dish);
    }

    @Override
    public Dish findById(long id) {
        return entityManager.find(Dish.class, id);
    }

    @Override
    public Dish findByName(String name) {

        Dish dish = entityManager.createQuery("from Dish where name like:dishName", Dish.class)
                .setParameter("dishName", name).getSingleResult();

        return dish;
    }

    @Override
    public List<Dish> findByType(DishType type) {
        List<Dish> dishList = entityManager.createQuery("from Dish dish where dish.category = :type", Dish.class)
                .setParameter("type", type).getResultList();
        return dishList;
    }

    @Override
    public List<Dish> findAllDish() {
        List<Dish> dishList = entityManager.createQuery("from Dish", Dish.class).getResultList();
        return dishList;
    }
}
