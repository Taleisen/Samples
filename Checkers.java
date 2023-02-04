/*
 * Written By Curtis Lynn
 */
public class Checkers <T extends Comparable<T>>{
	
	LLQueue<String> queue = new LLQueue<String>();
	
	private class Node 
	{
		public boolean isBlack = false;
		public Node leftChild, rightChild, parent;
		T data;
		
		public Node(T aData) 
		{
			data = aData;
			leftChild = rightChild = parent = null;
		}
	}
	
	private Node root;
	
	public Checkers() 
	{
		root = null;
	}
	
	public T findLargest() 
	{
		if(root == null) 
		{
			return null;
		}
		return findLargest(root);
	}
	private T findLargest(Node current) 
	{
		if(current.rightChild == null) 
		{
			return current.data;
		}
		else 
		{
			return findLargest(current.rightChild);
		}
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
			root.isBlack = true;//root is always black
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
			BalanceTree(position, '+');//balance tree if necessary
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
	
	private boolean DoubleBlack;
	
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
					if(current.isBlack ^ current.leftChild.isBlack) 
					{
						current.leftChild.isBlack = true;
					}
					else if(current.isBlack && current.leftChild.isBlack) 
					{
						DoubleBlack = true;
						BalanceTree(current.leftChild, '-');
					}
				}
				if(current.isBlack && current.leftChild == null && current.rightChild == null) 
				{
					DoubleBlack = true;
					BalanceTree(current, '-');
				}
				return current.leftChild;
			}
			else if(current.leftChild == null) 
			{
				current.rightChild.parent = parent;
				if(current.isBlack ^ current.rightChild.isBlack) 
				{
					current.rightChild.isBlack = true;
				}
				else if(current.isBlack && current.rightChild.isBlack) 
				{
					DoubleBlack = true;
					BalanceTree(current.rightChild, '-');
				}
				return current.rightChild;
			}
			else 
			{
				Node temp = MinMax(current.rightChild);
				current.data = temp.data;
				current.rightChild = Remove(temp.data, current.rightChild, current);//remove duplicate
			}
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
	
	private void BalanceTree(Node current, char operator) //balances tree after addition or removal of nodes
	{
		Node parent = null, grandparent = null, sibling = null, uncle = null;
		parent = current.parent;
		if(parent == null || parent.parent == null) 
		{
			grandparent = null;
		}
		else 
		{
			grandparent = parent.parent;
		}
		
		if(parent != null) 
		{
			if(parent.leftChild == null || parent.rightChild == null) 
			{
				sibling = null;
			}
			else if(parent.leftChild.equals(current)) 
			{
				sibling = parent.rightChild;
			}
			else 
			{
				sibling = parent.leftChild;
			}
		}
		if(grandparent != null) 
		{
			if(grandparent.leftChild == null || grandparent.rightChild == null) 
			{
				uncle = null;
			}
			else if(grandparent.leftChild.equals(parent)) 
			{
				uncle = grandparent.rightChild;
			}
			else 
			{
				uncle = grandparent.leftChild;
			}
		}
		
		switch(operator)
		{
		case '+':
			AdditiveBalancer(current, parent, grandparent, uncle);
			break;
		case '-':
			DoubleBlackFix(current, parent, grandparent, sibling, uncle);
			break;
		}
	}
	
	private void DoubleBlackFix(Node current, Node parent, Node grandparent, Node sibling, Node uncle) //fixes black depth issues that can arise from removing nodes
	{
		if(!root.equals(current) && DoubleBlack) 
		{
			if(sibling == null) 
			{
				Node temp = null;
				if(grandparent == null) 
				{
					return;
				}
				if(grandparent.rightChild.equals(parent)) 
				{
					temp = grandparent.leftChild;
				}
				else 
				{
					temp = grandparent.rightChild;
				}
				DoubleBlackFix(parent, grandparent, grandparent.parent, uncle, temp);
			}
			else if(sibling.isBlack && (!sibling.leftChild.isBlack || !sibling.rightChild.isBlack)) //black sibling with at least one red child
			{
				if(parent.rightChild.equals(sibling) && !sibling.rightChild.isBlack)//RightRight 
				{
					sibling.parent = grandparent;
					parent.rightChild = sibling.leftChild;
					sibling.leftChild = parent;
					if(root.equals(parent)) 
					{
						root = sibling;
					}
					if(sibling.rightChild != null) 
					{
						sibling.rightChild.isBlack = true;
					}
				}
				else if(parent.rightChild.equals(sibling) && !sibling.leftChild.isBlack) //RightLeft
				{
					sibling.parent = sibling.leftChild;
					sibling.leftChild.parent = grandparent;
					sibling.leftChild = sibling.leftChild.rightChild;
					sibling.parent.rightChild = sibling;
					ChangeColor(sibling);
					ChangeColor(sibling.parent);
					sibling.parent.parent = grandparent.parent;
					grandparent.rightChild = sibling.parent.leftChild;
					sibling.parent.leftChild = grandparent;
					ChangeColor(sibling);
					if(root.equals(parent)) 
					{
						root = sibling;
					}
				}
				else if(parent.leftChild.equals(sibling) && !sibling.leftChild.isBlack) //LeftLeft
				{
					sibling.parent = grandparent;
					parent.leftChild = sibling.rightChild;
					sibling.rightChild = parent;
					if(root.equals(parent)) 
					{
						root = sibling;
					}
					if(sibling.leftChild != null) 
					{
						sibling.leftChild.isBlack = true;
					}
				}
				else //LeftRight
				{
					sibling.parent = sibling.rightChild;
					sibling.rightChild.parent = grandparent;
					sibling.rightChild = sibling.rightChild.leftChild;
					sibling.parent.leftChild = sibling;
					ChangeColor(sibling);
					ChangeColor(sibling.parent);
					sibling.parent.parent = grandparent.parent;
					grandparent.leftChild = sibling.parent.rightChild;
					sibling.parent.rightChild = grandparent;
					ChangeColor(sibling);
					if(root.equals(parent)) 
					{
						root = sibling;
					}
				}
			}
			else if(sibling.isBlack && sibling.leftChild.isBlack && sibling.rightChild.isBlack) //black sibling with 2 black children
			{
				ChangeColor(sibling);
				if(parent.isBlack && !root.equals(parent)) 
				{
					RecursiveColorChange(current, parent, grandparent);
				}
			}
			else //red sibling
			{
				if(parent.rightChild.equals(sibling))//Right 
				{
					sibling.parent = grandparent;
					parent.rightChild = sibling.leftChild;
					sibling.leftChild = parent;
					if(root.equals(parent)) 
					{
						root = sibling;
					}
					ChangeColor(sibling);
					ChangeColor(parent.rightChild);
					DoubleBlack = false;
				}
				else//Left
				{
					sibling.parent = grandparent;
					parent.leftChild = sibling.rightChild;
					sibling.rightChild = parent;
					if(root.equals(parent)) 
					{
						root = sibling;
					}
					ChangeColor(sibling);
					ChangeColor(parent.leftChild);
					DoubleBlack = false;
				}
			}
		}
		root.isBlack = true;
		DoubleBlack = false;
	}
	
	private void RecursiveColorChange(Node current, Node parent, Node grandparent) //change color of nodes to correct black depth
	{
		if(parent.isBlack && !root.equals(parent)) 
		{
			ChangeColor(parent);
			if(grandparent != null) 
			{
				current = parent;
				parent = grandparent;
				grandparent = grandparent.parent;
			}
		}
		RecursiveColorChange(current, parent, grandparent);
	}
	private void AdditiveBalancer(Node current, Node parent, Node grandparent, Node uncle) //balances nodes after new node added
	{
		if(parent == null) 
		{
			if(!root.equals(current))
				System.out.println("I am an orphan. My value is " + current.data.toString());
			return;
		}
		if(parent.isBlack && !current.isBlack) 
		{
			return;
		}
		else if(!parent.isBlack && !current.isBlack) 
		{
			if(parent == null || grandparent == null) 
				{
					return;
				}
			else if(uncle != null && !uncle.isBlack) //for red uncle change color of parent, uncle, and grandparent then repeat with grandparent
			{
				
				ChangeColor(parent);
				ChangeColor(uncle);
				ChangeColor(grandparent);
				BalanceTree(grandparent, '+');
			}
			if(grandparent.leftChild == null || grandparent.rightChild == null || parent.leftChild == null || parent.rightChild == null) 
			{
				return;
			}
			else if(grandparent.leftChild.equals(parent) && parent.leftChild.equals(current)) 
			{
				LeftLeft(current, parent, grandparent);
			}
			else if(grandparent.leftChild.equals(parent) && parent.rightChild.equals(current)) 
			{
				LeftRight(current, parent, grandparent);
			}
			else if(grandparent.rightChild.equals(parent) && parent.leftChild.equals(current)) 
			{
				RightLeft(current, parent, grandparent);
			}
			else 
			{
				RightRight(current, parent, grandparent);
			}
		}
		root.isBlack = true;
	}
	
	private void LeftLeft(Node current,Node parent,Node grandparent) //rotate grandparent right then swap color of parent and grandparent 
	{
		parent.parent = grandparent.parent;
		grandparent.parent = parent;
		grandparent.leftChild = parent.rightChild;
		parent.rightChild = grandparent;
		ChangeColor(grandparent);
		ChangeColor(parent);
		if(root.equals(grandparent)) 
		{
			root = parent;
		}
		BalanceTree(parent, '+');
	}
	
	private void LeftRight(Node current, Node parent, Node grandparent) //Rotate parent left then apply LeftLeft rotation
	{
		current.parent = grandparent;
		parent.parent = current;
		parent.leftChild = current.rightChild;
		current.rightChild = parent;
		if(root.equals(parent)) 
		{
			root = current;
		}
		LeftLeft(current, parent, grandparent);
	}
	
	private void RightLeft(Node current, Node parent, Node grandparent) //Rotate parent right then apply RightRight rotation
	{
		current.parent = grandparent;
		parent.parent = current;
		parent.leftChild = current.rightChild;
		current.rightChild = parent;
		if(root.equals(parent)) 
		{
			root = current;
		}
		RightRight(current, parent, grandparent);
	}
	
	private void RightRight(Node current, Node parent, Node grandparent) //rotate grandparent left then swap color of parent and grandparent 
	{
		parent.parent = grandparent.parent;
		grandparent.parent = parent;
		grandparent.rightChild = parent.leftChild;
		parent.leftChild = grandparent;
		ChangeColor(grandparent);
		ChangeColor(parent);
		if(root.equals(grandparent)) 
		{
			root = parent;
		}
		BalanceTree(parent, '+');
	}
	
	private void ChangeColor(Node target) //change the color for target node
	{
		target.isBlack = !target.isBlack;
	}
	
	public void PrintPreorder() 
	{
		if(root == null) 
		{
			System.out.println("Tree is empty");
		}
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
		if(root == null) 
		{
			System.out.println("Tree is empty");
		}
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
		if(root == null) 
		{
			System.out.println("Tree is empty");
		}
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
	
	public LLQueue<String> convertedTree() 
	{
		if(root == null) 
		{
			return null;
		}
		convertedTree(root);
		return queue;
	}
	private LLQueue<String> convertedTree(Node thisNode)
	{
		if(thisNode == null) 
		{
			return null;
		}
		convertedTree(thisNode.leftChild);//Left
		queue.Enqueue(thisNode.data.toString());//Process
		convertedTree(thisNode.rightChild);//Right
		return queue;
	}
}
