/*
 * Written By Curtis Lynn 
 */
public class Word {
	private int vowels = 0, length = 0, consonants = 0;
	private String word;
	public int flag;
	
	//gathers string from the list and determines number of letters, vowels, and consonants for sorting
	public Word(String name)
	{
		word = name;
		length = name.length();
		//counts vowels and consonants
		for(char c: name.toCharArray()) 
		{
			switch(c) 
			{
			case 'a':
				this.vowels++;
				break;
			case 'e':
				this.vowels++;
				break;
			case 'i':
				this.vowels++;
				break;
			case 'o':
				this.vowels++;
				break;
			case 'u':
				this.vowels++;
				break;
			case 'y':
				this.vowels++;
				break;
			default:
				this.consonants++;
			}
		}
	}
	
	public String getWord() 
	{
		return this.word;
	}
	public int getVowels() 
	{
		return this.vowels;
	}
	public int getConsonants() 
	{
		return this.consonants;
	}
	public int getLength() 
	{
		return this.length;
	}
}
