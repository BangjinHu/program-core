package design.builder.entity;

import design.builder.impl.ColdDrink;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "coke";
    }

    @Override
    public float price() {
        return 30.2f;
    }
}
