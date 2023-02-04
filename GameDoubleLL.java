/*
 *Written by Curtis Lynn 
 */
import java.io.*;
public class GameDoubleLL extends DoubleDoubleLL 
{
	public String getName() 
	{
		return this.getCurrent()[0];
	}
	
	public String getSystem() 
	{
		return this.getCurrent()[1];
	}
	
	public String[] getCurrent() 
	{
		return (String[]) this.current.data;
	}
	
	public void add(String[] data)//adds new node at the end of the list
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

	public GameDoubleLL contains(String test, int filter) 
	{
		GameDoubleLL matches = new GameDoubleLL();
		
		for(current = head; hasMore(); current = current.next) 
		{	
			switch(filter) 
			{
			case 0:
				if(this.getCurrent()[0].toLowerCase().contains(test.toLowerCase())) 
				{
					matches.add(this.getCurrent());
					continue;
				}
				else
					continue;
			case 1:
				if(this.getCurrent()[1].toLowerCase().contains(test.toLowerCase())) 
				{
					matches.add(this.getCurrent());
					continue;
				}
				else
					continue;
			}
			matches.print();
		}
		return matches;
	}
	
	public void print()//print linked list data
	{
		int i = 1;
		for(current = head; hasMore(); current = current.next) 
		{
			System.out.println(i + ": Name: " + getName() + "|| System: " + getSystem());
			i++;
		}
	}
	
	public void printToFile(File file, boolean append) 
	{
		try 
		{
			FileOutputStream writer = new FileOutputStream(file, append);
			for(current = head; hasMore(); current = current.next) 
			{
				String output = (getName() + '\t' + getSystem() + '\n');
				byte[] bytes = output.getBytes();
				writer.write(bytes);
			}
			writer.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void printToFile(File file) 
	{
		try 
		{
			FileOutputStream writer = new FileOutputStream(file);
			for(current = head; hasMore(); current = current.next) 
			{
				String output = (getName() + '\t' + getSystem() + '\n');
				byte[] bytes = output.getBytes();
				writer.write(bytes);
			}
			writer.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
