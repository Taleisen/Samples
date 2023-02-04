/*
 * Written By Curtis Lynn
 */
package WeekOne;
import java.util.Scanner;

public class Datatypes_operators {

	public static int starting = 0, ending = 0;
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.println("This program will provide you with the squares and cubes of numbers between any starting and ending point.");
		init();
	}
	
	public static void init() 
	{
		starting = getNumber("starting");
		ending = getNumber("ending");
		test(starting, ending);
		keyboard.close();
		output(starting, ending);
	}
	
	public static int getNumber(String position) 
	{
		System.out.printf("Please enter the %s number:", position);
		String input = keyboard.nextLine();
		testInput(input, position);
		return Integer.parseInt(input);
	}
	
	public static void testInput(String input, String position) 
	{
		if(!isInteger(input)) 
		{
			getNumber(position);
		}
		
	}
	
	public static void test(int start, int end) 
	{
		if(end < start) 
		{
			System.out.println("End point value must be greater than start point value.");
			init();
		}
	}
	
	public static void output(int start, int end) 
	{
		for(int i = start; i <= end; i++) 
		{
			System.out.printf("%d	%d	%d%n", i, (i * i), (i * i * i));
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
			System.out.println("Input is not valid.");
			return false;
		}
	}

}
