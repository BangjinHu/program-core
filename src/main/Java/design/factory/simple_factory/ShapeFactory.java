package design.factory.simple_factory;

import design.factory.simple_factory.impl.Circle;
import design.factory.simple_factory.impl.Rectangle;
import design.factory.simple_factory.impl.Square;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        return null;
    }
}
