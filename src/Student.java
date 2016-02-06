
/******************************************************************************
* Savion Sample
* Student Class
* 
* Contains all the information of a student (their ID number and name).
* Contains a getter methods for retrieving their ID and name as well as a toString()
*
******************************************************************************/

public class Student implements Comparable 
{
	private int id;
	private String name;
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Compares the IDs of this Student and another Student and returns
	 * a negative or positive number based on which Student's ID comes first
	 */
	public int compareTo(Object otherStudent)
	{
		Student other = (Student) otherStudent;
		return id - other.getId();
	}
	
	/*
	 * getter methods
	 */
	public String getName()
	{
		return name;
	}

	public int getId()
	{
		return id;
	}
	
	/**
	 * returns the Student's information as a String
	 */
	public String toString()
	{
		return "Name: " + name + "\tid: " + id + "\n";
	}

}
