/*
 * Curtis Lynn
 * CSCE 146 Practice Exam01 Question01
 * Provided code
 * Make sure this at least compiles
 * You may write additional methods to help
 */
//Do not alter------------------------------------------------------------------------
public class Question02 {

	public static double[][] transpose(double[][] m)
	{
//------------------------------------------------------------------------------------	
		//Write your code here
		if(m == null) // verify input is not null
			return null;
		double[][] results = new double[m[1].length][m.length];// create new array with transposed lengths
		for(int i = 0; i < m[0].length; i++) //step through array dimensions
		{
			for(int j = 0; j < m.length; j++) //step through array elements
			{
				results[i][j] = m[j][i];//transpose elements
			}
		}
		return results;//return results
	}//Do not alter
	
	//Write any additional helper properties or methods here
	
	
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		double[][] a = {{1,2,3},{4,5,6}};
		double[][] resultVect = Question02.transpose(a);
		
		//Printing Results
		for(int i=0;i<resultVect.length;i++)
		{
			for(int j=0;j<resultVect[i].length;j++)
				System.out.print(resultVect[i][j]+" ");
			System.out.println();
		}
	}
	//--------------------------------------------------------------------------------
	
}//Do not alter

