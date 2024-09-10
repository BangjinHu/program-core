package design.factory.abstract_factory.impl;

import design.factory.abstract_factory.Color;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

