package ua.automatisationInc.pos.services;

import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
public interface BillService {

    Bill saveBill(Bill bill);

    void deleteBillById (long billId);

    Bill getBillById(long billId);

    Bill addDishToBill(long billId, Dish dish);

    void deleteDishFromBill(long billId, Dish dish);

    void cleanBill(long id);

    double setBonus(long billId, int percent);

    double setBonus(long billId, double amount);

    String setComment(long billId, String comment);

}