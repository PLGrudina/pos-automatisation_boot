package ua.automatisationInc.pos.dao;

import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.enums.BillStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
public interface BillDao {

    Bill save(Bill bill);

    Bill update(Bill bill);

    Bill saveOrUpdate(Bill bill);

    void delete(long id);

    void deleteByDate(LocalDate date);

    Bill findById(long billId);

    List<Bill> findAll();

    List<Bill> findByDate(LocalDate date);

    List<Bill> findByStatus(BillStatus status);
}
