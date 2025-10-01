package Structural.Decorator;

public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) { super(coffee); }
    public String getDescription() { return decoratedCoffee.getDescription() + ", Sugar"; }
    public double getCost() { return decoratedCoffee.getCost() + 1.0; }
}
