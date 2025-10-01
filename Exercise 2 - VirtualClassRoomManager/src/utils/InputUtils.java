package utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    // Read a line from the console
    public static String nextLine() {
        return scanner.nextLine().trim();
    }

    // Optional: Close scanner gracefully (call on program exit)
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
