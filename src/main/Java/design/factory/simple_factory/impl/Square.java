package design.factory.simple_factory.impl;

import design.factory.simple_factory.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
