
public class Student implements Comparable {
	
	private String name;
	private int id;
	
	public Student(int id, String name)
	{
		this.name = name;
		this.id = id;
	}
	
	public int compareTo(Object otherStudent)
	{
		Student other = (Student) otherStudent;
		return id - other.getId();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String toString()
	{
		return "Name: " + name + "\tid: " + id + "\n";
	}
	

	
	

}
