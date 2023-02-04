/*
 * Written by Curtis Lynn 
 */
import java.util.Scanner;
import java.io.*;
public class Homework02FrontEnd {
	
	public static String fileName, defaultFileName = fileName = "Collection.txt";
	public static final String DELIM = "\t";
	public static GameDoubleLL list = new GameDoubleLL(), results = new GameDoubleLL();
	public static Scanner keyboard = new Scanner(System.in), fileScanner;

	public static void main(String[] args) 
	{
		Greeting();
	}
	
	public static void Greeting() 
	{
		boolean startAgain = true;
		do 
		{
			System.out.println("Greetings. This program can read a list of games with the consoles it was released on and allow you to search the list.\n"
					+ "Please press 1 to enter the name of a file to read, press 2 to read the default file, or 99 to exit the program.");
			try 
			{
				int input = Integer.parseInt(keyboard.nextLine());
				switch(input) 
				{
				case 1:
					System.out.print("Please enter the file name. \nPlease note that files must be formatted as follows: \"name of the game\" <tab> \"name of the console\" <end of line>");
					fileName = keyboard.nextLine();
					Init(fileName);
					break;
				case 2:
					fileName = defaultFileName;
					Init(fileName);
					break;
				case 99:
					keyboard.close();
					System.exit(0);
				default:
					System.out.println("Invalid Input");
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input.");
			}
		}
		while(startAgain);
	}
	
	public static void Init(String fileName) 
	{
		list = new GameDoubleLL();
		int length = 2;
		try 
		{
			fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine()) 
			{
				String[] splitString = fileScanner.nextLine().split(DELIM);
				if(splitString.length == length) 
				{
					list.add(splitString);
				}
			}
			fileScanner.close();
			list.reset();
			if(list.getCurrent() == null)
				return;
			Search(list);
		}
		catch(Exception e) 
		{
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
	public static void Search(GameDoubleLL database) 
	{
		System.out.print("Please enter your selection:\n1 Search for a game\n2 Display all games\n3 Choose a different save file\n99 Quit");
		try 
		{
			boolean validInput = false;
			int input = Integer.parseInt(keyboard.nextLine());
			switch (input)
			{
			case 1:
				//search protocol
				System.out.print("Please enter the name of the game you would like to search for or enter * to include all games:");
				String searchTerm = keyboard.nextLine();
				if(searchTerm.equals("*")) 
				{
					results = list;
				}
				else 
				{
					results = list.contains(searchTerm, 0);
				}
				
				list = results;
				list.print();
				
				System.out.print("Please enter the name of the console you would like to search for or enter * to include all consoles:");
				String console = keyboard.nextLine();
				if(console.equals("*")) 
				{
					results = list;
				}
				else 
				{
					results = list.contains(console, 1);
				}
				
				if(results == null) 
				{
					System.out.println("No results found");
					return;
				}
				results.print();//print the results of the search
				do 
				{
					System.out.print("Would you like to save search results to a file? Please enter your selection:\n1- yes\n2- no");//file output
					try 
					{
						int response = Integer.parseInt(keyboard.nextLine());
						switch(response) 
						{
						case 1:
							validInput = true;
							WriteFile();
							break;
						case 2:
							validInput = true;
							break;
						default:
							System.out.println("Invalid Input");
						}
					}
					catch(Exception e) 
					{
						e.printStackTrace();
					}
				}
				while(!validInput);
				break;
			case 2:
				list.print();
				break;
			case 3:
				System.out.print("Please enter the file name. \nPlease note that files must be formatted as follows: \"name of the game\" <tab> \"name of the console\" <end of line>");
				fileName = keyboard.nextLine();
				Init(fileName);
				break;
			case 99:
				keyboard.close();
				fileScanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid Input.");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void WriteFile() 
	{
		File file = null;
		System.out.print("Please enter the name you would like to give this file:");//gather file name
		String outputFile = keyboard.nextLine();
		
		try 
		{
			fileScanner = new Scanner(new File(outputFile));
			file = new File("./" + outputFile);
			boolean selected = false;
			do 
			{
				System.out.print("Please enter your selection:\n1- Replace existing file\n2- Append results to end of existing file");//if it exists offer option to append or replace
				try 
				{
					int answer = Integer.parseInt(keyboard.nextLine());
					switch(answer) 
					{
					case 1:
						//replace file
						selected = true;
						results.printToFile(file, false);
						break;
					case 2:
						//append file
						selected = true;
						results.printToFile(file, true);
						break;
					default:
						System.out.println("Invalid Input");
					}
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
			}
			while(!selected);
		}
		catch(FileNotFoundException e) 
		{
			file = new File("./" + outputFile);
			results.printToFile(file);//creates file if it does not exist
			System.out.println("Saved");
			return;
		}
	}
}
