/*
 * Curtis Lynn
 */
import java.io.*;
import java.util.Scanner;
public class RobotBackend {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public char[][] ReadBoard(String fileName)
	{
		String[] lines = {};
		int lineCount = 0;
		
		try 
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			lineCount = 0;
			while(fileScanner.hasNextLine()) //count the lines in the document
			{
				fileScanner.nextLine();
				lineCount++;
			}
			if(lineCount == 0)//empty map
				return null;
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
		catch(FileNotFoundException e) 
		{
			System.out.println("File not found.");
			return null;
		}
		char bot = '@';
		char[][] board = new char[lines.length][lines[0].length()];
		for(int i = 0; i < lines.length; i++) //assign spaces and obstacles to location array
		{
			for(int j = 0; j < board[0].length; j++) 
			{
				board[i][j] = lines[i].charAt(j);
			}
		}
		board[0][0] = bot;//place player at top left
		PrintBoard(board);//print the board
		return board;
	}
	
	public Queue<String> ReadCommands(String fileName) 
	{
		Queue<String> commands = new Queue<String>();
		
		try 
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine()) //import all the lines in the document
			{
				String command = fileScanner.nextLine();
				if(command.equalsIgnoreCase("Move Up") 
						|| command.equalsIgnoreCase("Move Down") 
							|| command.equalsIgnoreCase("Move Left") 
								|| command.equalsIgnoreCase("Move Right")) //filters for valid commands
				{
					commands.Enqueue(command);
				}
				else 
				{
					if(fileScanner.hasNextLine())
						fileScanner.nextLine();
				}
			}
			fileScanner.close();
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("File not found.");
			return null;
		}
		
		return commands;
	}
	
	public static char[][] buildMap() 
	{
		char[][] board;
		int x = 0, y = 0;
		boolean inputRows = false, inputColumns = false;
		while(!inputRows) 
		{
			System.out.print("How many rows would you like the map to have?");
			String input = keyboard.nextLine();
			if(RobotFrontend.InputVerification(input)) 
			{
				y = Integer.parseInt(input);
				inputRows = true;
			}
		}
		while(!inputColumns) 
		{
			System.out.print("How many columns would you like the map to have?");
			String input = keyboard.nextLine();
			if(RobotFrontend.InputVerification(input)) 
			{
				x = Integer.parseInt(input);
				inputColumns = true;
			}
		}
		board = PopulateBoard(x,y);
		PrintBoard(board);
		return board;
	}
	
	private static char[][] PopulateBoard(int x, int y)
	{
		char[][] board = new char[y][x];
		for(int i = 0; i < y; i++) 
		{
			for(int j = 0; j < x; j++) 
			{
				boolean blockSelected = false;
				while(!blockSelected) 
				{
					System.out.print("This is row " + i + " column " + j + ". Please enter 1 for an open block or 2 for an obstacle:");
					String input = keyboard.nextLine();
					if(RobotFrontend.InputVerification(input)) 
					{
						int answer = Integer.parseInt(input);
						switch(answer) 
						{
						case 1:
							board[i][j] = RobotFrontend.space;
							blockSelected = true;
							break;
						case 2:
							board[i][j] = RobotFrontend.hazard;
							blockSelected = true;
							break;
						default:
							System.out.println("Invalid selection.");
						}
					}
				}
			}
		}
		board[0][0] = RobotFrontend.bot;
		board[board.length - 1][board[0].length - 1] = RobotFrontend.space;
		return board;
	}
	
	public static void PrintBoard(char[][] board) 
	{
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[0].length; j++) 
			{
				if(j < board[0].length - 1) 
				{
					System.out.print(board[i][j]);
				}
				else
					System.out.println(board[i][j]);
			}
		}
	}
	
	public Queue<String> buildCommands()
	{
		boolean commandSelected = false, inputFinished = false;
		Queue<String> commands = new Queue<String>();
		while(!inputFinished) 
		{
			System.out.print("Please enter 8 for Move Up, 2 for Move Down, 4 for Move Left, 6 for Move Right, or 5 when finished.");
			String input = keyboard.nextLine();
			if(RobotFrontend.InputVerification(input)) 
			{
				int answer = Integer.parseInt(input);
				switch(answer) 
				{
				case 2:
					commands.Enqueue("Move Down");
					break;
				case 4:
					commands.Enqueue("Move Left");
					break;
				case 5:
					inputFinished = true;
					break;
				case 6:
					commands.Enqueue("Move Right");
					break;
				case 8:
					commands.Enqueue("Move Up");
					break;
				default:
					System.out.println("Invalid Input.");
				}
			}
		}
		return commands;
	}
}
