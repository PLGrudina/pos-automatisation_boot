package ua.automatisationInc.pos.dao.impl;

import org.springframework.stereotype.Repository;
import ua.automatisationInc.pos.dao.BillDao;
import ua.automatisationInc.pos.models.Bill;
import ua.automatisationInc.pos.models.enums.BillStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
@Repository
public class BillDaoImpl implements BillDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bill save(Bill bill) {
        entityManager.persist(bill);
        return bill;
    }

    @Override
    public Bill update(Bill bill) {
        entityManager.merge(bill);
        return bill;
    }

    @Override
    public Bill saveOrUpdate(Bill bill) {
        if (bill.getId() > 0) {
            update(bill);
        } else {
            save(bill);
        }
        return bill;
    }

    @Override
    public void delete(long id) {
        Bill bill = entityManager.find(Bill.class, id);
        entityManager.remove(bill);
    }

    @Override
    public void deleteByDate(LocalDate date) {
        List<Bill> billList = entityManager.createQuery("from Bill where date like:billDate", Bill.class)
                .setParameter("billDate", date).getResultList();
        for (Bill bill : billList) {
            entityManager.remove(bill);
        }

    }

    @Override
    public Bill findById(long billId) {
        return entityManager.find(Bill.class, billId);
    }

    @Override
    public List<Bill> findAll() {
        return entityManager.createQuery("from Bill", Bill.class).getResultList();
    }

    @Override
    public List<Bill> findByDate(LocalDate date) {
        List<Bill> billList = entityManager.createQuery("from Bill where date like:billDate", Bill.class)
                .setParameter("billDate", date).getResultList();
        return billList;
    }

    @Override
    public List<Bill> findByStatus(BillStatus status) {
        List<Bill> billList = entityManager.createQuery("from Bill where status like:billStatus", Bill.class)
                .setParameter("billStatus", status).getResultList();
        return billList;
    }
}
