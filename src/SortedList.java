
// don't mention Student
public class SortedList {
	
	private ListNode head;
	
	public SortedList()
	{
		head = null;
	}
	
	public void insert(Comparable value)
	{
		if (head == null)
		{
			head = new ListNode(value, null);
		}
		else if (value.compareTo(head.getValue()) < 0)
		{
			head = new ListNode(value, head);
		}
		else
		{
			ListNode searcher = head;
			boolean done = false;
			while (!done)
			{
				if (searcher.getNext() == null)
				{
					done = true;
				}
				else if (value.compareTo(searcher.getNext().getValue()) <= 0)
				{
					done = true;
				}
				else
				{
					searcher = searcher.getNext();
				}
			}
			
			// The new node goes after searcher. 
			ListNode temp = new ListNode(value, searcher.getNext());
			searcher.setNext(temp);
		}
	}
	
	// ask user for id
	// makes a student with that id and garbage everything else
	// uses that garbage student in the paramaters
	public Object search(Comparable target)
	{	
		ListNode searcher = head;
		while (true)
		{
			if (searcher == null){
				return null;
			}
			else if (target.compareTo(searcher.getValue()) < 0)
			{
				return null;
			}
			else if (target.compareTo(searcher.getValue()) == 0)
			{
				// Case 3b: Found
				return searcher.getValue();
			}
			else
			{
				// Case 3c: Keep searching
				searcher = searcher.getNext();
			}
		}
	}
	
	public Object remove(Comparable target)
	{
		ListNode searcher = head;
		if (head == null)
		{
			return null;
		}
		else if (target.compareTo(searcher.getValue()) == 0)
		{
			Object temp = searcher.getValue();
			head = searcher.getNext();
			return temp;
		}

		while (true)
		{
			if (searcher.getNext() == null)
			{
				return null;
			}
			else if (target.compareTo(searcher.getNext().getValue()) == 0)
			{
				Object temp = searcher.getNext().getValue();
				searcher.setNext(searcher.getNext().getNext());
				return temp;
			}
			else
			{
				searcher = searcher.getNext();
			}
		}
	}
	
	public String toString()
	{
		ListNode searcher = head;
		String total  = "";
		
		while (searcher != null)
		{
			total += searcher.getValue().toString();
			searcher = searcher.getNext();
		}
		return total;
		
	}

}
