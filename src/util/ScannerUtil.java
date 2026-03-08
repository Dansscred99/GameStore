package util;

import java.util.Scanner;

public class ScannerUtil {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int captureMenu(){
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     VIDEO GAME MANAGEMENT SYSTEM     ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Add Video GameBase                ║");
        System.out.println("║ 2. List Video Games                  ║");
        System.out.println("║ 3. View Details by ID                ║");
        System.out.println("║ 4. Edit Video GameBase               ║");
        System.out.println("║ 5. Delete Video GameBase             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 6. Search / Filter / Sort            ║");
        System.out.println("║ 7. Log Play Session                  ║");
        System.out.println("║ 8. View Statistics                   ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 9. Save and Exit                     ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Select an option: ");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }

        return 0;
    }

    public static int ser_fil_sor_Menu(){
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     SELECT AN OPTION                 ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Search                            ║");
        System.out.println("║ 2. Filter                            ║");
        System.out.println("║ 3. Sort by                           ║");
        System.out.println("║ 4. Exit                              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Type your answer to search: ");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }
        return 0;
    }


    public static int sortMenu(){
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     SELECT A SORT OPTION             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Sort by Release Year              ║");
        System.out.println("║ 2. Sort by Title                     ║");
        System.out.println("║ 3. Sort by Rating                    ║");
        System.out.println("║ 4. Exit                              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Type your answer to search: ");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }
        return 0;
    }
    public static int filterMenu(){
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     SELECT A FILTER OPTION           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Filter by Genre                   ║");
        System.out.println("║ 2. Filter by Platform                ║");
        System.out.println("║ 3. Filter by Status                  ║");
        System.out.println("║ 4. Exit                              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Type your answer to search: ");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }
        return 0;
    }
    public static int searchMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Search again                 ║");
        System.out.println("║     2 - Return to menu               ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }

        return 0;
    }

    public static int menuList() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Show all games               ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }

        return 0;
    }

    public static int menuById() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Search for a game            ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }

        return 0;
    }

    public static int menuDelete() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Delete a game                ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }

        return 0;
    }

    public static int menuAdd() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     1 - Add a new game               ║");
        System.out.println("║     2 - Return to main menu          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Enter the option number: ");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }

        return 0;
    }

    public static String captureText(String message) {
        System.out.print(message + ": ");
        return SCANNER.nextLine();
    }

    public static int captureNumber(String message) {
        System.out.print(message + ": ");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }
        return 0;
    }

    public static double captureDecimal(String message) {
        System.out.print(message + ": ");
        try {
            return Double.parseDouble(SCANNER.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }

        return 0;

    }
    public static <T extends Enum<T>> T captureEnum(String message, Class<T> enumType) {
        while (true) {

            try {

                System.out.println(message);

                T[] values = enumType.getEnumConstants();

                for (int i = 0; i < values.length; i++) {
                    System.out.println((i + 1) + " - " + values[i]);
                }

                int option = captureNumber("Enter the option number");

                if (option >= 1 && option <= values.length) {
                    return values[option - 1];
                }

                System.out.println("Invalid option. Try again.\n");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
            }
        }
    }
}
