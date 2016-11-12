package nl.sjtek.food.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Dinner {

    @GeneratedValue
    @Id
    private Long id;
    private Date date;
    @ManyToOne
    @JoinColumn
    private Meal meal;

    public Dinner() {
    }

    public Dinner(Date date, Meal meal) {
        this.date = date;
        this.meal = meal;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dinner dinner = (Dinner) o;

        if (!id.equals(dinner.id)) return false;
        if (!date.equals(dinner.date)) return false;
        return meal.equals(dinner.meal);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + meal.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dinner{" +
                "date=" + date +
                ", meal=" + meal +
                '}';
    }
}
