/*
 * Written by Curtis Lynn
 */
public class LLQueue <T> implements QueueI<T>
{
	private class ListNode 
	{
		T data;
		ListNode next;
		
		public ListNode(T aData, ListNode nextNode) 
		{
			data = aData;
			next = nextNode;
		}
	}
	
	private ListNode head, tail;
	public int count = 0;
	
	public void Enqueue(T data)//add node to end of the list
	{
		ListNode temp = new ListNode(data, null);
		if(head == null) //empty list
		{
			head = tail = temp;
		}
		else 
		{
			tail.next = temp;
			tail = temp;
		}
		count++;
	}
	
	public T Dequeue() //remove head and return data
	{
		T data = head.data;
		head = head.next;
		count--;
		return data;
	}
	
	public T Peek() //returns data without dequeuing 
	{
		return head.data;
	}
	
	public void Print() //prints content of list
	{
		for(ListNode temp = head; temp != null; temp = temp.next) 
		{
			System.out.println(temp.data.toString());
		}
	}
}
