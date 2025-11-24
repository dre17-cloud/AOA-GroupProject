//Kadedra Mason - 2304879

import java.util.Scanner;

public class MaximumExpensed {
	
	
    // Simulate balance depletion for a given annual withdrawal
	private static boolean smallWithdrawal(double balance, double rate, double withdrawal) {
		
		double tempBalance = balance;
		int safetyCounter = 0;
		
		while(tempBalance > 0) {
			
			tempBalance = tempBalance * (1 + rate) - withdrawal;
			safetyCounter++;
			
            // safety to prevent infinite loop if withdrawal is too small
			if(safetyCounter > 1000 || tempBalance > 1e12d) {
				return true; // withdrawal is too small
			}
			
		}
		return false; //balance depleted
		
	}
	
	// Binary Search to find maximum sustainable annual withdrawal
	public static double maximumExpensed(double balance, double rate) {
		
		double low = 0;
		double high = balance;
		double threshold = 0.01; // precision to 1 cent
		
		while((high - low) > threshold) {
			
			double mid = (low + high)/ 2.0d;
			
			if (smallWithdrawal(balance, rate, mid)) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return (low + high)/ 2.0d;
		
	}

}
