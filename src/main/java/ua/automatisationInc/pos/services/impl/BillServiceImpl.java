package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.exceptions.BillNotFoundEx;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.services.BillService;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
@Service
@Transactional(readOnly = true)
public class BillServiceImpl implements BillService {

    @Autowired
    BillDao billDao;

    @Override
    public Bill addDishToBill(long billId, Dish dish) {
        Bill bill = billDao.findOne(billId);
        bill.getDishList().add(dish);
        double price = 0;
        for (Dish temp : bill.getDishList()) {
            price += temp.getPrice();
        }
        bill.setPrice(bill.getPrice() + price);
        return bill;
    }

    @Override
    public void deleteDishFromBill(long billId, Dish dish) {
        if (billDao.findOne(billId) == null) {
            throw new BillNotFoundEx();
        }
        Bill bill = billDao.findOne(billId);
        bill.getDishList().remove(dish);
    }

    @Override
    public void cleanBill(long id) {
        Bill bill = billDao.findOne(id);
        bill.getDishList().clear();
        bill.setBonus(0);
        bill.setComment("");
        bill.setPrice(0);
    }

    @Override
    public double setBonus(long billId, int percent) {
        Bill bill = billDao.findOne(billId);
        return (bill.getPrice() * percent / 100);
    }

    @Override
    public void setBonus(long billId, double amount) {
        billDao.findOne(billId).setBonus(amount);
    }

    @Override
    public void setComment(long billId, String comment) {
        billDao.findOne(billId).setComment(comment);
    }

    @Override
    public Bill getBillById(long billId) {
        return billDao.findOne(billId);
    }

    @Override
    public Bill saveBill(Bill bill) {
        return billDao.save(bill);
    }

    @Override
    public void deleteBillById(long billId) {
        billDao.delete(billId);
    }
}
