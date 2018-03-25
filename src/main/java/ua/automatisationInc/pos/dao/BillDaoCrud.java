package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import ua.automatisationInc.pos.models.Bill;

/**
 * Created by Pavel Grudina on 24.03.2018.
 */
public interface BillDaoCrud extends CrudRepository<Bill, Long> {
}
