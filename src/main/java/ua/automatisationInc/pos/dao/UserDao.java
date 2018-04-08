package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import ua.automatisationInc.pos.models.User;

/**
 * Created by Pavel Grudina on 07.04.2018.
 */
public interface UserDao extends CrudRepository<User, Long> {
}
