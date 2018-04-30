package ua.automatisationInc.pos.models.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Pavel Grudina on 06.04.2018.
 */
public enum UserRoles implements GrantedAuthority {
//    ADMIN,
//    CASHIER,
//    CHIEF
      USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
