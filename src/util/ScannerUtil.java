package util;

import java.util.Scanner;

public class ScannerUtil {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int captureMenu(){
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     VIDEO GAME MANAGEMENT SYSTEM     ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Add Video Game                    ║");
        System.out.println("║ 2. List Video Games                  ║");
        System.out.println("║ 3. View Details by ID                ║");
        System.out.println("║ 4. Edit Video Game                   ║");
        System.out.println("║ 5. Delete Video Game                 ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 6. Search / Filter / Sort            ║");
        System.out.println("║ 7. Log Play Session                  ║");
        System.out.println("║ 8. View Statistics                   ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 9. Save and Exit                     ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Select an option: ");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int menuList() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Show all games               ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int menuById() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Search for a game            ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int menuDelete() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Delete a game                ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int menuAdd() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Add a new game               ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String captureText(String message) {
        System.out.print(message + ": ");
        return SCANNER.nextLine();
    }

    public static int captureNumber(String message) {
        System.out.print(message + ": ");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static double captureDecimal(String message) {
        System.out.print(message + ": ");
        return Double.parseDouble(SCANNER.nextLine());
    }
}
