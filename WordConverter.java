/*
 * Written By Curtis Lynn
 */
package Curtis_Lynn;

public class WordConverter {

	public static void main(String[] args) 
	{
		String word1 = "intention", word2 = "execution";
		int minChanges = 0;
		
		if(word1.equalsIgnoreCase(word2)) 
		{
			System.out.println(minChanges);
		}
		minChanges = process(word1, word2);
		System.out.println(minChanges);
	}
	
	public static int process(String original, String target) 
	{
		int changes = 0;
		if(original.length() > target.length()) 
		{
			for(int i = 0; i < original.length(); i++)
			{
				if(!target.contains(original.subSequence(i, i+1))) 
				{
					++changes;
				}
			}
		}
		else if(original.length() < target.length()) 
		{
			for(int i = 0; i < target.length(); i++) 
			{
				if(!original.contains(target.subSequence(i, i+1))) 
				{
					++changes;
				}
			}
		}
		else 
		{
			for(int i = 0; i < target.length(); i++) 
			{
				if(!target.subSequence(i, i+1).equals(original.subSequence(i, i+1))) 
				{
					++changes;
				}
			}
		}
		return changes;
	}

}
