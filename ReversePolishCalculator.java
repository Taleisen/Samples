/*
 * Curtis Lynn
 */
public class ReversePolishCalculator {
	
	public int calculate(String input) 
	{
		LLStack<Integer> ValueStack = new LLStack<Integer>();
		int result = 0;//returned value
		String[] processor = input.split(" ");//splits the string so that the list can be populated
		for(int i = 0; i < processor.length; i++) 
		{
			try 
			{
				int a = Integer.parseInt(processor[i]);
				ValueStack.Push(a);//add new integer to list
			}
			catch(NumberFormatException e) 
			{
				if(processor[i].equals("+")) 
				{
					if(SizeCheck(ValueStack)) 
					{
						int b = ValueStack.Pop();
						int a = ValueStack.Pop();
						ValueStack.Push(a + b);//adds sum to the list
					}
					else
						return 0; //not formatted correctly
				}
				else if(processor[i].equals("-")) 
				{
					if(SizeCheck(ValueStack)) 
					{
						int b = ValueStack.Pop();
						int a = ValueStack.Pop();
						ValueStack.Push(a - b);//adds difference to the list
					}
					else
						return 0;//not formatted correctly
				}
				else if(processor[i].equals("*")) 
				{
					if(SizeCheck(ValueStack)) 
					{
						int b = ValueStack.Pop();
						int a = ValueStack.Pop();
						ValueStack.Push(a * b);//adds product to the list
					}
					else
						return 0;//not formatted correctly
				}
				else if(processor[i].equals("/")) 
				{
					if(SizeCheck(ValueStack)) 
					{
						int b = ValueStack.Pop();
						int a = ValueStack.Pop();
						if(b != 0) 
						{
							ValueStack.Push(a / b);//adds quotient to the list
						}
						else //dividing by zero
						{
							System.out.println("Division by zero is undefined.");
							return 0;//not formatted correctly
						}
					}
					else
						return 0;//not formatted correctly
				}
				else //there is a character or string that is not defined in the program
				{
					System.out.println("This expression is not properly formatted. Cannot contain non-numerical characters other than +, -, *, or /.");
					return 0;
				}
			}
		}
		if(ValueStack.Size() != 1) // more than one number remains after all operations are performed
		{
			System.out.println("This expression is not properly formatted. There are too many operands remaining.");
			return 0;//not formatted correctly
		}
		else 
		{
			result = ValueStack.Pop();//sets result for return after all operations are performed
		}
		return result;
	}
	
	public boolean SizeCheck(LLStack ValueStack) //checks that there are at least 2 elements to the list
	{
		if(ValueStack.Size() < 2) 
		{
			System.out.println("This expression is not properly formatted. There are not enough operands for the operation.");
			return false;//fewer than two elements
		}
		return true;
	}
}
