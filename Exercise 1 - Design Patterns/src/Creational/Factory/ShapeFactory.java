package Creational.Factory;

public class ShapeFactory {
    public static Shape createShape(String type) {
        switch(type.toLowerCase()) {
            case "circle": return new Circle();
            case "square": return new Square();
            case "rectangle": return new Rectangle();
            default: return null;
        }
    }
}
