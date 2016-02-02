import java.util.Scanner;

/******************************************************************************
*
* Name: Savion Sample
* Block: D
* Date: 2/1/16
*
* Description:
* A SortedList class that uses linked lists to store a list of Comparable
* objects. The menu-driven interface gives the option to do:
* 
******************************************************************************/

public class SortedListMain {
	
	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args)
	{
		SortedList list  = new SortedList();
		
		displayMenu();
		System.out.println("Please enter a command:");
		String userInput = SC.nextLine();
		
		while (!userInput.equals("q"))
		{	
			System.out.println("User's input: " + userInput);
			processInput(list, userInput);
			System.out.println();
			System.out.println("Please enter a command:");
			userInput = SC.nextLine();
		}
		System.out.println("End of program");
	}
	
	/**
	 * performs an action based on the user's input
	 * 
	 * @param queue: the entire queue
	 * @param userInput: the command the user entered
	 */
	private static void processInput(SortedList list, String userInput)
	{
		if (userInput.equals("i"))
		{	
			insertMain(list);
		}
		else if(userInput.equals("r"))
		{
			Object temp = removeMain(list);
			if (temp != null)
			{
				System.out.println(temp);
			}
			else
			{
				System.out.println("No person with that id was found.");
			}
		}
		else if(userInput.equals("s"))
		{
			Object temp = searchMain(list);
			if (temp != null)
			{
				System.out.println(temp);
			}
			else
			{
				System.out.println("No person with that id was found.");
			}
			
		}
		else if(userInput.equals("d"))
		{
			System.out.println(list.toString());
		}
		else if(userInput.equals("h"))
		{
			displayMenu();
		}
		else
		{
			System.out.println("Command not recognized...please try again");
		}
	}
	
	private static void displayMain(SortedList list)
	{
		System.out.println(list.toString());
	}
	
	private static void insertMain(SortedList list)
	{
		System.out.println("Please enter the student's ID number");
		int idNumber = SC.nextInt();
		SC.nextLine();
		
		System.out.println("Please enter the student's name");
		String studentName = SC.nextLine();
		
		
		Student newStudent = new Student(idNumber, studentName);
		list.insert(newStudent);
		System.out.println("Student " + studentName + " with id of " + idNumber 
							+ " was inserted into the thing");
	}
	
	private static Object removeMain(SortedList list)
	{
		System.out.println("Please enter the id number you want to remove");
		int idNumber = SC.nextInt();
		SC.nextLine();
		
		Student trashBagDummy = new Student(idNumber, "Trash Bag");
		return list.remove(trashBagDummy);
	}
	
	private static Object searchMain(SortedList list)
	{
		System.out.println("Please enter the id of the student you want to search");
		int idNumber = SC.nextInt();
		SC.nextLine();
		
		Student trashBagDumpster = new Student(idNumber, "Mr. Trashbag");
		return list.search(trashBagDumpster);
	}
	
	/**
	 * Displays all the valid options for commands
	 */
	private static void displayMenu()
	{
		System.out.println();
		
		System.out.println("Here are the commands:");
		System.out.println("i - insert");
		System.out.println("r - remove");
		System.out.println("s - search");
		System.out.println("d - display");
		System.out.println("h - help");
		System.out.println("q - quit");
	}

}
