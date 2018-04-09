package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.automatisationInc.pos.dao.UserDao;
import ua.automatisationInc.pos.models.User;
import ua.automatisationInc.pos.models.enums.UserRoles;
import ua.automatisationInc.pos.services.UserService;

/**
 * Created by Pavel Grudina on 09.04.2018.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(long userId) {
        return null;
    }

    @Override
    public void deleteUserById(long userId) {

    }

    @Override
    public void changeRole(long userId, UserRoles role) {

    }
}
