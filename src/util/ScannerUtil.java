package util;

import java.util.Scanner;

public class ScannerUtil {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int capturarMenu(){
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     VIDEO GAME MANAGEMENT SYSTEM     ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Add Video Game                    ║");
        System.out.println("║ 2. List Video Games                  ║");
        System.out.println("║ 3. View Details by ID                ║");
        System.out.println("║ 4. Edit Video Game                   ║");
        System.out.println("║ 5. Delete Video Game                 ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 6. Search / Filter / Sort (Stage 2)  ║");
        System.out.println("║ 7. Log Play Session (Stage 2)        ║");
        System.out.println("║ 8. View Statistics (Stage 2)         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 9. Save and Exit (Stage 3)           ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Select an option: ");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String capturarTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return SCANNER.nextLine();
    }

    public static int capturarNumero(String mensaje) {
        System.out.println(mensaje + ": ");

        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;
    }

    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return dato;
    }
}
