/*
 * Curtis Lynn
 * CSCE 146 Practice Exam01 Question06
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter------------------------------------------------------------------------
public class Question06 {
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
	
//------------------------------------------------------------------------------------	
	//Write your code here
	public int pop() //removes head element
	{
		if(head == null)//empty list
			return 0;
		int ret = head.data;//stores value from head element
		head = head.link;//removes head
		return ret;//returns stored value
	}
		
	
	//Write any additional helper properties or methods here
	public void push(int data) //add data to head position
	{
		ListNode newNode = new ListNode(data, null); //creates node
		if(head == null) //empty list
		{
			head = newNode;//establishes head
			return;
		}
		newNode.link = head;//add element to head of list
		head = newNode;// set as head
	}
	
	//--------------------------------------------------------------------------------
	
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		Question06 intS = new Question06();
		intS.push(0);
		intS.push(1);
		intS.push(2);
		intS.push(3);
		intS.push(4);
		
		intS.pop();
		intS.pop();
		intS.pop();
		//Printing Results
		for(Question06.ListNode temp = intS.head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
	//--------------------------------------------------------------------------------
	
}//Do not alter

