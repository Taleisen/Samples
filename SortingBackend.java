/*
 * Curtis Lynn
 */
import java.util.Scanner;
public class SortingBackend {
	private PhraseList list = new PhraseList();
	private Scanner keyboard = new Scanner(System.in);
	private ListNode[] array;
	private static SortingFrontend front = new SortingFrontend();
	public String keyphrase = "sort";
	
	public void BeginSort() 
	{
		String input = keyboard.nextLine();//gathers input
		if(input.equalsIgnoreCase("Quit")) //if user has entered all entries in the list
		{
			array = list.Transfer();//transfer from linked list to array
			SortList(array);
		}
		else 
		{
			list.Enqueue(input);//add entry to list
			System.out.print("Please enter the next phrase or enter \"Quit\" to finish.");//prompt for next entry
			BeginSort();
		}
	}
	
	public void SortList(ListNode[] listToSort) 
	{
		WordCounter(listToSort);//count the number of times the word sort appears
		QuickSort(listToSort);//sort list based on number of times sort appears
		PrintList(listToSort);//print sorted list
	}
	public int wordCount;
	public void WordCounter(ListNode[] uncountedList) //count the number of times phrase appears
	{
		for(int i = 0; i < uncountedList.length; i++) 
		{
			wordCount = 0;
			if(uncountedList[i].data.toLowerCase().contains(keyphrase)) //it contains the word sort
			{
				String temp = uncountedList[i].data.toLowerCase();
				wordCount = counter(temp);
			}
			uncountedList[i].sortFlag = wordCount;//sets sort flag to number of times sort appears
		}
	}
	
	public int counter(String phrase) 
	{
		int cutoff;
		if(phrase.contains(keyphrase)) 
		{
			cutoff = phrase.indexOf(keyphrase);//finds beginning of keyphrase
			wordCount++;
			counter(phrase.substring(cutoff + 4, phrase.length()));//calls again with shortened phrase after removing keyphrase
		}
		return wordCount;
	}
	
	public void QuickSort(ListNode[] unsortedList) //sort based on count
	{
		QuickSort(unsortedList, 0, unsortedList.length - 1);
	}
	
	private void QuickSort(ListNode[] unsortedList, int start, int end) 
	{
		if(start > end)//halting condition
			return;
		int pivot = partition(unsortedList, start, end);
		QuickSort(unsortedList, start, pivot - 1);//sort the list smaller than pivot
		QuickSort(unsortedList, pivot + 1, end);//sort the list larger than pivot		
	}
	
	public static int partition(ListNode[] unsortedList, int start, int end) 
	{
		int pivot = unsortedList[end].sortFlag;
		int i = start;
		for(int j = start; j <= end; j++) 
		{
			if(unsortedList[j].sortFlag < pivot) //swap if smaller than pivot value
			{
				ListNode temp = unsortedList[i];
				unsortedList[i] = unsortedList[j];
				unsortedList[j] = temp;
				i++;
			}
		}//put pivot into its place
		ListNode temp = unsortedList[i];
		unsortedList[i] = unsortedList[end];
		unsortedList[end] = temp;
		return i;//return pivot point
	}
	
	public void PrintList(ListNode[] printingList) //print sorted list
	{
		System.out.println("Your sorted list:");
		for(int i = 0; i < printingList.length; i++) 
		{
			System.out.println(printingList[i].data);//print each element of array
		}
		Continue();
	}
	
	public void Continue() //option to run application again
	{
		System.out.print("Enter 1 to enter a new list or 2 to close the application.");
		String input = keyboard.nextLine();
		if(input.length() == 1) //single character
		{
			switch(input.charAt(0)) 
			{
			case '1':
				front.greetUser();//restart application
				break;
			case '2':
				System.out.println("Goodbye.");
				System.exit(0);//quit application
				break;
			default:
				Continue();
			}
		}
		else 
		{
			Continue();
		}
	}
}
