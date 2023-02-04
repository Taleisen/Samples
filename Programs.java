/*
 * Written By Curtis Lynn
 */
package WeekOne;

public class Programs {

	public static void main(String[] args) 
	{
		output();
	}
	
	public static void output() 
	{
		int size = 6;
		
		for(int i = 1; i < size; i++) 
		{
			int skip = size - i;
			for(int j = 0; j < skip; j++) 
			{
				System.out.print(" ");
			}
			for(int k = 0; k < i; k++) 
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
