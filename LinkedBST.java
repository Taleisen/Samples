/*
 * Curtis Lynn
 */
public class LinkedBST<T extends Comparable<T>> {
	private class Node 
	{
		public Node leftChild, rightChild, parent;
		T data;
		
		public Node(T aData) 
		{
			data = aData;
			leftChild = rightChild = parent = null;
		}
	}
	
	protected Node root;
	
	public LinkedBST() 
	{
		root = null;
	}
	
	public boolean Search(T aData) 
	{
		return Search(aData, root);
	}
	private boolean Search(T aData, Node current) 
	{
		if(current == null) //data not found
		{
			return false;
		}
		else if(current.data.compareTo(aData) == 0) //found value
		{
			return true;
		}
		else if(current.data.compareTo(aData) > 0) // target data less than data at this node
		{
			return Search(aData, current.leftChild);
		}
		else //target data greater than data at this node
		{
			return Search(aData, current.rightChild);
		}
	}
	
	public void Add(T aData) 
	{
		if(root == null) //empty list
		{
			root = new Node(aData);
			return;
		}
		else
			Add(aData, root, null);
		
	}
	
	private Node Add(T aData, Node position, Node parent) 
	{
		if(position == null)// leaf
		{
			position = new Node(aData);//adds data in place of leaf
			position.parent = parent;//sets parent
		}
		
		else if(position.data.compareTo(aData) > 0) //data at this node greater than test data
		{
			position.leftChild = Add(aData, position.leftChild, position);
		}
		else if(position.data.compareTo(aData) < 0) //data at this node less than test data
		{
			position.rightChild = Add(aData, position.rightChild, position);
		}
		return position;
	}
	
	public void Remove(T aData) 
	{
		root = Remove(aData, root, null);
	}
	
	
	private Node Remove(T aData, Node current, Node parent) 
	{
		if(current == null) 
		{
			return null;
		}
		else if(current.data.compareTo(aData) == 0)//found value
		{
			
				if(current.rightChild == null) 
				{
					if(current.leftChild != null) 
					{
						current.leftChild.parent = parent;
					}
					return current.leftChild;
				}
				else if(current.leftChild == null) 
				{
					current.rightChild.parent = parent;
					return current.rightChild;
				}
				else 
				{
					Node temp = MinMax(current.rightChild);
					current.data = temp.data;
					current.rightChild = Remove(temp.data, current.rightChild, current);//remove duplicate
				}
				//BalanceTree(current, '-');
				return current;
			
			
		}
		else if(current.data.compareTo(aData) > 0)//target data less than current data
		{
			current.leftChild = Remove(aData, current.leftChild, current);
		}
		else//target data greater than current data
		{
			current.rightChild = Remove(aData, current.rightChild, current);
		}
		return current;
	}
	
	private Node MinMax(Node current) 
	{
		if(current == null) //leaf
		{
			return null;
		}
		else if(current.leftChild == null) //minimum value of branch found
		{
			return current;
		}
		else 
		{
			return MinMax(current.leftChild);//follow branch
		}
	}
	
	
	
	public void PrintPreorder() 
	{
		PrintPreorder(root);
	}
	private void PrintPreorder(Node thisNode) 
	{
		if(thisNode == null) 
		{
			return;
		}
		System.out.println(thisNode.data);//Process
		PrintPreorder(thisNode.leftChild);//Left
		PrintPreorder(thisNode.rightChild);//Right
	}
	
	public void PrintInorder() 
	{
		PrintInorder(root);
	}
	private void PrintInorder(Node thisNode) 
	{
		if(thisNode == null) 
		{
			return;
		}
		PrintInorder(thisNode.leftChild);//Left
		System.out.println(thisNode.data);//Process
		PrintInorder(thisNode.rightChild);//Right
	}
	
	public void PrintPostorder() 
	{
		PrintPostorder(root);
	}
	private void PrintPostorder(Node thisNode) 
	{
		if(thisNode == null) 
		{
			return;
		}
		PrintPostorder(thisNode.leftChild);//Left
		PrintPostorder(thisNode.rightChild);//Right
		System.out.println(thisNode.data);//Process
	}
}
