/*
 * Curtis Lynn
 * CSCE 146 Practice Exam01 Question01
 * Provided code
 * Make sure this at least compiles
 * You may write additional methods to help
 */
//Do not alter------------------------------------------------------------------------
public class Question01 {

//------------------------------------------------------------------------------------	
	//Write your code here
	public static int[] subtractVect(int[] a, int[] b) //subtract vectors
	{
		if(a == null || b == null || a.length != b.length) //checks if either array is null or if they are the different lengths
		{
			return null;//if so it returns null
		}
		int[] c = new int[a.length];//creates array for return values
		for(int i = 0; i < a.length; i++)//step through array elements
		{
			c[i] = a[i] - b[i];//subtracts elements
		}
		return c;//returns results
	}
	
	//Write any additional helper properties or methods here
	
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		int[] a = {1,2,3};
		int[] b = {3,2,1};
		int[] resultVect = Question01.subtractVect(a, b);
		
		//Printing Results
		for(int i=0;i<resultVect.length;i++)
			System.out.println(resultVect[i]);
	}
	//--------------------------------------------------------------------------------

}//Do not alter

/*Solution Description
 * 
 */