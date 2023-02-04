/*
 * Written By Curtis Lynn
 */
package JavaTest;

public class MinSwap {

	public static void main(String[] args) 
	{
		int[] input = {10,5,6,6,3,2};
		System.out.println(minSwaps(input));
	}
	
	public static int minSwaps(int[] nums) 
	{
		int swapCount = 0;
		
		for(int i = 0; i < nums.length; i++) 
		{
			int temp, minloc = i;
			
			for(int j = i; j < nums.length; j++) 
			{
				if(nums[j] < nums[minloc]) 
				{
					minloc = j;
				}
			}
			
			if(minloc != i) 
			{
				temp = nums[minloc];
				nums[minloc] = nums[i];
				nums[i] = temp;
				++swapCount;
			}
		}
		
		return swapCount;
	}
}
