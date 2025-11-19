import java.util.Scanner;

public class FixedGrowth {

    public static void fixedGrowth() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("   FIXED RETIREMENT GROWTH SIMULATION");
        System.out.println("===========================================\n");

        try {
            System.out.print("Enter principal amount: ");
            double principal = sc.nextDouble();

            System.out.print("Enter annual interest rate (e.g., 0.05 for 5%): ");
            double rate = sc.nextDouble();

            System.out.print("Enter number of years: ");
            int years = sc.nextInt();

            // Validate inputs
            if (principal < 0) {
                throw new IllegalArgumentException("Principal cannot be negative.");
            }
            if (rate < 0) {
                throw new IllegalArgumentException("Rate cannot be negative.");
            }
            if (years < 0) {
                throw new IllegalArgumentException("Years cannot be negative.");
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

        } catch (Exception e) {
            System.out.println("\nERROR: Invalid input. Please enter numbers only.");
        }

        sc.close();
    }
}
