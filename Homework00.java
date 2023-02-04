/*
 * Written By Curtis Lynn
 */
import java.util.Scanner;
public class Homework00 {

	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		Greeting();
	}
	
	//greets user and provides basis for user input
	public static void Greeting() 
	{
		boolean validInput = false;
		
		do 
		{
			System.out.print("Hello. Please enter 1 to add two vectors, 2 to subtract two vectors, 3 to find the magnitude of a vector, or 99 to quit: ");
			try 
			{
				int answer = Integer.parseInt(keyboard.next());
				double[] first = {0}, second = {0};
				switch(answer) 
				{
				case 1://vector addition
					System.out.print("How many elements are in the first vector?");
					int vector1 = isInt(keyboard.next());
					if(vector1 >= 0) 
					{
						first = getComponents(vector1);
					}
					else
						continue;
					System.out.print("How many elements are in the second vector?");
					int vector2 = isInt(keyboard.next());
					if(vector2 >= 0) 
					{
						if(vector1 != vector2) 
						{
							System.out.println("Vectors must be the same size to add.");
							continue;
						}
						second = getComponents(vector2);
					}
					double[] sum = vectorAddition(vector1, first, second);
					System.out.print("The sum is: (");
					for(int i = 0; i < sum.length; i++) 
					{
						System.out.print(sum[i] + " ");
					}
					System.out.println(")");
					break;
				case 2://vector subtraction
					System.out.print("How many elements are in the first vector?");
					int vector3 = isInt(keyboard.next());
					if(vector3 >= 0) 
					{
						first = getComponents(vector3);
					}
					else
						continue;
					System.out.print("How many elements are in the second vector?");
					int vector4 = isInt(keyboard.next());
					if(vector4 >= 0) 
					{
						if(vector3 != vector4) 
						{
							System.out.println("Vectors must be the same size to subtract.");
							continue;
						}
						second = getComponents(vector4);
					}
					double[] difference = vectorSubtraction(vector3, first, second);
					System.out.print("The difference is: ");
					for(int i = 0; i < difference.length; i++) 
					{
						System.out.print(difference[i] + " ");
					}
					System.out.println(")");
					break;
				case 3://vector magnitude
					double magnitude = getMagnitude();
					System.out.println("The magnitude of this vector is: " + magnitude);
					break;
				case 99://quit
					keyboard.close();
					System.exit(0);
				default://catch for invalid input
					System.out.println("Invalid Input.");
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
		}
		while(!validInput);
	}
	
	//find the magnitude of a vector
	public static double getMagnitude() 
	{
		double magnitude = 0, sum = 0;
		int input = -1;
		boolean validInput = false;
		
		do 
		{
			System.out.print("How many variables are in this vector? ");
			try 
			{
				input = Integer.parseInt(keyboard.next());
				validInput = true;
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
		
		}
		while(!validInput || input < 0);
		
		double[] components = getComponents(input);
		
		for(int i = 0; i < components.length; i++) 
		{
			sum += components[i] * components[i];
		}
		
		magnitude = Math.sqrt(sum);
		
		
		return magnitude;
	}
	
	//adds vectors
	public static double[] vectorAddition(int input, double[] first, double[] second) 
	{
		double[] addedVector = new double[input];
		for(int i = 0; i < addedVector.length; i++) 
			{
				addedVector[i] = first[i] + second[i];
			}
		return addedVector;
	}
	
	//subtracts vectors
	public static double[] vectorSubtraction(int input, double[] first, double[] second) 
	{
		double[] subtractedVector = new double[input];
		for(int i = 0; i < subtractedVector.length; i++) 
			{
				subtractedVector[i] = first[i] - second[i];
			}
		return subtractedVector;
	}
	
	//gathers the members of the arrays for the vectors
	public static double[] getComponents(int input) 
	{
		double[] components = new double[input];
		boolean validInput = false;
		for(int i = 0; i < input; i++) 
		{
			String ordinal;
			int remainder = (i % 10) + 1;
			switch(remainder) 
			{
			case 1:
				ordinal = "st";
				break;
			case 2:
				ordinal = "nd";
				break;
			case 3:
				ordinal = "rd";
				break;
			default:
				ordinal = "th";
			}
			
			do 
			{
				validInput = false;
				System.out.print("Please enter the " + (i + 1) + ordinal + " member.");
				try 
				{
					components[i] = Double.parseDouble(keyboard.next());
					validInput = true;
				}
				catch(Exception e) 
				{
					System.out.println(e);
				}
			}
			while(!validInput);
		}
		return components;
	}
	
	//verifies integer is valid value
	public static int isInt(String input) 
	{
		int test;
		try 
		{
			test = Integer.parseInt(input);
			return test;
		}
		catch(Exception e) 
		{
			return -1;
		}
	}
}
