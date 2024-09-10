package design.factory.abstract_factory.impl;

import design.factory.abstract_factory.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
