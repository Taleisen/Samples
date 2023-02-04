/*
 * Curtis Lynn
 * CSCE 146 Practice Exam01 Question04
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter-----------------------------------------------------------------------
public class Question04 
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
	public void removeSmallerThan(int value)
	{
//-----------------------------------------------------------------------------------
		//Write your solution here
		ListNode temp = head;
		if(temp == null)//empty list
			return;
		while(temp.link != null) 
		{
			if(temp.data < value) //if head value smaller than target
			{
				if(temp == head) 
				{
					head = head.link;//remove head
					temp = head;
				}
			}
			else if(temp.link.data < value)//if head is equal to or greater than the value checks next value
				temp.link = temp.link.link;//remove node
			else
				temp = temp.link;//next node
			continue;
		}
		if(temp != null && temp.data < value) //if the last element of the list is smaller than the target
		{
			if(temp == head) 
			{
				head = null;//deletes node
			}
		}
	}//Do not alter this
	//Write additional methods or properties here
			
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		Question04 intLL = new Question04();
		intLL.head = intLL.new ListNode(0, 
							intLL.new ListNode(1, 
									intLL.new ListNode(2,
											intLL.new ListNode(3,
													intLL.new ListNode(4,null)))));
		intLL.removeSmallerThan(3);
		//Printing Results
		for(Question04.ListNode temp = intLL.head;temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
	//--------------------------------------------------------------------------------
}//Do not alter this


