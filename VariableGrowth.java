import java.util.*;

public class VariableGrowth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter starting principal: ");
            double principal = sc.nextDouble();

            System.out.print("Enter number of years (size of rate list): ");
            int years = sc.nextInt();

            double[] rateList = new double[years];

            System.out.println("\nEnter yearly rates (e.g., 0.05 for 5%, -0.02 for -2%):");
            for (int i = 0; i < years; i++) {
                System.out.print("Rate for Year " + (i+1) + ": ");
                rateList[i] = sc.nextDouble();
            }

            // ✔ FUNCTION CALL HERE
            double finalBalance = variableInvestor(principal, rateList);

            System.out.println("\n-----------------------------------------------");
            System.out.printf("Final Balance After %d Years: $%.2f\n", years, finalBalance);
            System.out.println("-----------------------------------------------");

        } catch (Exception e) {
            System.out.println("\nERROR: Invalid input. Please enter numerical values only.");
        }

        sc.close();
    }

    // ✔ Your method stays inside THIS class
    public static double variableInvestor(double principal, double[] rateList) {

        if (principal < 0)
            throw new IllegalArgumentException("Principal cannot be negative.");
        if (rateList == null)
            throw new IllegalArgumentException("Rate list cannot be null.");

        double balance = principal;

        for (double rate : rateList) {
            balance = balance * (1 + rate);
        }

        return balance;
    }
}
