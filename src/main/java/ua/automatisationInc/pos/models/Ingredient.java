package ua.automatisationInc.pos.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
@Entity
@Table (name = "INGREDIENTS")
public class Ingredient {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column (name = "id", nullable = false, unique = true)
    private long id;

    @Column (unique = true, length = 300)
    private String name;

    private double weight;

    private LocalDate date;

    @ManyToMany (cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Dish> dishes = new ArrayList<>();

    public Ingredient(String name, double weight, LocalDate date, List<Dish> dishes) {
        this.name = name;
        this.weight = weight;
        this.date = date;
        this.dishes = dishes;
    }

    public Ingredient() {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (getId() != that.getId()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", date=" + date +
                '}';
    }
}
