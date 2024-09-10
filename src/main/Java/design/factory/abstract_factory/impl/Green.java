package design.factory.abstract_factory.impl;

import design.factory.abstract_factory.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}

