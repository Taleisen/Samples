/*
 * Curtis Lynn
 * CSCE 146 Practice Exam01 Question05
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter------------------------------------------------------------------------
public class Question05 
{
	public class ListNode//Public for testing purposes
	{
		public int data;
		public ListNode link;
		public ListNode(int aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public ListNode head;//Public for testing purposes
	public ListNode tail;//Public for testing purposes
		
	public void enqueue(int data)
	{
//------------------------------------------------------------------------------------	
		//Write your code here
		ListNode newNode = new ListNode (data, null);//creates node to enqueue
		if(head == null) //empty list
		{
			head = tail = newNode;//set as tail and head
			return;
		}
		tail.link = newNode;//adds to end of list
		tail = newNode;//updates tail pointer

	}//Do not alter
	
	//Write any additional helper properties or methods here
	
	//--------------------------------------------------------------------------------
	
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		Question05 intQ = new Question05();
		for(int i=0;i<5;i++)
			intQ.enqueue(i);
		//Printing Results
		for(Question05.ListNode temp = intQ.head;temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
	//--------------------------------------------------------------------------------

}//Do not alter
