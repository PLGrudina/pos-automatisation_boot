package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.services.KitchenService;

import java.util.List;

/**
 * Created by Konstantin on 20.03.2017.
 */
@Service
@Transactional(readOnly = true)
public class KitchenServiceImpl implements KitchenService {
    @Autowired
    BillDao billDao;

    @Override
    @Transactional
    public Bill showOrder(long id) {
        Bill bill = billDao.findById(id);
        return bill;
    }

    @Override
    public List<Bill> showAllOrders() {
        List<Bill> bills = billDao.findAll();
        return bills;
    }
}
