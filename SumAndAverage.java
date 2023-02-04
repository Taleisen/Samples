/*
 * Written By Curtis Lynn
 */
package WeekOne;
import java.util.Scanner;

public class SumAndAverage {
	
	public static Scanner keyboard = new Scanner(System.in);
	public static int sum = 0, positives = 0, negatives = 0, count = 0;

	public static void main(String[] args) 
	{
		welcome();
		getInput();
		output();
	}
	
	public static void welcome() 
	{
		System.out.printf("This program will allow you to enter positive or negative integers until you enter the number 0.%n"
				+ "The program will then tell you how many positive and negative numbers were entered along with the sum of all values and the average.%n");
	}
	
	public static void getInput() 
	{
		int received = 0;
		
		do 
		{
			System.out.println("Please enter an integer:");
			String input = keyboard.nextLine();
			if(isInt(input)) 
			{
				received = Integer.parseInt(input);
				if(received > 0) 
				{
					positives++;
					count++;
				}
				else if(received < 0) 
				{
					negatives++;
					count++;
				}
				sum += received;
			}
			else 
			{
				System.out.println("Invalid Input.");
				getInput();
			}
		}
		while(received != 0);
	}
	
	public static void output() 
	{
		double average = 0;
		
		if(count > 0) 
		{
			average = (double)sum / count;
		}
		
		System.out.printf("The number of positive integers entered is %d.%n"
				+ "The number of negative integers entered is %d.%n"
				+ "The sum of all entered values is %d.%n"
				+ "The average of the entered values is %f.",
				positives, negatives, sum, average);
	}
	
	public static boolean isInt(String input) 
	{
		try 
		{
			Integer.parseInt(input);
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}

}
