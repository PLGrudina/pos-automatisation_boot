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
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.models.Bill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class BillDaoImplTest {

    @Autowired
    BillDao billDao;

    Bill bill;

    @Before
    public void setUp() throws Exception {
        bill = new Bill();
        bill.setPrice(30);
        bill.setComment("All");

    }

    @Test
    @Transactional
    public void save() throws Exception {
        billDao.save(bill);
        Assert.assertTrue(bill.getId() > 0);

    }

    @Test
    @Transactional
    public void findById() throws Exception {
        billDao.save(bill);
        Bill expected = billDao.findById(bill.getId());
        Assert.assertEquals(expected, bill);

    }

    @Test
    @Transactional
    public void delete() throws Exception {
        billDao.save(bill);
        billDao.delete(bill.getId());
        Assert.assertNull(billDao.findById(bill.getId()));

    }

    @Test
    @Transactional
    public void deleteByDate() throws Exception {
        bill.setDate(LocalDate.now());
        billDao.save(bill);
        billDao.deleteByDate(LocalDate.now());
        Assert.assertNull(billDao.findById(bill.getId()));

    }

    @Test
    @Transactional
    public void findAll() throws Exception {
        billDao.save(bill);
        List<Bill> actual = new ArrayList<>();
        actual.add(bill);
        List<Bill> expected = billDao.findAll();
        Assert.assertEquals(expected, actual);

    }

    @Test
    @Transactional
    public void findByDate() throws Exception {
        bill.setDate(LocalDate.now());
        billDao.save(bill);
        List<Bill> actual = new ArrayList<>();
        actual.add(bill);
        List<Bill> expected = billDao.findByDate(LocalDate.now());
        Assert.assertEquals(expected, actual);

    }

}