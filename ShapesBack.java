/*
 * Curtis Lynn
 */
import java.util.Scanner;
import java.io.*;
public class ShapesBack {
	
	private Checkers<Shape> tree = new Checkers<Shape>();
	private Scanner keyboard = new Scanner(System.in);
	
	public void greet() 
	{
		System.out.println("Welcome to the Shape Tree.");
		mainMenu();
	}
	
	private void mainMenu() 
	{
		System.out.println("Please make a selection:\n"
				+ "0- New Tree\n"
				+ "1- Add Shape\n"
				+ "2- Remove Shape\n"
				+ "3- Search for Shape\n"
				+ "4- Find Largest\n"
				+ "5- Remove All Shapes Larger than Provided Area\n"
				+ "6- Open Shape File\n"
				+ "7- Save Tree to Shape File\n"
				+ "8- Print Tree\n"
				+ "99- Quit Application");
		String input = keyboard.nextLine();
		if(inputCheck(input)) 
		{
			int answer = Integer.parseInt(input);
			
			switch(answer) 
			{
			case 0:
				newTree();
				break;
			case 1:
				addShape();
				break;
			case 2:
				removeShape();
				break;
			case 3:
				if(searchShape()) 
				{
					System.out.println("Shape found.");
				}
				else 
				{
					System.out.println("Shape not found.");
				}
				break;
			case 4:
				Comparable<Shape> largest = findLargest();
				System.out.println(largest);
				break;
			case 5:
				double target = 0;
				System.out.print("Please enter the target area:");
				String response = keyboard.nextLine();
				if(doubleCheck(response)) 
				{
					target = Double.parseDouble(response);
					if(target > 0) 
					{
						removeGreater(target);
						System.out.println("All Shapes with an Area Larger than " + response + " have been removed.");
					}
				}
				
				break;
			case 6:
				openFile();
				break;
			case 7:
				saveFile();
				break;
			case 8:
				print();
				break;
			case 99:
				quit();
				break;
			}
		}
		mainMenu();
	}
	
	public void quit() 
	{
		System.out.println("Goodbye.");
		System.exit(0);
	}
	
	public void print() 
	{
		System.out.println("Please make a selection:\n"
				+ "1- Print In-Order\n"
				+ "2- Print Pre-Order\n"
				+ "3- Print Post-Order\n"
				+ "4-Return to Main Menu\n"
				+ "99- Quit Application");
		String answer = keyboard.nextLine();
		if(inputCheck(answer)) 
		{
			int selection = Integer.parseInt(answer);
			
			switch(selection) 
			{
			case 1:
				System.out.println("The tree currently contains: ");
				tree.PrintInorder();
				break;
			case 2:
				System.out.println("The tree currently contains: ");
				tree.PrintPreorder();
				break;
			case 3:
				System.out.println("The tree currently contains: ");
				tree.PrintPostorder();
				break;
			case 4:
				break;
			case 99:
				quit();
				break;
			default:
				print();
			}
		}
	}
	
	private void addShape() 
	{
		System.out.println("Plese select shape to add:\n"
				+ "1- Circle\n"
				+ "2- Rectangle\n"
				+ "3- Right Triangle\n"
				+ "4- Return to Main Menu\n"
				+ "99- Quit Application");
		String input = keyboard.nextLine();
		if(inputCheck(input)) 
		{
			int answer = Integer.parseInt(input);
			switch(answer) 
			{
			case 1:
				boolean radiusEntered = false;
				while(!radiusEntered) 
				{
					System.out.print("Please enter the radius: ");
					String responseR = keyboard.nextLine();
					if(doubleCheck(responseR)) 
					{
						double myRad = Double.parseDouble(responseR);
						if(myRad > 0) 
						{
							radiusEntered = true;
							tree.Add(new Shape("Circle", myRad));
							System.out.println("Circle with radius of " + myRad + " added to the tree.");
						}
					}
				}
				break;
			case 2:
				boolean lengthEntered = false;
				while(!lengthEntered) 
				{
					System.out.print("Please enter the length:");
					String responseL = keyboard.nextLine();
					if(doubleCheck(responseL)) 
					{
						double myLen = Double.parseDouble(responseL);
						if(myLen > 0) 
						{
							lengthEntered = true;
							boolean widthEntered = false;
							while(!widthEntered) 
							{
								System.out.print("Please enter the width: ");
								String responseW = keyboard.nextLine();
								if(doubleCheck(responseW)) 
								{
									double myWid = Double.parseDouble(responseW);
									if(myWid > 0) 
									{
										widthEntered = true;
										tree.Add(new Shape("Rectangle", myLen, myWid));
										System.out.printf("Rectangle with length of %f and width of %f added.", myLen, myWid);
									}
								}
							}
						}
					}
				}
				break;
			case 3:
				boolean baseEntered = false;
				while(!baseEntered) 
				{
					System.out.print("Please enter the base: ");
					String responseB = keyboard.nextLine();
					if(doubleCheck(responseB)) 
					{
						double myBas = Double.parseDouble(responseB);
						if(myBas > 0) 
						{	
							baseEntered = true;
							boolean heightEntered = false;
							if(!heightEntered) 
							{
								System.out.print("Please enter the height: ");
								String responseH = keyboard.nextLine();
								if(doubleCheck(responseH)) 
								{
									double myHi = Double.parseDouble(responseH);
									if(myHi > 0) 
									{	
										heightEntered = true;
										tree.Add(new Shape(myBas, "Right Triangle", myHi));
										System.out.printf("Right Triangle with base of %f and height of %f added.", myBas, myHi);
									}
								}
							}
						}
					}
				}
				break;
			case 4:
				break;
			case 99:
				quit();
				break;
			default:
				addShape();
			}
		}
		else 
		{
			addShape();
		}
	}
	
