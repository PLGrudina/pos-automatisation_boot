package ua.automatisationInc.pos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.automatisationInc.pos.models.User;

/**
 * Created by Pavel Grudina on 07.04.2018.
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findOrderByUserLogin(String login);
}
