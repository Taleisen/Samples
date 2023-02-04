/*
 *Written By Curtis Lynn 
 */
public class DoubleDoubleLL 
{
	private class ListNode 
	{
		double data;
		ListNode next, prev;
		
		public ListNode(double aData, ListNode prevNode, ListNode nextNode) 
		{
			data = aData;
			next = nextNode;
			prev = prevNode;
		}
	}
	
	private ListNode head, current, tail;
	
	public DoubleDoubleLL() 
	{
		head = current = tail = null;
	}
	
	public void gotoNext()//next node 
	{
		if(current == null) 
		{
			return;
		}
		current = current.next;
	}
	
	public void gotoPrev()//previous node 
	{
		if(current == null) 
		{
			return;
		}
		current = current.prev;
	}
	
	public void reset()//jump to head
	{
		if(head == null || current == null)
			return;
		
		current = head;
	}
	
	public void gotoEnd()//jump to tail
	{
		current = tail;
	}
	
	public boolean hasMore()//true if current is not null
	{
		boolean hasMore = false;
		if(current != null)
			hasMore = true;
		return hasMore;
	}
	
	public Double getCurrent()//returns data at current reference
	{
		if(current == null) 
		{
			return null;
		}
		return current.data;
		
	}
	
	public void setCurrent(double data)//sets data at current reference
	{
		if(current == null)
			return;
		current.data = data;
	}
	
	public void add(double data)//adds new node at the end of the list
	{
		ListNode newNode = new ListNode(data, null, null);
		
		if(head == null) 
		{
			head = current = tail = newNode;
			return;
		}
		ListNode current = head;
		while(current.next != null)
			current = current.next;
		
		tail = newNode;
		tail.prev = current;
		current.next = tail;
	}
	
	public void addAfterCurrent(double data)//adds new node after current node
	{
		if(current == null)
			return;
		ListNode temp = new ListNode(data, current, current.next);
		current.next = temp;
		current.next.next.prev = temp;
	}
	
	public void remove(double data)//removes a node based on data
	{
		for(current = head; hasMore(); current = current.next) 
		{
			if(current.data == data) 
			{
				removeCurrent();
				break;
			}
		}
	}
	
	public void removeCurrent()//removes current node
	{
		if(current == null)
			return;
		if(current == head) 
		{
			head = current.next;
			current = head;
			current.prev = null;
		}
		else if(current == tail) 
		{
			current = current.prev;
			tail = current;
		}
		else 
		{
			current.prev.next = current.next;
			current.next.prev = current.prev;
			current = current.next;
		}
	}
	
	public void print()//print linked list data
	{
		for(current = head; hasMore(); current = current.next) 
		{
			System.out.println(current.data);
		}
	}
	
	public boolean contains(double test)//true if test data is included in the list
	{
		for(current = head; current != null; current = current.next)
		{
			if(test == current.data)
				return true;
		}
		return false;
	}
}


