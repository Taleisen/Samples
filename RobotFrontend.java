/*
 * Curtis Lynn
 */
import java.util.Scanner;
public class RobotFrontend {

	public static Scanner keyboard = new Scanner(System.in);
	public static char bot = '@', space = '_', hazard = 'X';//identification of pieces
	public static RobotBackend backend = new RobotBackend();
	public static char[][] board;
	
	public static void main(String[] args) 
	{
		Greet();
	}
	
	public static void Greet() 
	{
		//initialize settings
		String boardFile, defaultBoard = "board.txt", commandFile, defaultCommands = "robotCommands.txt";
		boardFile = defaultBoard;
		commandFile = defaultCommands;
		boolean mapSelected = false;
		
		
		do 
		{
			System.out.println("Greetings, this program provides you with a robot you can guide through a maze. Do you have a map?");//prompt for board file
			System.out.print("Please enter 1 to import a map, 2 to use the default map, 3 to build your own map, or 99 to exit this program.");
			String input = keyboard.nextLine();
			if(InputVerification(input)) //input is numeric
			{
				int answer = Integer.parseInt(input);
				switch(answer) 
				{
				case 1://user has map file
					System.out.print("Please enter the name of the file.");
					boardFile = keyboard.nextLine();
					mapSelected = true;
					break;
				case 2://user does not have map file
					System.out.println("We will use the default map.");
					mapSelected = true;
					break;
				case 3:
					board = backend.buildMap();
					if(board == null)
						Greet();
					mapSelected = true;
					ReadInstructions(commandFile, board);
					break;
				case 99://quit application
					keyboard.close();
					System.exit(0);
				default://user entered invalid number
					System.out.println("Invalid selection.");
				}
			}
		}
		while(!mapSelected);
		
		//backend = new RobotBackend();
		board = backend.ReadBoard(boardFile);//display the selected board
		if(board == null)
			Greet();
		ReadInstructions(commandFile, board);
		
	}
	
	public static void ReadInstructions(String commandFile, char[][] board) 
	{
		boolean commandsSelected = false;
		
		do 
		{
			System.out.println("Do you have a set of instructions to import?");//prompt for instruction set
			System.out.print("Please enter 1 to import instructions, 2 to use the default instructions, 3 to enter your own instructions, or 99 to exit this program.");
			String input = keyboard.nextLine();
			if(InputVerification(input)) 
			{
				int answer = Integer.parseInt(input);
				switch(answer) 
				{
				case 1://user has command file to import
					System.out.print("Please enter the name of the file.");
					commandFile = keyboard.nextLine();
					commandsSelected = true;
					break;
				case 2://user does not have command file
					System.out.println("We will use the default command set.");
					commandsSelected = true;
					break;
				case 3:
					Queue<String> commands = backend.buildCommands();
					commandsSelected = true;
					if(commands.head == null)
						ReadInstructions(commandFile, board);
					ExecuteCommands(board, commands);
					break;
				case 99://quit application
					keyboard.close();
					System.exit(0);
				default://invalid number entered
					System.out.println("Invalid selection.");
				}
			}
		}
		while(!commandsSelected);
		
		Queue<String> commands = backend.ReadCommands(commandFile);//create queue of commands
		if(commands == null)
			ReadInstructions(commandFile, board);
		ExecuteCommands(board, commands);//execute commands
	}
	
	public static boolean InputVerification(String input) 
	{
		try 
		{
			Integer.parseInt(input);//input is numeric
			return true;
		}
		catch(NumberFormatException e) 
		{
			System.out.println("Invalid input.");//non-numeric input
		}
		return false;
	}
	
	public static void ExecuteCommands(char[][] board, Queue<String> commands) 
	{
		String command;
		int xPos = 0, yPos = 0;//stores player position
		while(commands.head != null) //there are commands in the list
		{
			command = commands.Dequeue();//execute next command in the list
			if(command.equalsIgnoreCase("Move Up")) 
			{
				if(yPos == 0 || board[yPos - 1][xPos] == hazard) //encounter with outer wall or obstacle
				{
					System.out.println("CRASH!");
					System.exit(0);
				}
				else 
				{
					board[yPos][xPos] = space;//player character vacates current space
					yPos--;
					board[yPos][xPos] = bot;//player character enters new space
				}
			}
			else if(command.equalsIgnoreCase("Move Down")) 
			{
				if(yPos == board.length - 1 || board[yPos + 1][xPos] == hazard) //encounter with outer wall or obstacle
				{
					System.out.println("CRASH!");
					System.exit(0);
				}
				else 
				{
					board[yPos][xPos] = space;//player character vacates current space
					yPos++;
					board[yPos][xPos] = bot;//player character enters new space
				}
			}
			else if(command.equalsIgnoreCase("Move Right")) 
			{
				if(xPos == board[0].length - 1 || board[yPos][xPos + 1] == hazard) //encounter with outer wall or obstacle
				{
					System.out.println("CRASH!");
					System.exit(0);
				}
				else 
				{
					board[yPos][xPos] = space;//player character vacates current space
					xPos++;
					board[yPos][xPos] = bot;//player character enters new space
				}
			}
			else if(command.equalsIgnoreCase("Move Left")) 
			{
				if(xPos == 0 || board[yPos][xPos - 1] == hazard) //encounter with outer wall or obstacle
				{
					System.out.println("CRASH!");
					System.exit(0);
				}
				else 
				{
					board[yPos][xPos] = space;//player character vacates current space
					xPos--;
					board[yPos][xPos] = bot;//player character enters new space
				}
			}
			System.out.println("===========================");System.out.println("===========================");//used to help differentiate between moves
			
			for(int i = 0; i < board.length; i++) //print the board
			{
				for(int j = 0; j < board[0].length; j++) 
				{
					if(j < board[0].length - 1) 
					{
						System.out.print(board[i][j]);
					}
					else 
					{
						System.out.println(board[i][j]);
					}
				}
			}
		}
		boolean selected = false;
		do 
		{
			System.out.print("Would you like to play again? Please enter 1 for yes or 2 for no.");
			String input = keyboard.nextLine();
			if(InputVerification(input)) //verifies numeric response
			{
				int answer = Integer.parseInt(input);
				switch(answer) 
				{
				case 1://restart program
					Greet();
					selected = true;
					break;
				case 2://quit program
					keyboard.close();
					System.exit(0);
				}
			}
		}while(!selected);
	}

}
