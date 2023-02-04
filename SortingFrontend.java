/*
 * Curtis Lynn
 */
public class SortingFrontend {

	public static SortingBackend backend = new SortingBackend();
	
	public static void main(String[] args) {
		greetUser();
	}

	public static void greetUser() //say hello and transfer to backend
	{
		System.out.println("Greetings, I sort lists of phrases from lowest to highest based on the number of times the word \"Sort\" appears in them.");
		System.out.println("Enter any number of phrases you would like for me to sort and enter \"Quit\" when you are done.");
		backend.BeginSort();
	}
}
