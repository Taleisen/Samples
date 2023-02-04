/*
 * Written By Curtis Lynn
 */
package Curtis_Lynn;
import java.util.*;

public class Duplicate_Remover {

	public static void main(String[] args) 
	{
		String input = "aaabbcdeeff";
		ArrayList<String> output = process(input);
		System.out.println(output);
	}
	
	public static ArrayList<String> process(String input) 
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < input.length(); i++) 
		{
			if(!temp.contains(input.substring(i, i+1)))
			{
				temp.add(input.substring(i, i+1));
			}
		}
		return temp;
	}

}
