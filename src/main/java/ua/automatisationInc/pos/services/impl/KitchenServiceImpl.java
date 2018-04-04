package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.exceptions.BillNotFoundEx;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.services.KitchenService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by PavelGrudina on 05.04.2017.
 */
@Service
@Transactional(readOnly = true)
public class KitchenServiceImpl implements KitchenService {

    @Autowired
    BillDao billDao;

    @Override
    @Transactional
    public Bill showOrder(long id) {
        if (billDao.findOne(id) == null) {
            throw new BillNotFoundEx();
        }
        return billDao.findOne(id);
    }

    @Override
    public List<Bill> showAllOrders() {
        List<Bill> bills = StreamSupport.stream(billDao.findAll().spliterator(),false).collect(Collectors.toList());
        return bills;
    }
}
