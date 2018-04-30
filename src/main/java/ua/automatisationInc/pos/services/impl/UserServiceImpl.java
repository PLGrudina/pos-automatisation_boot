package ua.automatisationInc.pos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.automatisationInc.pos.dao.UserDao;
import ua.automatisationInc.pos.models.User;
import ua.automatisationInc.pos.models.enums.UserRoles;
import ua.automatisationInc.pos.services.UserService;

/**
 * Created by Pavel Grudina on 09.04.2018.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(long userId) {
        return userDao.findOne(userId);
    }

    @Override
    public void deleteUserById(long userId) {
        userDao.delete(userId);
    }

    @Override
    public void changeRole(long userId, UserRoles role) {
        userDao.findOne(userId).setRole(role);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDao.findOrderByUserLogin(login).;
    }
}
