/*
 * Written By Curtis Lynn
 */
package JavaTest;

public class Solution {

	public static String s = "abcbabccbabcba", processedString;
	public static StringBuilder temp;
	
	public static void main(String[] args) 
	{
		System.out.println(process(s));
	}
	
	static String process(String s) 
	{
		processedString = s.toUpperCase();
		
		while(processedString.contains("AA")) 
		{
			processedString = processing("AA");
		}
		
		while(processedString.contains("BB")) 
		{
			processedString = processing("BB");
		}
		
		while(processedString.contains("CC")) 
		{
			processedString = processing("CC");
		}
		if(processedString.contains("AA") || processedString.contains("BB") || processedString.contains("CC")) 
		{
			processedString = process(processedString);
		}
		return processedString;
	}
	
	public static String processing(String toCut) 
	{
		temp = new StringBuilder("");
		
		int cutPoint = processedString.indexOf(toCut);
			for(int i = 0; i < processedString.length(); i++) 
			{
				if(i != cutPoint && i != cutPoint + 1) 
				{
					temp.append(processedString.charAt(i));
				}
			}
			return temp.toString();
	}
}
