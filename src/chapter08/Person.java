package chapter08;

public class Person
{
	protected String id;
	protected String name;

	/**
	 * Construct a person with a given name and ID
	 */
	public Person(String name, String id)
	{
		this.name = name;
		this.id = id;
	}

	// Getters
	public String getId() { return id; }
	public String getName() { return name; }

	/**
	 * Return the login name of this person (a combination of the first four letters
	 * of the person's name and the first three characters of their ID number.
	 */
	public String getLoginName() { return name.substring(0,4) + id.substring(0,3); }

	/**
	 * Print out all the details surrounding this person
	 */
	public void print() { System.out.println(toString()); }

	@Override
	public String toString()
	{
		return name + ", ID code: " + id;
	}
}
