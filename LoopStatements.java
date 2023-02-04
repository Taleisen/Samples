/*
 * Written By Curtis Lynn
 */
package WeekOne;

public class LoopStatements {

	public static void main(String[] args) 
	{
		generate();
	}
	
	public static void generate() 
	{
		for(int i = 1; i <= 7; i++) 
		{
			for(int j = 1; j <= 7; j++) 
			{
				if(i < j) 
				{
					System.out.print("*");
					continue;
				}
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
