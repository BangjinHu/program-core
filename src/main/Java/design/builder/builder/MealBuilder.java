package design.builder.builder;

import design.builder.entity.ChickenBurger;
import design.builder.entity.Coke;
import design.builder.entity.Pepsi;
import design.builder.entity.VegBurger;
import design.builder.model.Meal;

public class MealBuilder {
    
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}