package ua.automatisationInc.pos.models;

import ua.automatisationInc.pos.models.enums.UserRoles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Grudina on 06.04.2018.
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "restId", nullable = false, unique = true)
    private long restId;

    @Column(name = "userLogin", nullable = false)
    private String userLogin;

    @Column(name = "userPassword", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Dish> cashierBasket = new ArrayList<>();

    public User() {

    }

    public User(String userLogin, String userPassword, UserRoles role) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public long getRestId() {
        return restId;
    }

    public void setRestId(long restId) {
        this.restId = restId;
    }

    public List<Dish> getCashierBasket() {
        return cashierBasket;
    }

    public void setCashierBasket(List<Dish> cashierBasket) {
        this.cashierBasket = cashierBasket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!userLogin.equals(user.userLogin)) return false;
        if (!userPassword.equals(user.userPassword)) return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + userLogin.hashCode();
        result = 31 * result + userPassword.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login='" + userLogin + '\'' + ", password='" + userPassword + '\'' + ", role=" + role + '}';
    }
}
