package design.factory.abstract_factory.impl;

import design.factory.abstract_factory.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}