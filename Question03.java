/*
 * Curtis Lynn
 * CSCE 146 Practice Exam01 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter-----------------------------------------------------------------------
public class Question03 
{
	public class ListNode//public for testing purposes
	{
		public int data;//public for testing purposes
		public ListNode link;//public for testing purposes
		public ListNode(int aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public ListNode head;//public for testing purposes
	public void insertAfter(int insertValue, int targetValue)
	{
//-----------------------------------------------------------------------------------
		//Write your solution here
		ListNode temp, newNode = new ListNode(insertValue, null);// current node for use in for loop and new node to be added
		if(head == null) //empty list
		{
			head = newNode;
			return;
		}
		for(temp = head; temp.link != null; temp = temp.link) //step through list
		{
			if(temp.data == targetValue) //if data is target value
			{
				newNode.link = temp.link;//sets link for next node from point of insertion
				temp.link = newNode;//links to new node
				return;
			}
		}
		temp.link = newNode;//adds to end if target value not found

	}//Do not alter this
	//Write additional methods or properties here
			
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		Question03 intLL = new Question03();
		intLL.head = intLL.new ListNode(0, 
							intLL.new ListNode(1, 
									intLL.new ListNode(2,
											intLL.new ListNode(3,
													intLL.new ListNode(4,null)))));
		intLL.insertAfter(10,-1);
		//Printing Results
		for(Question03.ListNode temp = intLL.head;temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

