package src;

import Behavioural.Observer.ObserverMenu;
import Behavioural.State.StateMenu;
import Creational.Factory.FactoryMenu;
import Creational.Prototype.PrototypeMenu;
import Structural.Decorator.DecoratorMenu;
import Structural.Proxy.ProxyMenu;
import java.util.*;
import java.util.logging.Logger;

public class DesignPatternsDemo {
    public static void main(String[] args) {
        Logger logger = LoggerSetup.setupLogger();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("\n=== Design Patterns Menu ===");
            System.out.println("1. Observer Pattern (Weather Station)");
            System.out.println("2. State Pattern (Traffic Light)");
            System.out.println("3. Factory Pattern (Shape Creator)");
            System.out.println("4. Prototype Pattern (Document Cloning)");
            System.out.println("5. Decorator Pattern (Coffee)");
            System.out.println("6. Proxy Pattern (Image Viewer)");
            System.out.println("7. Exit");
            System.out.print("Choose a use case to run: ");

            String choice = sc.nextLine();

            switch(choice) {
                case "1": ObserverMenu.run(sc, logger); break;
                case "2": StateMenu.run(sc, logger); break;
                case "3": FactoryMenu.run(sc, logger); break;
                case "4": PrototypeMenu.run(sc, logger); break;
                case "5": DecoratorMenu.run(sc, logger); break;
                case "6": ProxyMenu.run(sc, logger); break;
                case "7": exit = true; System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }
}
