/**
 * Authors: Group Members
 * Purpose: Entry point to the AoA group project appliction to simulate retirement funding. 
 * It is a CLI application ran with Java. Thus you need java installed on your machine to run this. 
 * Just run this main.java file to start the program.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("====================================");
            System.out.println("      AofA Financial Services");
            System.out.println("====================================");
            System.out.println("1. Fixed Growth Simulation");
            System.out.println("2. Variable Growth Simulation");
            System.out.println("3. Retirement Expense Simulation");
            System.out.println("4. Maximum Sustainable Withdrawal");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.nextLine();
                continue;
            }

            System.out.println(); // spacing

            switch (choice) {

                case 1:
                    System.out.println("Running Fixed Growth Simulation...");
                    FixedGrowth.fixedGrowth();  
                    break;

                case 2:
                    System.out.println("===============================================");
                    System.out.println("    VARIABLE RETIREMENT GROWTH");
                    System.out.println("===============================================");

                    System.out.print("Enter starting principal: ");
                    double principal = scanner.nextDouble();

                    System.out.print("Enter number of years: ");
                    int years = scanner.nextInt();

                    double[] rateList = new double[years];

                   System.out.println("\nEnter yearly rates (e.g., 0.05 for 5%, -0.02 for -2%):");
                   for (int i = 0; i < years; i++) {
                       System.out.print("Rate for Year " + (i + 1) + ": ");
                       rateList[i] = scanner.nextDouble();
                    }

                    // THE FUNCTION CALL 
                    double finalBalance = VariableGrowth.variableInvestor(principal, rateList);

                    System.out.println("\n-----------------------------------------------");
                    System.out.printf("Final Balance After %d Years: $%.2f\n", years, finalBalance);
                    System.out.println("-----------------------------------------------");

                    break;

                case 3:
                    System.out.println("Running Retirement Expense Simulation...");
                    // This object executes everything in its constructor, no additional calls needed.
                    // - Marlon
                    FinallyRetired finallyRetired = new FinallyRetired(); 
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("Calculating Maximum Sustainable Withdrawal...");
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextFloat();

                    System.out.print("Enter annual rate (decimal, e.g., 0.05 for 5%): ");
                    double rate = scanner.nextFloat();

                    double maxWithdrawal = MaximumExpensed.maximumExpensed(balance, rate);
                    System.out.println("Maximum sustainable annual withdrawal: $" + String.format("%.2f", maxWithdrawal));
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose a valid option. \n");
                    scanner.next();
                    break;
            }
        }
    }
}
