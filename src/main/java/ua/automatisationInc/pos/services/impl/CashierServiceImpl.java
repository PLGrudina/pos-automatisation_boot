package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.dao.DishDao;
import ua.automatisationInc.pos.exceptions.BillNotFoundEx;
import ua.automatisationInc.pos.exceptions.DishNotFoundEx;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;
import ua.automatisationInc.pos.services.CashierService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

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

        if (!billDao.findById(billId).isPresent()) {
            throw new BillNotFoundEx();
        }
        Bill bill = billDao.findById(billId).get();
        bill.getDishList().add(dish);
        return dish;
    }

    @Override
    @Transactional
    public void deleteDishFromBill(long billId, Dish dish) {

        if (!billDao.findById(billId).isPresent()) {
            throw new BillNotFoundEx();
        }
        Bill bill = billDao.findById(billId).get();
        bill.getDishList().remove(dish);
    }

    @Override
    @Transactional
    public void cleanBill(long id) {
        if (!billDao.findById(id).isPresent()) {
            throw new BillNotFoundEx();
        }
        Bill bill = billDao.findById(id).get();
        bill.getDishList().clear();
        bill.setBonus(0);
        bill.setComment("");
        bill.setPrice(0);

    }

    @Override
    @Transactional
    public double setBonus(long billId, int percent) {
        if (!billDao.findById(billId).isPresent()) {
            throw new BillNotFoundEx();
        }
        Bill bill = billDao.findById(billId).get();
        return (bill.getPrice() * percent / 100);
    }

    @Override
    @Transactional
    public double setBonus(long billId, double amount) {
        if (!billDao.findById(billId).isPresent()) {
            throw new BillNotFoundEx();
        }
        Bill bill = billDao.findById(billId).get();
        bill.setBonus(amount);
        return amount;
    }

    @Override
    @Transactional
    public String setComment(long billId, String comment) {
        if (!billDao.findById(billId).isPresent()) {
            throw new BillNotFoundEx();
        }
        Bill bill = billDao.findById(billId).get();
        bill.setComment(comment);
        return comment;
    }

    @Override
    @Transactional
    public Bill getBill(long billId) {
        if (!billDao.findById(billId).isPresent()) {
            throw new BillNotFoundEx();
        }
        return billDao.findById(billId).get();
    }

    @Override
    @Transactional
    public List<Bill> getAllBillsByToDay(LocalDate date) {
        List<Bill> billsByDate = StreamSupport.stream(billDao.findAll().spliterator(), false).collect(toList());

        return billsByDate.stream().filter(bill -> bill.getDate().equals(date)).collect(toList());

    }

    @Override
    @Transactional
    public void saveBill(Bill bill) {
        billDao.save(bill);
    }

    @Override
    @Transactional
    public List<Dish> getDishesByType(DishType type) {
        List<Dish> allDish = StreamSupport.stream(dishDao.findAll().spliterator(),false).collect(toList());
        return allDish.stream().filter(dish -> dish.getCategory().equals(type)).collect(toList());
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
        if (!dishDao.findById(dishId).isPresent()) {
            throw new DishNotFoundEx();
        }

        return dishDao.findById(dishId).get();
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
