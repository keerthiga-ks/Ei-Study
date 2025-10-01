package Creational.Factory;

import java.util.*;
import java.util.logging.Logger;

public class FactoryMenu {
    public static void run(Scanner sc, Logger logger) {
        boolean back = false;

        while(!back) {
            System.out.println("\n--- Factory Pattern: Shape Creator ---");
            System.out.println("1. Create Circle");
            System.out.println("2. Create Square");
            System.out.println("3. Create Rectangle");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();
            Shape shape = null;
            switch(choice) {
                case "1": shape = ShapeFactory.createShape("circle"); break;
                case "2": shape = ShapeFactory.createShape("square"); break;
                case "3": shape = ShapeFactory.createShape("rectangle"); break;
                case "4": back = true; continue;
                default: System.out.println("Invalid choice!"); continue;
            }
            if(shape != null) {
                shape.draw();
                logger.info("Created shape: " + shape.getClass().getSimpleName());
            }
        }
    }
}
