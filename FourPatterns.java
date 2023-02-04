/*
 * Written By Curtis Lynn
 */
package WeekOne;
import java.util.Scanner;

public class FourPatterns 
{
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		welcome();
	}
	
	public static void welcome() 
	{
		System.out.println("Please enter the letter for the pattern you want to display (a,b,c,d):");
		String input = keyboard.nextLine();
		if(input.length() > 1) 
		{
			System.out.println("Invalid Input.");
			welcome();
		}
		
		char selection = input.toLowerCase().charAt(0);
		
		switch(selection) 
		{
		case 'a':
			patternA();
		case 'b':
			patternB();
		case 'c':
			patternC();
		case 'd':
			patternD();
		default:
			System.out.println("Invalid Input.");
			welcome();
		}
	}
	
	public static void patternA() 
	{
		for(int i = 1; i <= 6; i++) 
		{
			for(int j = 1; j <= 6; j++) 
			{
				if(i < j) 
				{
					continue;
				}
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.exit(0);
	}
	
	public static void patternB() 
	{
		for(int i = 7; i >= 1; i--) 
		{
			for(int j = 1; j <= 6; j++) 
			{
				if(i <= j) 
				{
					continue;
				}
				System.out.print(j);
			}
			System.out.println();
		}
		System.exit(0);
	}
	
	public static void patternC() 
	{	
		for(int i = 1; i <= 6; i++) 
		{
			for(int j = 6; j >= 1; j--) 
			{
				if(i < j) 
				{
					System.out.print(" ");
					continue;
				}
				System.out.print(j);
			}
			System.out.println();
		}
		System.exit(0);
	}
	
	public static void patternD() 
	{	
		for(int i = 7; i >= 1; i--) 
		{
			for(int k = 7; k > i; k--) 
				{
					System.out.print(" ");
				}
			
			for(int j = 1; j <= 6; j++) 
			{
				
				if(i <= j) 
				{
					continue;
				}
				System.out.print(j);
			}
			System.out.println();
		}
		System.exit(0);
	}

}
