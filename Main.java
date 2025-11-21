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
                    System.out.println("Running Variable Growth Simulation...");
                    double finalBalance = variableInvestor(principal, rateList);
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
                    // MaximumExpensed.maximumExpensed(); // TODO: Uncomment this when class gets added
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
