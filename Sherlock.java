/*
 * Written By Curtis Lynn
 */
package JavaTest;
import java.util.*;

public class Sherlock {

	public static String s = "abcdefghhgfedecba";
	
	public static void main(String[] args)
	{
		isValid(s);
	}

	public static void isValid(String input) 
	{
		List<String> characters = new ArrayList<String>(), unique = new ArrayList<String>();
		List<Integer> count = new ArrayList<Integer>();
		int tempCount = 1, counts = 0;
		for(int i = 0; i < input.length(); i++) 
		{
			characters.add(input.toLowerCase().substring(i, i+1));
		}
		characters.sort(null);
		for(String s: characters) 
		{
			if(unique.contains(s)) 
			{
				++tempCount;
			}
			else 
			{
				if(unique.isEmpty()) 
				{
					unique.add(s);
				}
				else 
				{
					unique.add(s);
					count.add(tempCount);
					counts++;
					tempCount = 1;
				}
			}
		}
		count.add(tempCount);
		count.sort(null);
		
		int maxcount = count.get(counts), mincount = count.get(0), totalMin = Collections.frequency(count, mincount), totalMax = Collections.frequency(count, maxcount);
				
		if(maxcount == mincount) 
		{
			valid();
		}
		if((totalMin * mincount) + (totalMax * maxcount) != s.length()) 
		{
			notValid();
		}
		if((maxcount - mincount) > 1 && totalMin > 1) 
		{
			notValid();
		}				
		if(mincount > 1 && (totalMax > 1 && ((totalMax - totalMin) >= 1 || (totalMax - totalMin) <= -1)))
		{
			notValid();
		}
		valid();
	}
	
	public static void notValid() 
	{
		System.out.println("This string is not valid.");
		System.exit(0);
	}
	public static void valid() 
	{
		System.out.println("This string is valid.");
		System.exit(0);
	}
}
