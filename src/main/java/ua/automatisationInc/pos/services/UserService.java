package ua.automatisationInc.pos.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.automatisationInc.pos.models.User;
import ua.automatisationInc.pos.models.enums.UserRoles;

/**
 * Created by Pavel Grudina on 08.04.2018.
 */
public interface UserService extends UserDetailsService {

    User save (User user);

    User findById (long userId);

    void deleteUserById (long userId);

    void addUserRole (long userId, UserRoles role);

}
