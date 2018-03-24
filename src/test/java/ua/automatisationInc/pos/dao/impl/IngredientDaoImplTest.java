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
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.models.Ingredient;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by PavelGrudina on 05.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class IngredientDaoImplTest {

    @Autowired
    IngredientDao ingredientDao;

    Ingredient testCucumber;

    @Before
    public void setUp() throws Exception {
        testCucumber = new Ingredient();
        testCucumber.setName("Cucumber");
        testCucumber.setWeight(300);

    }

    @Test
    @Transactional
    public void save() throws Exception {
        ingredientDao.save(testCucumber);
        Assert.assertTrue(testCucumber.getId() > 0);
    }


    @Test
    @Transactional
    public void findByName() throws Exception {
        ingredientDao.save(testCucumber);
        Ingredient expected = ingredientDao.findByName(testCucumber.getName());
        Assert.assertEquals(expected.getName(), testCucumber.getName());

    }

    @Test
    @Transactional
    public void update() throws Exception {
        testCucumber.setWeight(60000);
        ingredientDao.update(testCucumber);
        Ingredient expected = ingredientDao.findByName("Cucumber");
        Assert.assertTrue(expected.getWeight() == 60000);

    }

    @Test
    @Transactional
    public void findById() throws Exception {
        ingredientDao.save(testCucumber);
        Ingredient expected = ingredientDao.findById(testCucumber.getId());
        Assert.assertEquals(expected, testCucumber);

    }

    @Test
    @Transactional
    public void findAll() throws Exception {
        Ingredient meat = new Ingredient();
        Ingredient bread = new Ingredient();
        meat.setName("Meat");
        bread.setName("Bread");
        ingredientDao.save(testCucumber);
        ingredientDao.save(meat);
        ingredientDao.save(bread);
        List<Ingredient> actual = new ArrayList<>();
        actual.add(testCucumber);
        actual.add(meat);
        actual.add(bread);
        List<Ingredient> expected = ingredientDao.findAll();
        Assert.assertArrayEquals(expected.toArray(new Ingredient[expected.size()]), actual.toArray(new Ingredient[actual.size()]));

    }

    @Test
    @Transactional
    public void delete() throws Exception {
        ingredientDao.save(testCucumber);
        ingredientDao.delete(testCucumber.getId());
        Assert.assertNull(ingredientDao.findById(testCucumber.getId()));
    }

}