package Structural.Proxy;

import java.util.*;
import java.util.logging.Logger;

public class ProxyMenu {
    public static void run(Scanner sc, Logger logger) {
        Map<String, Image> images = new HashMap<>();
        boolean back = false;

        while(!back) {
            System.out.println("\n--- Proxy Pattern: Image Viewer ---");
            System.out.println("1. Load Image");
            System.out.println("2. Display Image");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();
            switch(choice) {
                case "1":
                    System.out.print("Enter image filename: ");
                    String fname = sc.nextLine();
                    images.put(fname, new ProxyImage(fname));
                    logger.info("Image loaded: " + fname);
                    break;
                case "2":
                    if(images.isEmpty()) { System.out.println("No images loaded."); break; }
                    System.out.println("Loaded images:");
                    for(String f: images.keySet()) System.out.println("- " + f);
                    System.out.print("Enter image filename to display: ");
                    String displayName = sc.nextLine();
                    Image img = images.get(displayName);
                    if(img != null) img.display();
                    else System.out.println("Image not found!");
                    break;
                case "3": back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
