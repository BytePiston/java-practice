package design_patterns.factory_pattern;

public class ShapeFactory {
    IShape getShape(String shape) {
        switch (shape) {
            case "CIRCLE":
                return new Circle();
            case "TRIANGLE":
                return new Triangle();
            case "SQUARE":
                return new Square();
            default:
                throw new IllegalArgumentException();
        }
    }
}
