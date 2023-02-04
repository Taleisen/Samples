/*
 * Curtis Lynn
 */
public class Queue<T> implements QueueI<T> {
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public ListNode head, tail;//keep track of first and last nodes for enqueue and dequeue processing
	
	public void Enqueue(T data) //add to end of the list
	{
		ListNode newNode = new ListNode(data, null);
		if(head == null) //empty list
		{
			head = tail = newNode;//sets new node as head and tail
		}
		else 
		{
			tail.link = newNode;//adds new node to end of list
			tail = newNode;//sets new node as tail
		}
	}
	
	public T Dequeue() //remove head element and return value
	{
		if(head == null)//empty list
			return null;
		T data = head.data;//store value from head element
		head = head.link;//remove head element
		return data;
	}
	
	public T Peek() //view value of head element without removing it
	{
		if(head == null)//empty list
			return null; 
		return head.data;
	}
	
	public void Print() //print all values from the list
	{
		if(head == null)//empty list
				return;
		for(ListNode temp = head; temp != null; temp = temp.link) 
		{
			System.out.println(temp.data);
		}
	}
}
