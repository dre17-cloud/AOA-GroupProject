import java.util.*;

public class VariableGrowth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
    // My method 
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
