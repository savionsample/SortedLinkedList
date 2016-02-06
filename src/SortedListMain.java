import java.util.Scanner;

/******************************************************************************
*
* Name: Savion Sample
* Block: D
* Date: 2/5/16
*
* Description:
* A SortedList class that uses linked lists to store a list of Comparable
* objects. The menu-driven interface gives the option to: insert a Student,
* remove a Student, search for an id, display all Students, show all the
* possible commands, and quit.
* 
******************************************************************************/

public class SortedListMain 
{
	
	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args)
	{
		SortedList list  = new SortedList();
		
		displayMenu();
		System.out.println("Please enter a command:");
		String userInput = SC.nextLine();
		
		// prompts the user and keeps cycling until the user wants to quit
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
	 * @param list: the entire SortedList
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
			checkNull(temp);
		}
		else if(userInput.equals("s"))
		{
			Object temp = searchMain(list);
			checkNull(temp);
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
	
	/**
	 * Checks to see if the Student exists
	 * 
	 * @param temp: the Student
	 */
	private static void checkNull(Object temp)
	{
		if (temp != null)
		{
			System.out.println(temp);
		}
		else
		{
			System.out.println("No person with that id was found.");
		}
	}
	
	/**
	 * prints the entire SortedList
	 * 
	 * @param list: the SortedList
	 */
	private static void displayMain(SortedList list)
	{
		System.out.println(list.toString());
	}
	
	/**
	 * creates a new Student object with the user's input and
	 * inserts it into the SortedList
	 * 
	 * @param list: the SortedList
	 */
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
	
	/**
	 * removes a student from SortedList with the id number the user entered.
	 * 
	 * @param list: the SortedList
	 */
	private static Object removeMain(SortedList list)
	{
		System.out.println("Please enter the id number you want to remove");
		int idNumber = SC.nextInt();
		SC.nextLine();
		
		// create a dummy student (only the id # matters here) to search with
		Student dummy = new Student(idNumber, "Name");
		return list.remove(dummy);
	}
	
	/**
	 * search through the SortedList for a student with the user inputted id #
	 * 
	 * @param list: the SortedList
	 * @return: the first occurence of a Student with that id #
	 */
	private static Object searchMain(SortedList list)
	{
		System.out.println("Please enter the id of the student you want to search");
		int idNumber = SC.nextInt();
		SC.nextLine();
		
		// create a dummy student (only the id # matters here) to search with
		Student dummy = new Student(idNumber, "Name");
		return list.search(dummy);
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
