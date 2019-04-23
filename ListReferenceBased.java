
import java.util.LinkedList;
import java.util.ArrayList;

public class ListReferenceBased {
	private Node head;
	private int numItems;
	
	
	public ListReferenceBased()
	{
		head = null;
		numItems = 0;
	}
	
	//is empty
	public boolean listIsEmpty()
	{
		return (numItems == 0);
	}
	
	//size
	public int length()
	{
		return numItems;
	}
	
	//Helping method, not designed for user, meant to help implementation of other methods
	private Node locate(int posi)
	{
		Node curr = head; //Reference pointing to head 
		while(posi > 1)
		{
			curr = curr.getNext();
			posi--;
		}
		
		return curr;
	}
	
	/*
	 * Retrieve 
	 */
	public Object retrieve(int posi) throws IndexOutOfBoundsException
	{
		if(posi >= 1 && posi <= numItems)
		{
			Node curr = locate(posi);
			return curr.getItem();
		}
		else
		{
			throw new IndexOutOfBoundsException("This position is out of reach!");
		}
		
	}
	
	
	//insertion
	public void listInsert(Object newItem, int posi) throws IndexOutOfBoundsException
	{
		if(posi >= 1 && posi <= numItems +1) 
		{
			//insert the beinning
			if(posi == 1)
			{
				
					Node newNode = new Node(newItem, head);
					head = newNode;
			}
			//Every other  case
				else
				{
					Node prev = locate(posi -1);
					Node newNode = new Node(prev.getNext());
					prev.setNext(newNode);
					numItems++;
					
					
				}
				
			}
			else
			{
				throw new IndexOutOfBoundsException("This position is out of reach!");
			}
		}
	
	
	//deletion
	public void listRemove(int posi) throws IndexOutOfBoundsException
	{
		if(posi >=1 && posi <= numItems)
		{
			Node curr;
			if(posi == 1)
			{
				curr = head;
				head.getNext(); 
			}
			else
			{
				Node prev = locate(posi-1);
				curr = prev.getNext();
				prev.setNext(curr.getNext());
			}
			numItems --; 
			curr.setNext(null);
			//or curr = null;
		}
		else
		{
			throw new IndexOutOfBoundsException("This position is out of reach!");
		}
	}

	//remove all
	public void removeAll()
	{
		head = null;
		numItems = 0;
	}
}
