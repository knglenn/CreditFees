/* CreditFees by Kevin Glenn
Description: Calculates credit card payments based on member level, current balance, and whether or not the payment was late. 
*/

import java.util.Scanner;
public class CreditFees
{
	public static void main(String[] args)
	{	
		System.out.println("CreditFees by Kevin Glenn\n");
		Scanner scan = new Scanner(System.in);
		
		String late_payment;
		boolean late = false;
		String name;
		String level;
		String levelMatch;
		String levelLate;
		String jedi = "jedi";
		String padowan = "padowan";
		String youngling = "youngling";
		double principleRate = 0.0;
		double interestPayment = 0.0;
		double totalPayment = 0.0;
		double currentBalance = 0.0;
		double interestRate = 0.0;
		double percentToPrinciple;
		double percentToInterest;
		

		

		System.out.print("Customer name: ");
		name = scan.nextLine();

		
		System.out.print("Customer member level (jedi/padowan/youngling): ");
		level = scan.nextLine();

		while(!(level.equalsIgnoreCase("padowan") || level.equalsIgnoreCase("jedi") || level.equalsIgnoreCase("youngling")))
		{	
			System.out.println("Please enter a valid level.");
			level = scan.nextLine();
		}

		System.out.print("What is your current balance? ");
		currentBalance = scan.nextDouble();
		scan.nextLine();

		principleRate = currentBalance * .04;


		System.out.print("Was your payment late? " );
		String late1 = scan.nextLine();

		if(late1.equalsIgnoreCase("yes"))
		{
			late = true;
		}
		else if(late1.equalsIgnoreCase("no"))
		{
			late = false;
		}

		if(level.equalsIgnoreCase("jedi"))
		{		
			interestRate = currentBalance * .01;
			if(late)
			{
				interestRate = currentBalance * .02;
			}
		}

		if(level.equalsIgnoreCase("padowan"))
		{	
				interestRate = currentBalance * .018;
			if(late)
			{
				interestRate = currentBalance * .02 + 10;
			}
		}	
	
		if(level.equalsIgnoreCase("youngling"))
		{
				interestRate = currentBalance * .025;
			if(late)
			{
				interestRate = currentBalance * .035 + 20;
			}
		}

		if(level.equalsIgnoreCase("jedi"))
		{		
			totalPayment = currentBalance * .05;
			if(late)
			{
				totalPayment = currentBalance * .06;
			}
		}

		if(level.equalsIgnoreCase("padowan"))
		{		
			totalPayment = currentBalance * .058;
			if(late)
			{
				totalPayment = currentBalance * .068 + 10;
			}
		}

		if(level.equalsIgnoreCase("youngling"))
		{		
			totalPayment = currentBalance * .065;
			if(late)
			{
				totalPayment = currentBalance * .075 + 20;
			}
		}

		percentToPrinciple = 100 * (principleRate / totalPayment);
		percentToInterest = 100 - percentToPrinciple;
		


		System.out.println("\nBill for " + level + " customer " + name);
		System.out.printf("Card Balance: $%.2f\n", currentBalance);
		if(late)
		{
			System.out.printf("Interest for late payment: $%.2f\n", interestRate);

		}
		else 
		{
					
				System.out.printf("Interest for on-time payment: $%.2f\n", interestRate);
			
		}

		System.out.printf("Minimum payment to principle: $%.2f\n", principleRate);
		System.out.printf("Minimum total payment (payment and fees): $%.2f\n", totalPayment);
		System.out.printf("Percent to principle (4%% of principle): %.1f%%\n", percentToPrinciple);
		System.out.printf("Percent to interest and fees: %.1f%%\n", percentToInterest);
		
	}
}