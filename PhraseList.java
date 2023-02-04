
public class PhraseList 
{
	public ListNode head, tail;
	int count = 0;
	public void Enqueue(String data) //add new element to the end of the list
	{
		ListNode newNode = new ListNode(data, null);
		if(head == null) //empty queue
		{
			head = tail = newNode;//sets new node as head and tail
			count = 1;
		}
		else 
		{
			tail.next = newNode;//adds new node to end of list
			tail = newNode;//sets new node as tail
			count++;
		}
	}
	
	public ListNode Dequeue() //remove head element and return the data
	{
		ListNode answer = null;
		if(head == null)//empty list
			return null;
		answer = head;
		head = head.next;
		count--;
		return answer;
	}
	
	public ListNode[] Transfer() //transfers list to array for easier sorting
	{
		ListNode[] SortingList = new ListNode[count];
		int i = 0;
		for(ListNode temp = head; temp != null; temp = temp.next) 
		{
			SortingList[i] = Dequeue();
			i++;
		}
		return SortingList;
	}
}
