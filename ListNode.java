/*
 * Curtis Lynn
 */
public class ListNode 
	{
		String data;
		public ListNode next;
		public int sortFlag = 0;
		public ListNode(String input, ListNode link) //initialize data
		{
			this.data = input;
			this.next = link;
		}
	}