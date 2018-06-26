package nl.sjtek.food.models;

/**
 * Created by wouter on 13-11-16.
 */
public class NextMeal {

    private boolean generated;
    private Meal meal;

    public boolean isGenerated() {
        return generated;
    }

    public Meal getMeal() {
        return meal;
    }

    public NextMeal set() {
        generated = false;
        meal = null;
        return this;
    }

    public NextMeal set(Meal meal) {
        this.generated = true;
        this.meal = meal;
        return this;
    }
}
