package Structural.Decorator;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) { super(coffee); }
    public String getDescription() { return decoratedCoffee.getDescription() + ", Milk"; }
    public double getCost() { return decoratedCoffee.getCost() + 1.0; }
}
