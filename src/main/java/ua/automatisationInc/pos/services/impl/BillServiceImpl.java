package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.services.BillService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
@Service
@Transactional(readOnly = true)
public class BillServiceImpl implements BillService {

    @Autowired
    BillDao billDao;


    @Override
    public List<Bill> getAllBills() {
        return null;
    }

    @Override
    public double billSumByDate(LocalDate date) {
        return 0;
    }

    @Override
    public Bill createBill() {
        return null;
    }

    @Override
    public Bill addDishToBill(long billId, Dish dish) {
        return null;
    }

    @Override
    public void deleteDishFromBill(long billId, Dish dish) {

    }

    @Override
    public void cleanBill(long id) {

    }

    @Override
    public double setBonus(long billId, int percent) {
        return 0;
    }

    @Override
    public double setBonus(long billId, double amount) {
        return 0;
    }

    @Override
    public String setComment(long billId, String comment) {
        return null;
    }

    @Override
    public double getOrderPrice(Bill bill) {
        return 0;
    }

    @Override
    public Bill getBillById(long billId) {
        return null;
    }

    @Override
    public List<Bill> getAllBillsByToDay(LocalDate date) {
        return null;
    }

    @Override
    public void saveBill(Bill bill) {

    }

    @Override
    public void deleteBillById(long billId) {

    }
}
