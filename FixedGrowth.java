import java.util.Scanner;

public class FixedGrowth {

    public static void fixedGrowth() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("   FIXED RETIREMENT GROWTH SIMULATION");
        System.out.println("===========================================\n");

        double principal = 0;
        double rate = 0;
        int years = 0;

        // PRINCIPAL INPUT
        while (true) {
            System.out.print("Enter principal amount: ");
            if (sc.hasNextDouble()) {
                principal = sc.nextDouble();
                if (principal >= 0) break;
                System.out.println("ERROR: Principal cannot be negative.\n");
            } else {
                System.out.println("ERROR: Please enter a valid number.\n");
                sc.next(); // clear invalid input
            }
        }

        // RATE INPUT
        while (true) {
            System.out.print("Enter annual interest rate (e.g., 0.05 for 5%): ");
            if (sc.hasNextDouble()) {
                rate = sc.nextDouble();
                if (rate >= 0) break;
                System.out.println("ERROR: Rate cannot be negative.\n");
            } else {
                System.out.println("ERROR: Please enter a valid number.\n");
                sc.next(); // clear invalid input
            }
        }

        // YEARS INPUT
        while (true) {
            System.out.print("Enter number of years: ");
            if (sc.hasNextInt()) {
                years = sc.nextInt();
                if (years >= 0) break;
                System.out.println("ERROR: Years cannot be negative.\n");
            } else {
                System.out.println("ERROR: Please enter a whole number.\n");
                sc.next(); // clear invalid input
            }
        }

        // Compound interest calculation
        double balance = principal;
        for (int i = 0; i < years; i++) {
            balance = balance * (1 + rate);
        }

        // Output final result
        System.out.println("\n-------------------------------------------");
        System.out.println("Final Balance After " + years + " Years: $"
                            + String.format("%.2f", balance));
        System.out.println("-------------------------------------------");
    }
}
