/*
 * Written By Curtis Lynn 
 */
public class WordHelper {
	public static boolean hasSwitched = false, initialized = false;
	public static Word[] wordList;
	
	//sorts by number of vowels lowest to highest
	public static String[] sortByVowels(String[] words) 
	{
		words = Sort(words, 2);
		return words;
	}
	
	//sorts by number of consonants lowest to highest
	public static String[] sortByConsonants(String[] words) 
	{
		words = Sort(words, 1);
		return words;
	}
	
	//sorts by length of word shortest to longest
	public static String[] sortByLength(String[] words) 
	{
		words = Sort(words, 0);
		return words;
	}
	
	public static void Init(String[] words) 
	{
		wordList = new Word[words.length];
		for(int i = 0; i < words.length; i++) 
		{
			wordList[i] = new Word(words[i]);
		}
		initialized = true;
	}
	
	public static String[] Sort(String[] words, int flag) 
	{
		if(!initialized) //creates an array of Word objects and sets the values for their variables
		{
			Init(words);
		}
		for(int i = 0; i < wordList.length; i++) //outward facing flag integer for faster sorting process
		{
			switch(flag) 
			{
			case 0:
				wordList[i].flag = wordList[i].getLength();
				break;
			case 1:
				wordList[i].flag = wordList[i].getConsonants();
				break;
			case 2:
				wordList[i].flag = wordList[i].getVowels();
			}
		}
		
		do 
		{
			hasSwitched = false;
			for(int i = 0; i < wordList.length -1; i++) 
			{
				if(wordList[i].flag > wordList[i + 1].flag) 
				{
					Word temp = wordList[i];
					wordList[i] = wordList[i + 1];
					wordList[i + 1] = temp;
					hasSwitched = true;
				}
			}
		}
		while(hasSwitched);
		
		for(int i = 0; i < wordList.length; i++) 
		{
			words[i] = wordList[i].getWord();
		}
		
		return words;
	}
}
