/*
 * Written By Curtis Lynn
 */
package WeekOne;
import java.util.Scanner;

public class LottoGame {

	public static int[] lotto, guess;
	public static StringBuilder lottery = new StringBuilder(""), selection = new StringBuilder("");
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		init();
		welcome();
		getInput();
		convertToString(guess, selection);
		outcome();
	}

	public static void init() 
	{
		lotto = new int[3];
		guess = new int[3];
		for(int i = 0; i < lotto.length; i++) 
		{
			lotto[i] = (int)(Math.random() * 10);
		}
		convertToString(lotto, lottery);
	}
	
	public static void welcome() 
	{
		System.out.printf("Welcome to the lotto! %nYou will provide a 3 digit number. %n"
				+ "If you guess the random number, you get $10,000! %n"
				+ "If you get all the digits, but not the right order you win $3,000!%n"
				+ "If you match one digit, you win $1000!%n");
	}
	
	public static void getInput() 
	{
		System.out.println("Please enter a three digit number:");
		String input = keyboard.nextLine();
		if(input.length() != guess.length) 
		{
			System.out.println("Invalid Input. Incorrect length.");
			input = "";
			getInput();
		}
		
		for(int i = 0; i < input.length(); i++) 
		{
			String test = "" + input.charAt(i);
			if(isInteger(test)) 
			{
				guess[i] = Integer.parseInt(test);
			}
			else 
			{
				System.out.println("Invalid Input. Non-numeric characters detected.");
				input = "";
				getInput();
			}
		}
		
	}
	
	public static boolean isInteger(String input) 
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
	
	public static void convertToString(int[] original, StringBuilder target) 
	{
		for(int i = 0; i < original.length; i++) 
		{
			target.append(original[i]);
		}
	}
	
	public static void outcome() 
	{
		System.out.printf("The lottery number was %s. You guessed %s.%n", lottery, selection);
		grandPrize();
		secondPlace();
		thirdPlace();
		System.out.println("Sorry, you did not win. Better luck next time.");
	}
	
	public static void grandPrize() 
	{
		for(int i = 0; i < lotto.length; i++) 
		{
			if(lotto[i] == guess[i]) 
			{
				continue;
			}
			else 
			{
				return;
			}
		}
		System.out.println("Congratulations! You have won the grand prize of $10,000! Lucky You!");
		System.exit(0);
	}
	
	public static void secondPlace() 
	{
		int matches = 0;
		for(int i = 0; i < lotto.length; i++) 
		{
			for(int j = 0; j < guess.length; j++) 
			{
				if(lotto[i] == guess[j]) 
				{
					matches++;
					break;
				}
			}
		}
		if(matches == lotto.length) 
		{
			System.out.println("Congratulations! You have won the second place prize of $3000!");
			System.exit(0);
		}
	}
	
	public static void thirdPlace() 
	{
		for(int i = 0; i < lotto.length; i++) 
		{
			for(int j = 0; j < guess.length; j++) 
			{
				if(lotto[i] == guess[j]) 
				{
					System.out.println("Congratulations! You have won the third place prize of $1000!");
					System.exit(0);
				}
			}
		}
	}
}
