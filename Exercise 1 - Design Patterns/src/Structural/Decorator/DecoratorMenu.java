package Structural.Decorator;

import java.util.*;
import java.util.logging.Logger;

public class DecoratorMenu {
    public static void run(Scanner sc, Logger logger) {
        Coffee coffee = new SimpleCoffee();
        boolean back = false;

        while(!back) {
            System.out.println("\n--- Decorator Pattern: Coffee ---");
            System.out.println("1. Create Simple Coffee");
            System.out.println("2. Add Milk");
            System.out.println("3. Add Sugar");
            System.out.println("4. Show Coffee Details");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();
            switch(choice) {
                case "1": coffee = new SimpleCoffee(); logger.info("Simple coffee created"); break;
                case "2": coffee = new Milk(coffee); logger.info("Added Milk"); break;
                case "3": coffee = new Sugar(coffee); logger.info("Added Sugar"); break;
                case "4": 
                    System.out.println(coffee.getDescription() + " $" + coffee.getCost());
                    break;
                case "5": back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
