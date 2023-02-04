/*
 * Curtis Lynn
 */
public class LLStack<T> implements StackI<T> 
{
	private class ListNode 
	{
		T data;
		ListNode link;
		
		public ListNode(T aData, ListNode nextNode) 
		{
			data = aData;
			link = nextNode;
		}
	}
	
	public ListNode head;
	public void Push(T data) 
	{
		ListNode newNode = new ListNode(data, null);
		if(head != null) 
		{
			newNode.link = head;
		}
		head = newNode;
	}
	
	public T Pop() 
	{
		T data = null;
		data = head.data;
		head = head.link;
		return data;
	}
	
	public T Peek() 
	{
		T data = null;
		data = head.data;
		return data;
	}
	
	public void Print() 
	{
		for(ListNode temp = head; temp != null; temp = temp.link) 
		{
			System.out.println(temp.data);
		}
	}
	
	public int Size() 
	{
		int size = 0;
		if(head == null)//empty list
			return size;
		else
		{
			for(ListNode temp = head; temp != null; temp = temp.link) 
			{
				size++;
			}
		}
		
		return size;
	}
}
