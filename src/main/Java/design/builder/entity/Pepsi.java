package design.builder.entity;

import design.builder.impl.ColdDrink;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "pepsi";
    }

    @Override
    public float price() {
        return 35.5f;
    }
}
