
/******************************************************************************
* Savion Sample
* SortedList Class
* 
* Contains all the methods necessary for inserting, removing, and searching in
* the SortedList. The SortedList is made up of ListNodes which contain Students
* inside of their values. 
*
******************************************************************************/
public class SortedList 
{
	
	private ListNode head;
	
	public SortedList()
	{
		head = null;
	}
	
	/**
	 * Inserts a new Student into a ListNode then into the SortedList
	 * 
	 * @param value
	 */
	public void insert(Comparable value)
	{
		// check first ListNode
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
			// then check the rest of the ListNodes
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
					// keep searching
					searcher = searcher.getNext();
				}
			}
			
			// The new node goes after searcher. 
			ListNode temp = new ListNode(value, searcher.getNext());
			searcher.setNext(temp);
		}
	}
	
	/**
	 * Checks each ListNode until the target id is found, removes that ListNode
	 * and returns the Student removed
	 * 
	 * @param target: fake Student with id # the method will search for
	 * @return: the Student if found, null if not
	 */
	public Object remove(Comparable target)
	{
		ListNode searcher = head;
		
		// check the first node
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

		// then check all nodes following
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
				// keep searching
				searcher = searcher.getNext();
			}
		}
	}

	/**
	 * searches for a Student in the list with a specific id # 
	 * 
	 * @param target: fake Student with id # the method will search for
	 * @return: the Student if found, null if not
	 */
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
				return searcher.getValue();
			}
			else
			{
				// keep searching
				searcher = searcher.getNext();
			}
		}
	}
	
	/**
	 * returns the Student's info as a String
	 */
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
