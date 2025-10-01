package Behavioural.State;

import java.util.*;
import java.util.logging.Logger;

public class StateMenu {
    public static void run(Scanner sc, Logger logger) {
        TrafficLight trafficLight = new TrafficLight();
        boolean back = false;

        while(!back) {
            System.out.println("\n--- State Pattern: Traffic Light ---");
            System.out.println("1. Show Current State");
            System.out.println("2. Advance to Next State");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();
            switch(choice) {
                case "1": System.out.println("Current Traffic Light: " + trafficLight.getState()); break;
                case "2": trafficLight.nextState(); 
                    System.out.println("Advanced to: " + trafficLight.getState()); 
                    logger.info("Traffic Light state changed to " + trafficLight.getState()); 
                    break;
                case "3": back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
