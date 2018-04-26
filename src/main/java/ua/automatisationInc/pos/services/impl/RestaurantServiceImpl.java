package ua.automatisationInc.pos.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.RestaurantDao;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.Dish;
import ua.automatisationInc.pos.models.Ingredient;
import ua.automatisationInc.pos.models.User;
import ua.automatisationInc.pos.services.RestaurantService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Pavel Grudina on 09.04.2018.
 */
@Service
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    @Override
    public List<Dish> getAllDish(long restId) {
        return Lists.newArrayList(restaurantDao.allDishOrderById(restId));
    }

    @Override
    public List<Ingredient> getAllIngredient(long restId) {
        return Lists.newArrayList(restaurantDao.allIngredientOrderById(restId));
    }

    @Override
    public List<Bill> getAllBill(long restId) {
        return Lists.newArrayList(restaurantDao.allBillOrderById(restId));
    }

    @Override
    public List<User> getAllUser(long restId) {
        return Lists.newArrayList(restaurantDao.allUserOrderById(restId));
    }

//    @Override
//    public List<Bill> getBillByDate(LocalDate date) {
//        return Lists.newArrayList(restaurantDao.billListByDate(date));
//    }

//    @Override
//    public double billSumByDate(LocalDate date) {
//        double sum = 0;
//        for (Bill bill : getBillByDate(date)) {
//            sum += bill.getPrice();
//        }
//        return sum;
//    }

}
