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
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class DishDaoImplTest {


    @Autowired
    DishDao dishDao;

    Dish borsh;


    @Before
    public void setUp() throws Exception {
        borsh = new Dish();
        borsh.setName("Borsh");
        borsh.setWeight(502);
        borsh.setCategory(DishType.SANDWICH);
    }

    @Test
    @Transactional
    public void save() throws Exception {
        dishDao.save(borsh);
        Assert.assertTrue(borsh.getId() > 0);
    }

    @Test
    @Transactional
    public void findById() throws Exception {
        dishDao.save(borsh);
        Dish expected = dishDao.findById(borsh.getId());
        Assert.assertEquals(expected, borsh);

    }

    @Test
    @Transactional
    public void update() throws Exception {
        dishDao.save(borsh);
        double actualWeight = dishDao.findById(borsh.getId()).getWeight();
        borsh.setWeight(6300);
        dishDao.update(borsh);
        double expectedWeight = dishDao.findById(borsh.getId()).getWeight();
        Assert.assertNotEquals(expectedWeight, actualWeight, 0);
    }

    @Test
    @Transactional
    public void delete() throws Exception {
        dishDao.save(borsh);
        dishDao.delete(borsh.getId());
        Assert.assertNull(dishDao.findById(borsh.getId()));
    }


    @Test
    @Transactional
    public void findByName() throws Exception {
        dishDao.save(borsh);
        Dish expected = dishDao.findByName(borsh.getName());
        Assert.assertEquals(expected, borsh);

    }

    @Test
    @Transactional
    public void findByType() throws Exception {
        dishDao.save(borsh);
        List<Dish> expected = dishDao.findByType(borsh.getCategory());
        List<Dish> actual = new ArrayList<>();
        actual.add(borsh);
        Assert.assertEquals(expected,actual);

    }

    @Test
    @Transactional
    public void findAllDish() throws Exception {
        dishDao.save(borsh);
        List<Dish> actual = new ArrayList<>();
        actual.add(borsh);
        List<Dish> expected = dishDao.findAllDish();
        Assert.assertEquals(expected,actual);

    }

}