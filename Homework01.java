/*
 * Written by Curtis Lynn 
 */
import java.util.Scanner;
import java.io.*;
public class Homework01 {
	public static final String FILE_NAME = "./prizeFile.txt", DELIM = "\t";
	public static String[] selected = new String[5];
	public static Prize[] prizes;
	public static int totalValue = 0, winner = 3500, length = 2;
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//read prize file and populate prize and values information
		Init(FILE_NAME);
		NewGame();
	}
	
	public static void NewGame() 
	{
		//randomly select prizes for showcase
		PrizeSelect(prizes);
		//provide user with the names of the prizes, prompt for guess, determine win condition, and provide feedback to user
		Game(totalValue);
	}
	
	public static void Init(String fileName) 
	{
		String[] lines = {};
		int lineCount = 0;
		
		try //import the prize list
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			lineCount = 0;
			while(fileScanner.hasNextLine()) //count the lines in the document
			{
				fileScanner.nextLine();
				lineCount++;
			}
			lines = new String[lineCount];
			fileScanner = new Scanner(new File(fileName));
			for(int i = 0; i < lineCount; i++) //import all the lines
			{
				if(!fileScanner.hasNextLine()) 
				{
					break;
				}
				lines[i] = fileScanner.nextLine();
			}
			fileScanner.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		lineCount = 0;
		if(lines.length > 0) 
		{
			for(int i = 0; i < lines.length; i++) //count the lines that are formatted correctly
			{
				String[] splitString = lines[i].split(DELIM);
				if(splitString.length == length) 
				{
					lineCount++;
				}
			}
			if(lineCount > 0) 
			{
				prizes = new Prize[lineCount];
				for(int i = 0; i < lineCount; i++) 
				{
					String[] splitString = lines[i].split(DELIM);
					if(splitString.length == length) 
					{
						prizes[i] = new Prize((int)Integer.parseInt(splitString[1]), splitString[0]);
					}
				}
			}
		}
	}
	
	public static void PrizeSelect(Prize[] prizes) 
	{
		boolean selectionMade = false;
		
		//select prizes
		for(int i = 0; i < selected.length; i++) 
		{
			selectionMade = false;
			do {
				//select a random value between 0 and 1
				double random = Math.random();
				//multiply result by number of possible prizes to select the specific prize
				int selection = (int)(random * (prizes.length));
				//check to see if that number has been selected before
				if(prizes[selection].beenSelected) //if it has been selected
				{
					continue;//make another selection
				}
				else//if it has not been selected, add the name to the list of prizes and add the value to the total 
				{
					//System.out.println("I have selected the " + prizes[selection].getName());
					prizes[selection].beenSelected = true;
					selected[i]= prizes[selection].getName();
					totalValue += prizes[selection].getValue();
					selectionMade = true;
				}
				}
			while(!selectionMade);
		}
	}
	
	public static void Game(int value) 
	{
		System.out.println("Welcome to the showcase. You will be shown the names of five items.");
		System.out.println("You will then be asked to guess the combined value of the items in your showcase.");
		System.out.println("If you can guess the combined value within $" + winner + " without going over, you win.");
		System.out.println("Good Luck!");
		
		for(int i = 0; i < prizes.length; i++)//reset prize selection for future playthroughs 
		{
			if(prizes[i] != null)
				prizes[i].Reset();
		}
		
		boolean validInput = false;
		do 
		{
			System.out.println("The prizes in your showcase are:");
			
			for(String s : selected) 
			{
				System.out.println(s);
			}
			
			System.out.print("Please enter your guess for the combined value of your showcase:");
			try 
			{
				int guess = Integer.parseInt(keyboard.next());
				int difference = totalValue - guess;
				System.out.println("The actual value of your showcase is $" + totalValue);
				if(difference < 0)//they guessed too high 
				{
					System.out.println("Sorry, you guessed too high.");
					EndGame();
				}
				else if(difference < winner) 
				{
					System.out.println("The difference is $" + difference + " You Win!");
					EndGame();
				}
				else 
				{
					System.out.println("The difference is $" + difference + " Sorry, your guess was more than $" + winner + " away from the actual value.");
					EndGame();
				}
			}
			catch(Exception e) 
			{
				System.out.println("Invalid Input.");
				continue;
			} 
			}
		while(!validInput);
	}
	
	public static void EndGame() 
	{
		boolean validInput = false;
		do 
		{
			System.out.print("Would you like to play again? Enter 1 for yes or 2 for no: ");
			try 
			{
				int response = Integer.parseInt(keyboard.next());
				if(response == 1) 
				{
					validInput = true;
					NewGame();
				}
				else if(response == 2) 
				{
					validInput = true;
					keyboard.close();
					System.exit(0);
				}
			}
			catch(Exception e) 
			{
				System.out.print(e);
			}
		}
		while(!validInput);
	}
}
