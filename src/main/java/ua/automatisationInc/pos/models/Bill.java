package ua.automatisationInc.pos.models;

import ua.automatisationInc.pos.models.enums.BillStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
@Entity
@Table(name = "BILLS")
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "restId", nullable = false, unique = true)
    private long restId;

    private double bonus;

    private double price;

    private double totalPrice = price - bonus;

    private String comment;

    private int number;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private BillStatus status;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Dish> dishList = new ArrayList<>();


    public Bill(long id, double bonus, double price, String comment, int number, LocalDate date, List<Dish> dishList) {
        this.id = id;
        this.bonus = bonus;
        this.price = price;
        this.comment = comment;
        this.number = number;
        this.date = date;
        this.dishList = dishList;
    }

    public Bill() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public long getRestId() {
        return restId;
    }

    public void setRestId(long restId) {
        this.restId = restId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (getId() != bill.getId()) return false;
        if (getNumber() != bill.getNumber()) return false;
        if (getDate() != null ? !getDate().equals(bill.getDate()) : bill.getDate() != null) return false;
        return getDishList() != null ? getDishList().equals(bill.getDishList()) : bill.getDishList() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getNumber();
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getDishList() != null ? getDishList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", bonus=" + bonus + ", price=" + price + ", comment='" + comment + '\'' + ", number=" + number + ", date=" + date + ", dishList=" + dishList + '}';
    }
}
