package ua.automatisationInc.pos.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.config.PersistenceConfig;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.services.AdministratorService;
import ua.automatisationInc.pos.services.impl.AdministratorServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PavelGrudina on 26.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, AdministratorServiceImpl.class})
public class AdministratorServiceTest {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private DishDao dishDao;
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private BillDao billDao;


    Ingredient meat;
    Ingredient cucumber;

    Dish burger;
    Dish cola;

    Bill first;
    Bill second;

    List<Ingredient> actualIngrList;
    List<Dish> actualDishList;
    List<Bill> actualBillList;

    @Before
    @Transactional
    public void setUp() throws Exception {
        cucumber = new Ingredient();
        meat = new Ingredient();
        burger = new Dish();
        cola = new Dish();
        first = new Bill();
        second = new Bill();
        cucumber.setName("Cucumber");
        cucumber.setWeight(300);
        meat.setName("Meat");
        meat.setWeight(50);
        burger.setName("Burger");
        burger.setPrice(10);
        burger.setWeight(300);
        cola.setName("CocaCola");
        cola.setPrice(2);
        cola.setWeight(500);
        first.setComment("Not onion");
        first.setPrice(25);
        second.setComment("Little burgers");
        second.setPrice(12);
        billDao.save(first);
        billDao.save(second);
        dishDao.save(burger);
        dishDao.save(cola);
        ingredientDao.save(meat);
        ingredientDao.save(cucumber);
        actualIngrList = new ArrayList<>();
        actualIngrList.add(cucumber);
        actualIngrList.add(meat);
        actualDishList = new ArrayList<>();
        actualDishList.add(burger);
        actualDishList.add(cola);
        actualBillList = new ArrayList<>();
        actualBillList.add(first);
        actualBillList.add(second);

    }

    @Test
    @Transactional
    public void getAllIngredients() throws Exception {
        List<Ingredient> expected = administratorService.getAllIngredients();
        Assert.assertEquals(expected.size(), actualIngrList.size());
    }

    @Test
    @Transactional
    public void getAllDishes() throws Exception {
        List<Dish> expected = administratorService.getAllDishes();
        Assert.assertEquals(expected.size(), actualDishList.size());
        Assert.assertTrue(expected.containsAll(actualDishList));

    }

    @Test
    @Transactional
    public void getAllBills() throws Exception {
        List<Bill> expected = administratorService.getAllBills();
        Assert.assertEquals(expected.size(), actualBillList.size());
        Assert.assertTrue(expected.containsAll(actualBillList));

    }

    @Test
    @Transactional
    public void findById() throws Exception {
        long actualID = cucumber.getId();
        Ingredient expected = administratorService.findById(actualID);
        Assert.assertEquals(expected.getId(), actualID);

    }

    @Test
    @Transactional
    public void findByName() throws Exception {
        String actualName = cucumber.getName();
        Ingredient expected = administratorService.findByName(actualName);
        Assert.assertEquals(expected.getName(), actualName);
    }

    @Test
    @Transactional
    public void saveIngredient() throws Exception {
        Ingredient salad = new Ingredient();
        salad.setName("Salad");
        salad.setWeight(300);
        administratorService.saveIngredient(salad);
        Assert.assertTrue(salad.getId() > 0);

    }

    @Test
    @Transactional
    public void deleteIngredientById() throws Exception {
        administratorService.deleteIngredientById(cucumber.getId());
        Assert.assertNull(administratorService.findById(cucumber.getId()));
    }

    @Test
    @Transactional
    public void saveDish() throws Exception {
        Dish soup = new Dish();
        soup.setName("Borsh");
        soup.setWeight(350);
        administratorService.saveDish(soup);
        Assert.assertTrue(soup.getId() > 0);
    }
    
}
