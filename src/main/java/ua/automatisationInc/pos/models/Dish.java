package ua.automatisationInc.pos.models;

import ua.automatisationInc.pos.models.enums.DishType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PavelGrudina on 21.03.2017.
 */
@Entity
@Table(name = "DISHES")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "restId", nullable = false, unique = true)
    private long restId;

    @Column(unique = true, length = 300)
    private String name;

    @Enumerated(EnumType.STRING)
    private DishType category;

    private double price;

    private double weight;

    private String url;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients = new ArrayList<>();

    @ElementCollection (targetClass = Double.class)
    @MapKeyClass(java.lang.String.class)
    private Map<String,Double> recipe = new HashMap<>();


    public Dish(String name, DishType category, double price, double weight, String url, List<Ingredient> ingredients, Map<String, Double> recipe) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.weight = weight;
        this.url = url;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    public Dish() {
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

    public DishType getCategory() {
        return category;
    }

    public void setCategory(DishType category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getRestId() {
        return restId;
    }

    public void setRestId(long restId) {
        this.restId = restId;
    }

    public Map<String, Double> getRecipe() {
        return recipe;
    }

    public void setRecipe(Map<String, Double> recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (getId() != dish.getId()) return false;
        if (getName() != null ? !getName().equals(dish.getName()) : dish.getName() != null) return false;
        if (getCategory() != dish.getCategory()) return false;
        return getIngredients() != null ? getIngredients().equals(dish.getIngredients()) : dish.getIngredients() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getIngredients() != null ? getIngredients().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", weight=" + weight +
                ", ingredients=" + ingredients +
                '}';
    }
}
