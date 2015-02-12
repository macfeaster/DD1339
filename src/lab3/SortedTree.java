package lab3;

import java.util.TreeSet;

public class SortedTree
{
	public static void main(String[] args)
	{
		new SortedTree().run();
	}

	public void run()
	{
		TreeSet<Person> set = new TreeSet<>();

		set.add(new Person("Mary", 26));
		set.add(new Person("Kate", 12));
		set.add(new Person("Bob", 6));
		set.add(new Person("Lindsay", 99));
		set.add(new Person("Joe", 39));

		set.forEach(e -> System.out.println(e.name + ": " + e.age));
	}
}
