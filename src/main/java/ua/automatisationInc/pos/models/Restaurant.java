package ua.automatisationInc.pos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Grudina on 07.04.2018.
 */
@Entity
@Table(name = "RESTAURANT")
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    String name;

    @Column(name = "restaurantLogin", nullable = false)
    private String userLogin;

    @Column(name = "restaurantPassword", nullable = false)
    private String userPassword;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Dish> allDish = new ArrayList<>();

    @OneToMany (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<User> allUser = new ArrayList<>();

    @OneToMany (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Bill> allBill = new ArrayList<>();

    @OneToMany (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Ingredient> allIngredient = new ArrayList<>();

    public Restaurant() {

    }

    public Restaurant(String name, String userLogin, String userPassword) {
        this.name = name;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Dish> getAllDish() {
        return allDish;
    }

    public void setAllDish(List<Dish> allDish) {
        this.allDish = allDish;
    }

    public List<User> getAllUser() {
        return allUser;
    }

    public void setAllUser(List<User> allUser) {
        this.allUser = allUser;
    }

    public List<Bill> getAllBill() {
        return allBill;
    }

    public void setAllBill(List<Bill> allBill) {
        this.allBill = allBill;
    }

    public List<Ingredient> getAllIngredient() {
        return allIngredient;
    }

    public void setAllIngredient(List<Ingredient> allIngredient) {
        this.allIngredient = allIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!userLogin.equals(that.userLogin)) return false;
        return userPassword.equals(that.userPassword);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + userLogin.hashCode();
        result = 31 * result + userPassword.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
