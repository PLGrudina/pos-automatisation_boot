package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.dao.DishDao;
import ua.automatisationInc.pos.dao.IngredientDao;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;
import ua.automatisationInc.pos.services.CashierService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Konstantin on 20.03.2017.
 */
@Service
@Transactional(readOnly = true)
public class CashierServiceImpl implements CashierService {
    @Autowired
    private DishDao dishDao;
    @Autowired
    private BillDao billDao;

    @Override
    @Transactional
    public Bill createBill() {
        Bill bill = new Bill();
        billDao.save(bill);
        return bill;
    }

    @Override
    @Transactional
    public Dish addDishToBill(long billId, Dish dish) {

        Bill bill = billDao.findById(billId);
        bill.getDishList().add(dish);
        return dish;
    }

    @Override
    @Transactional
    public void deleteDishFromBill(long billId, Dish dish) {

        Bill bill = billDao.findById(billId);
        bill.getDishList().remove(dish);
    }

    @Override
    @Transactional
    public void cleanBill(long id) {
        Bill bill = billDao.findById(id);
        bill.getDishList().clear();
        bill.setBonus(0);
        bill.setComment("");
        bill.setPrice(0);

    }

    @Override
    @Transactional
    public double setBonus(long billId, int percent) {
        Bill bill = billDao.findById(billId);
        double bonus = bill.getPrice() * percent / 100;
        return bonus;
    }

    @Override
    @Transactional
    public double setBonus(long billId, double amount) {
        Bill bill = billDao.findById(billId);
        bill.setBonus(amount);
        return amount;
    }

    @Override
    @Transactional
    public String setComment(long billId, String comment) {
        Bill bill = billDao.findById(billId);
        bill.setComment(comment);
        return comment;
    }

    @Override
    @Transactional
    public Bill getBill(long billId) {
        return billDao.findById(billId);
    }

    @Override
    @Transactional
    public List<Bill> getAllBillsByToDay(LocalDate date) {
        return billDao.findByDate(date);
    }

    @Override
    @Transactional
    public void saveBill(Bill bill) {
        billDao.saveOrUpdate(bill);
    }

    @Override
    @Transactional
    public List<Dish> getDishesByType(DishType type) {
        return dishDao.findByType(type);
    }

    @Override
    @Transactional
    public List<DishType> getDishTypes() {
        List<DishType> dishTypes = new ArrayList<>();
        dishTypes.addAll(Arrays.asList(DishType.values()));
        return dishTypes;
    }

    @Override
    @Transactional
    public Dish getDishById(long dishId) {
        return dishDao.findById(dishId);
    }

    @Override
    public double getOrderPrice(Bill bill) {
        double price = 0;

        for (Dish dish : bill.getDishList()) {
            price += dish.getPrice();
        }
        return price;
    }
}
