package ua.automatisationInc.pos.services;

import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.enums.DishType;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Kostya on 22.03.2017.
 */
public interface CashierService {
    Bill createBill();

    Dish addDishToBill(long billId, Dish dish);

    void deleteDishFromBill(long billId, Dish dish);

    void cleanBill(long id);

    double setBonus(long billId, int percent);

    double setBonus(long billId, double amount);

    String setComment(long billId, String comment);

    double getOrderPrice (Bill bill);

    Bill getBill(long billId);

    List<Bill> getAllBillsByToDay(LocalDate date);

    void saveBill(Bill bill);

    List<Dish> getDishesByType(DishType type);

    List<DishType> getDishTypes();

    Dish getDishById(long dishId);
}
