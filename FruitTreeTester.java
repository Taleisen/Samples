/*
 * Curtis Lynn
 */
import java.util.Scanner;
import java.io.*;
public class FruitTreeTester {

	private static LinkedBST tree = new LinkedBST();
	private static LLQueue<String[]> stringList = new LLQueue<String[]>();
	private static String delim = "\t";
	private static Scanner keyboard = new Scanner(System.in);
	private static int targetLength = 2;
	
	public static void main(String[] args) {
		greet();
	}

	public static void greet() 
	{
		System.out.print("Greetings. Welcome to the fruit tree.\nPlease enter the name of a file to load: ");
		String input = keyboard.nextLine();
		retrieveFile(input);
		System.out.println("Tree filled.");
		mainMenu();
	}
	
	private static void mainMenu() 
	{
		System.out.println("Please enter 1 to print in Pre-order format, \n"
				+ "2 to print in In-order format, \n"
				+ "3 to print in Post-order format, \n"
				+ "4 to remove an element from the tree, \n"
				+ "or 99 to exit the program.");
		int selection = keyboard.nextInt();
		keyboard.nextLine();
		switch(selection) 
		{
		case 1:
			printPreOrder();
			break;
		
		case 2:
			printInOrder();
			break;
		
		case 3:
			printPostOrder();
			break;
			
		case 4:
			System.out.print("Please enter the type of fruit you would like to remove: ");
			String name = keyboard.nextLine();
			System.out.print("Please enter the weight of the fruit: ");
			double mass = keyboard.nextDouble();
			keyboard.nextLine();
			Fruit pickMe = new Fruit(name, mass);
			removeItem(pickMe);
			break;
		
		case 99:
			System.exit(0);
		}
	}
	
	private static void printPreOrder() 
	{
		System.out.println("Printing Pre-Order:");
		tree.PrintPreorder();
		System.out.println("#######################");
		mainMenu();
	}
	
	private static void printInOrder() 
	{
		System.out.println("Printing In-Order:");
		tree.PrintInorder();
		System.out.println("#######################");
		mainMenu();
	}
	
	private static void printPostOrder() 
	{
		System.out.println("Printing Post-Order:");
		tree.PrintPostorder();
		System.out.println("#######################");
		mainMenu();
	}
	
	private static void removeItem(Fruit target) 
	{
		System.out.println("Removing " + target.getType() + "\t" + target.getWeight());
		tree.Remove(target);
		System.out.println("#######################");
		System.out.println("Printing In-Order:");		
		tree.PrintInorder();
		mainMenu();
	}
	
	public static void retrieveFile(String input) 
	{
		try 
		{
			Scanner fileScanner = new Scanner(new File(input));
			while(fileScanner.hasNextLine()) 
			{
				stringList.Enqueue(fileScanner.nextLine().split(delim));//add each line to list
			}
		}
		catch(FileNotFoundException e) 
		{
			System.out.print("I could not find that file. Please enter the name of a file to load: ");
			input = keyboard.nextLine();
			retrieveFile(input);
		}
		
		while(stringList.count > 0) //split the strings
		{
			fillTree(stringList);
		}
		
		
	}
	
	public static void fillTree(LLQueue<String[]> splitStrings) //add correctly formatted strings to the tree
	{
		int count = 0;
		while(splitStrings.count > 0) 
		{
			String[] entry = splitStrings.Dequeue();
			
			if(entry.length == targetLength) 
			{
				count++;
				tree.Add(new Fruit(entry[0], Double.parseDouble(entry[1])));
			}
			else 
			{
				return;
			}
		}
	}
}