	private void removeShape() 
	{
		System.out.println("Please make a selection:\n"
				+ "1- Remove a Circle by Radius\n"
				+ "2- Remove a Rectangle by Lenght and Width\n"
				+ "3- Remove a Right Triangle by Base and Height\n"
				+ "4- Return to the Main Menu\n"
				+ "99- Quit Application");
		String answer = keyboard.nextLine();
		if(inputCheck(answer)) 
		{
			int response = Integer.parseInt(answer);
			switch(response) 
			{
			case 1:
				removeCircle();
				break;
			case 2:
				removeRectangle();
				break;
			case 3:
				removeTriangle();
				break;
			case 4:
				mainMenu();
				break;
			case 99:
				quit();
				break;
			default:
				removeShape();
			}
		}
		else 
		{
			removeShape();
		}
	}
	
	private void removeCircle() 
	{
		System.out.print("Please Enter the Radius: ");
		String answer = keyboard.nextLine();
		if(doubleCheck(answer)) 
		{
			double response = Double.parseDouble(answer);
			if(response > 0) 
			{
				Shape target = new Shape("Circle", response);
				if(tree.Search(target)) 
				{
					tree.Remove(target);
					System.out.println("Circle with Radius " + response + " removed.");
				}
			}
		}
	}
	
	private void removeRectangle() 
	{
		double len = 0, wid = 0;
		boolean lenCh = false;
		while(!lenCh) 
		{
			System.out.print("Please Enter the Length: ");
			String lenResp = keyboard.nextLine();
			if(doubleCheck(lenResp)) 
			{
				len = Double.parseDouble(lenResp);
				if(len > 0) 
				{
					lenCh = true;
					boolean widCh = false;
					while(!widCh) 
					{
						System.out.print("Please Enter the Width: ");
						String widResp = keyboard.nextLine();
						if(doubleCheck(widResp)) 
						{
							wid = Double.parseDouble(widResp);
							if(wid > 0) 
							{
								widCh = true;
								Shape target = new Shape("Rectangle", len, wid);
								if(tree.Search(target)) 
								{
									tree.Remove(target);
									System.out.println("Rectangle with Length of " + len + " and Width of " + wid + " has been removed.");
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void removeTriangle() 
	{
		double bas = 0, hi = 0;
		boolean basCh = false;
		while(!basCh) 
		{
			System.out.print("Please Enter the Base: ");
			String basResp = keyboard.nextLine();
			if(doubleCheck(basResp)) 
			{
				bas = Double.parseDouble(basResp);
				if(bas > 0) 
				{
					basCh = true;
					boolean hiCh = false;
					while(!hiCh) 
					{
						System.out.print("Please Enter the Height: ");
						String hiResp = keyboard.nextLine();
						if(doubleCheck(hiResp)) 
						{
							hi = Double.parseDouble(hiResp);
							if(hi > 0) 
							{
								hiCh = true;
								Shape target = new Shape(bas, "Right Triangle", hi);
								tree.Remove(target);
								if(tree.Search(target)) 
								{
									System.out.println("Triangle with a Base of " + bas + " and a Height of " + hi + " has been removed.");
								}
							}
						}
					}
				}
			}
		}
	}
	
	private boolean searchShape() 
	{
		System.out.println("Please make a selection:\n"
				+ "1- Search for a Circle by Radius\n"
				+ "2- Search for a Rectangle by Length and Width\n"
				+ "3- Search for a Right Triangle by Base and Height\n"
				+ "4- Return to the Main Menu\n"
				+ "99- Quit Application");
		String answer = keyboard.nextLine();
		if(inputCheck(answer)) 
		{
			int response = Integer.parseInt(answer);
			switch(response) 
			{
			case 1:
				return searchCircle();
			case 2:
				return searchRectangle();
			case 3:
				return searchTriangle();
			case 4:
				mainMenu();
				return false;
			case 99:
				quit();
				return false;
			default:
				return searchShape();
			}
		}
		else 
		{
			return searchShape();
		}
	}
	private boolean searchCircle() 
	{
		double rad = 0;
		System.out.print("Please Enter the Radius: ");
		String answer = keyboard.nextLine();
		if(doubleCheck(answer)) 
		{
			rad = Double.parseDouble(answer);
			if(rad > 0) 
			{
				Shape circle = new Shape("Circle", rad);
				return tree.Search(circle);
			}
			else 
			{
				return searchCircle();
			}
		}
		return searchCircle();
	}
	
	private boolean searchRectangle() 
	{
		double len = 0, wid = 0;
		boolean lenCh = false;
		while(!lenCh) 
		{
			System.out.print("Please Enter the Length: ");
			String lenResp = keyboard.nextLine();
			if(doubleCheck(lenResp)) 
			{
				len = Double.parseDouble(lenResp);
				if(len > 0) 
				{
					lenCh = true;
					boolean widCh = false;
					while(!widCh) 
					{
						System.out.print("Please Enter the Width: ");
						String widResp = keyboard.nextLine();
						if(doubleCheck(widResp)) 
						{
							wid = Double.parseDouble(widResp);
							if(wid > 0) 
							{
								widCh = true;
								Shape rectangle = new Shape("Rectangle", len, wid);
								return tree.Search(rectangle);
							}
						}
					}
				}
			}
		}
		return searchRectangle();
	}
	
	private boolean searchTriangle() 
	{
		double bas = 0, hi = 0;
		boolean basCh = false;
		while(!basCh) 
		{
			System.out.print("Please Enter the Base: ");
			String basResp = keyboard.nextLine();
			if(doubleCheck(basResp)) 
			{
				bas = Double.parseDouble(basResp);
				if(bas > 0) 
				{
					basCh = true;
					boolean hiCh = false;
					while (!hiCh) 
					{
						System.out.print("Please Enter the Height: ");
						String hiResp = keyboard.nextLine();
						if(doubleCheck(hiResp)) 
						{
							hi = Double.parseDouble(hiResp);
							if(hi > 0) 
							{
								Shape triangle = new Shape(bas, "Right Triangle", hi);
								return tree.Search(triangle);
							}
						}
					}
				}
			}
		}
		return searchTriangle();
	}
	
	private Shape findLargest() 
	{
		Shape largest = null;
		largest = tree.findLargest();
		if(largest == null) //empty tree
		{
			System.out.println("The Shape Tree is empty.");
			mainMenu();
		}
		return largest;
	}
	
	private void removeGreater(double target) 
	{
		Shape temp = new Shape(target);
		if(findLargest().compareTo(temp) > 0) //area of largest node larger than target
		{
			tree.Remove(findLargest());//cut largest
			removeGreater(target);//recursive call
		}
	}
	
	private void newTree() 
	{
		tree = new Checkers<Shape>();
	}
	
	private void openFile() 
	{
		String fileName = "shapeFile.txt";
		System.out.println("Please make a selection:\n"
				+ "1- Enter a File Name\n"
				+ "2- Fill Tree with Default Values\n"
				+ "3- Return to Main Menu\n"
				+ "99- Quit Application");
		String input = keyboard.nextLine();
		if(inputCheck(input)) 
		{
			int selection = Integer.parseInt(input);
			switch(selection) 
			{
			case 1:
				System.out.print("Please Enter the File Name: ");
				fileName = keyboard.nextLine();
				newTree();
				init(fileName);
				break;
			case 2:
				newTree();
				init(fileName);
				break;
			case 3:
				mainMenu();
				break;
			case 99:
				quit();
				break;
			default:
				openFile();
			}
		}
		else 
		{
			openFile();
		}
	}
	
	private void  init(String fileName) 
	{
		LLQueue<String[]> stringList = new LLQueue<String[]>();
		String delim = "\t";
		try 
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine()) 
			{
				stringList.Enqueue(fileScanner.nextLine().split(delim));
				fillTree(stringList);
			}
			System.out.println("File Loaded.");
			return;
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("File not found.");
			return;
		}
	}
	
	private void fillTree(LLQueue<String[]> input) 
	{
		if(input.Peek().length > 0) 
		{
			
			String[] entry = input.Dequeue();
			if(entry[0].equalsIgnoreCase("Circle")) 
			{
				makeCircle(entry);
			}
			else if(entry[0].equalsIgnoreCase("Rectangle")) 
			{
				makeRectangle(entry);
			}
			else if(entry[0].equalsIgnoreCase("Right Triangle")) 
			{
				makeTriangle(entry);
			}
		}
	}
	
	private void makeCircle(String[] input) 
	{
		if(input.length == 2) 
		{
			Shape temp;
			if(doubleCheck(input[1])) 
			{
				double tempRad = Double.parseDouble(input[1]);
				if(tempRad > 0) 
				{
					temp = new Shape("Circle", tempRad);
					tree.Add(temp);
				}
			}
		}
	}
	
	private void makeRectangle(String[] input) 
	{
		if(input.length == 3) 
		{
			Shape temp;
			if(doubleCheck(input[1])) 
			{
				double tempLen = Double.parseDouble(input[1]);
				if(tempLen > 0) 
				{
					if(doubleCheck(input[2])) 
					{
						double tempWid = Double.parseDouble(input[2]);
						if(tempWid > 0) 
						{
							temp = new Shape("Rectangle", tempLen, tempWid);
							tree.Add(temp);
						}
					}
				}
			}
		}
	}
	
	private void makeTriangle(String[] input) 
	{
		if(input.length == 3) 
		{
			Shape temp;
			if(doubleCheck(input[1])) 
			{
				double tempBas = Double.parseDouble(input[1]);
				if(tempBas > 0) 
				{
					if(doubleCheck(input[2])) 
					{
						double tempHi = Double.parseDouble(input[2]);
						if(tempHi > 0) 
						{
							temp = new Shape(tempBas, "Right Triangle", tempHi);
							tree.Add(temp);
						}
					}
				}
			}
		}
	}
	
	private void saveFile() 
	{
		File file = null;
		System.out.print("Please Enter a Name for the File: ");
		String fileName = keyboard.nextLine();
		file = new File("./" + fileName);
		try 
		{
			Scanner fileScanner = new Scanner(file);
			boolean selected = false;
			while(!selected) 
			{
				System.out.println("Please make a selection:\n"
						+ "1- Replace\n"
						+ "2- Append\n"
						+ "3- Enter a Different Name\n"
						+ "4- Return to Main Menu\n"
						+ "99- Quit Application");
				String answer = keyboard.nextLine();
				if(inputCheck(answer)) 
				{
					int response = Integer.parseInt(answer);
					switch(response) 
					{
					case 1://Replace
						selected = true;
						try 
						{
							FileOutputStream writer = new FileOutputStream(fileName, false);
							LLQueue<String> treeFile = tree.convertedTree();
							for(int i = 0; i < treeFile.count; i++) 
							{
								String entry = treeFile.stringList()[i];
								if(entry == null) 
								{
									writer.close();
									return;
								}
								byte[] bytes = entry.getBytes();
								writer.write(bytes);
							}
							writer.close();
							System.out.println("File Saved.");
						}catch(Exception e1) 
						{
							e1.printStackTrace();
						}
						break;
					case 2://Append
						selected = true;
						try 
						{
							FileOutputStream writer = new FileOutputStream(fileName, true);
							LLQueue<String> treeFile = tree.convertedTree();
							for(int i = 0; i < treeFile.count; i++) 
							{
								String entry = treeFile.stringList()[i];
								if(entry == null) 
								{
									writer.close();
									return;
								}
								byte[] bytes = entry.getBytes();
								writer.write(bytes);
							}
							writer.close();
							System.out.println("File Saved.");
						}catch(Exception e1) 
						{
							e1.printStackTrace();
						}
						break;
					case 3://Different Name
						saveFile();
						break;
					case 4://Main Menu
						mainMenu();
						break;
					case 99://Quit
						quit();
						break;
					}
				}
			}
			fileScanner.close();
		}
		catch(FileNotFoundException e) 
		{
			try 
			{
				if(fileName.length() < 1) //empty string
				{
					saveFile();
				}
				FileOutputStream writer = new FileOutputStream(fileName, false);
				LLQueue<String> treeFile = tree.convertedTree();
				for(int i = 0; i < treeFile.count; i++) 
				{
					String entry = treeFile.stringList()[i];
					if(entry == null) 
					{
						writer.close();
						return;
					}
					byte[] bytes = entry.getBytes();
					writer.write(bytes);
				}
				writer.close();
				System.out.println("File Saved.");
			}catch(Exception e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	private boolean inputCheck(String input) //verify input is integer for menu navigation
	{
		try 
		{
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e) 
		{
			return false;
		}
	}
	
	private boolean doubleCheck(String input) //verify input is double for attribute
	{
		try 
		{
			Double.parseDouble(input);
			return true;
		}catch(NumberFormatException e) 
		{
			return false;
		}
	}
}
