/**
 * Author: Marlon Cockett
 * Purpose: To simulate the years until an initial given balance for a retirement fund would be depleted given a user-specified
 * interest rate and annual expense withdrawal amount.
 */
import java.util.Scanner;

public class FinallyRetired {
    private int year = 0;
    // I am using arrays here because java does not have pass-by-reference and I do not have the time to write a cleaner solution to this. 
    // It works for a small project like this. 
    private float[] balance = {0};
    private float[] expense = {0};
    private float[] rate = {0};
    Scanner scanner = new Scanner(System.in);

    // Constructor handles everything once object is created.
    public FinallyRetired() {
        promptInput("balance (positive non-zero integer)", balance);
        promptInput("rate (enter percentage as decimal eg 0.01 for 1%)", rate);
        promptInput("expense (must be greater than rate gained in first year for algorithm to terminate)", expense);
        finallyRetired();
        System.out.println("Number of years until depletion: " + getYear());
        // scanner.close();
    }

    // Resuable utility for prompting the user for the algo inputs. This is the reason the class members are arrays. 
    // To simulate pass-by-reference. I'm sure the programming gods will forgive this trangression.
    public void promptInput(String name, float[] value) {
        System.out.print("Enter " + name + ": ");
        if(scanner.hasNextFloat()) {
            value[0] = scanner.nextFloat();
        } else {
            System.out.println("Invalid input, try again!");
            scanner.next();
            promptInput(name, value);
        }
    }

    public int getYear() {
        return year;
    }

    // Main Algorithm.
    public void finallyRetired() {
        while (balance[0] > 0) {
            balance[0] = balance[0] * (rate[0] + 1);
            balance[0] = balance[0] - expense[0];
            year = year + 1;
        }
    }
}
