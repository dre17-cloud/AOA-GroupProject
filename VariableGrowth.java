import java.util.*;

public class VariableGrowth {

    // Main menu calls this method
    public static double variableInvestor(double principal, double[] rateList) {

        if (principal < 0)
            throw new IllegalArgumentException("Principal cannot be negative.");

        if (rateList == null)
            throw new IllegalArgumentException("Rate list cannot be null.");

        double balance = principal;

        // Apply each yearly rate
        for (double rate : rateList) {
            balance = balance * (1 + rate);
        }

        return balance;
    }
}
