package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.dao.DishDao;
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.models.enums.BillStatus;
import ua.automatisationInc.pos.services.AdministratorService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import static java.util.stream.Collectors.toList;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
@Service
@Transactional(readOnly = true)
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private DishDao dishDao;
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private BillDao billDao;


    @Override
    @Transactional
    public List<Ingredient> getAllIngredients() {
        return StreamSupport.stream(ingredientDao.findAll().spliterator(),false).collect(toList());
    }

    @Override
    @Transactional
    public List<Dish> getAllDishes() {
        return StreamSupport.stream(dishDao.findAll().spliterator(),false).collect(toList());
    }

    @Override
    @Transactional
    public List<Bill> getAllBills() {
        return StreamSupport.stream(billDao.findAll().spliterator(),false).collect(toList());
    }

    @Override
    @Transactional
    public Ingredient findById(long id) {
        return ingredientDao.findById(id);
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        return ingredientDao.findByName(name);
    }

    @Override
    @Transactional
    public String getIngredientStatus(Ingredient ingredient) {
        double weight = ingredient.getWeight();
        if (weight > 100) {
            return "enough";
        } else {
            return "need to add";
        }
    }

    @Override
    @Transactional
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientDao.save(ingredient);
    }

    @Override
    @Transactional
    public void deleteIngredientById(long id) {
        ingredientDao.delete(id);
    }

    @Override
    @Transactional
    public Dish saveDish(Dish dish) {
        return dishDao.saveOrUpdate(dish);
    }

    @Override
    @Transactional
    public void deleteDishById(long id) {
        dishDao.delete(id);
    }

    @Override
    @Transactional
    public double billSumByDate(LocalDate date) {
        double sum = 0;
        List<Bill> billsByDate = billDao.findByDate(date);
        List<Bill> billsDoneByDate = billsByDate.stream().filter(bill -> bill.getStatus() == BillStatus.DONE).collect(Collectors.toList());
        //billsDoneByDate.forEach((bill) -> sum += bill.getTotalPrice());
        for (Bill bill : billsDoneByDate) {
            sum+=bill.getTotalPrice();
        }
        return sum;
    }
}
