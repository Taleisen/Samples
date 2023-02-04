/*
 * Written by Curtis Lynn
 */
package WeekOne;
import java.util.Scanner;

public class FinancialPayRolApp {

	public static Scanner keyboard = new Scanner(System.in);
	public static String input = "", name = "";
	public static double hours, payrate, fedHold, stateHold, result;
	
	public static void main(String[] args) 
	{
		System.out.println("This application will collect information and provide a payroll statement.");
		name();
		hours = input("hours worked");
		payrate = input("rate of pay");
		fedHold = input("federal tax withholding rate");
		stateHold = input("state tax withholding rate");
		output();
	}
	
	public static void name() 
	{
		System.out.println("Please enter employee's name:");
		name = keyboard.nextLine();
	}
	
	public static double input(String inputType) 
	{
		System.out.printf("Please enter the %s:", inputType);
		input = keyboard.nextLine();
		if(isDouble(input)) 
		{
			result = Double.parseDouble(input);
			if(result <= 0) 
			{
				System.out.printf("The %s must be greater than 0.%n", inputType);
				input(inputType);
			}
		}
		else 
		{
			input(inputType);
		}
		
		return result;
	}
	
	public static boolean isDouble(String input) 
	{
		try 
		{
			Double.parseDouble(input);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input.");
			return false;
		}
		
	}
	
	public static void output() 
	{
		double grossPay = hours * payrate, fedHolding = (fedHold * grossPay)/100, stateHolding = (stateHold * grossPay)/100;
		System.out.printf("Name: %s%n"
				+ "Hours Worked: %.2f%n"
				+ "Pay Rate: $%.2f%n"
				+ "Gross Pay: $%.2f%n"
				+ "Deductions:%n"
				+ "Federal Withholding(%.2f%%): $%.2f%n"
				+ "State Withholding(%.2f%%): $%.2f%n"
				+ "Total Deductions: $%.2f%n"
				+ "Net Pay: $%.2f",
				name, hours, payrate, grossPay, fedHold, fedHolding, stateHold, stateHolding, fedHolding + stateHolding, grossPay - fedHolding - stateHolding);
	}

}
