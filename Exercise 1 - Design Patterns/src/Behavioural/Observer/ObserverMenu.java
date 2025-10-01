package Behavioural.Observer;

import java.util.*;
import java.util.logging.Logger;

public class ObserverMenu {
    public static void run(Scanner sc, Logger logger) {
        WeatherData weatherData = new WeatherData();
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Observer Pattern: Weather Station ---");
            System.out.println("1. Register Display Device");
            System.out.println("2. Remove Display Device");
            System.out.println("3. Update Temperature & Humidity");
            System.out.println("4. List Registered Devices");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Device name: ");
                        String name = sc.nextLine();
                        DisplayDevice newDevice = new DisplayDevice(name);
                        weatherData.registerObserver(newDevice);
                        logger.info("Device registered: " + name);
                        break;
                    case "2":
                        System.out.print("Device name to remove: ");
                        String removeName = sc.nextLine();
                        DisplayDevice toRemove = null;
                        for (DisplayDevice d : weatherData.getObservers()) {
                            if (d.getName().equalsIgnoreCase(removeName)) { toRemove = d; break; }
                        }
                        if (toRemove != null) {
                            weatherData.removeObserver(toRemove);
                            logger.info("Device removed: " + removeName);
                        } else System.out.println("Device not found!");
                        break;
                    case "3":
                        System.out.print("Temperature (°C): ");
                        float temp = Float.parseFloat(sc.nextLine());
                        System.out.print("Humidity (%): ");
                        float hum = Float.parseFloat(sc.nextLine());
                        if(temp<-50 || temp>60){System.out.println("Temp out of range!"); break;}
                        if(hum<0 || hum>100){System.out.println("Humidity out of range!"); break;}
                        weatherData.setMeasurements(temp, hum);
                        logger.info("Weather updated: Temp=" + temp + ", Hum=" + hum);
                        break;
                    case "4":
                        List<DisplayDevice> devices = weatherData.getObservers();
                        if(devices.isEmpty()) System.out.println("No registered devices.");
                        else { for(DisplayDevice d: devices) System.out.println("- " + d.getName()); }
                        break;
                    case "5": back = true; break;
                    default: System.out.println("Invalid choice!");
                }
            } catch(Exception e){System.out.println("Error: "+e.getMessage()); logger.warning(e.getMessage());}
        }
    }
}
