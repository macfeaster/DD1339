package lab4;

/**
 * A dictionary of Strings. Cannot contain duplicates.
 *
 * @author	Mauritz Zachrisson
 */
public class StringHash implements StringDictionary
{
	private ListElement[] table;
	private int size;

	/**
	 * Construct a new StringHash set of a given size
	 *
	 * @param size	Maximum number of allowed elements
	 */
	public StringHash(int size)
	{
		table = new ListElement[size];
		this.size = size;
	}

	/**
	 * Private helper class for list elements at table[i]
	 */
	private static class ListElement
	{
		String value;
		ListElement next = null;

		public ListElement(String value)
		{
			this.value = value;
		}
	}

	/**
	 * Adds the given string to this table.
	 * Returns <code>true</code> if the dictionary
	 * did not already contain the given string.
	 *
	 * Complexity: O(1) expected time.
	 *
	 * @param s		String to add
	 */
	@Override
	public boolean add(String s)
	{
		// Null cannot be hashed, and thus addition of it is prohibited
		if (s == null)
			return false;

		// Calculate index position based on hashcode
		int i = h(s);
		ListElement c = new ListElement(s);
		boolean contains = !contains(s);

		if (table[i] == null)
			table[i] = c;
		else
			c.next = table[i];

		// System.out.println(table[i] + " contains " + s + ": " + contains(s));
		return contains;
	}

	/**
	 * Removes the given string from this dictionary
	 * if it is present. Returns <code>true</code> if
	 * the dictionary contained the specified element.
	 *
	 * Complexity: O(1) expected time.
	 *
	 * @param s		String to remove
	 */
	@Override
	public boolean remove(String s)
	{
		int i = h(s);
		ListElement c = table[i];

		// If the first element at table[i] does not exist, create it
		if (c == null)
			return false;

		// Traverse the list at table[i] until its end
		while (c.next != null)
		{
			// If the String is already in the list, return false
			if (c.next.value.equals(s))
			{
				c.next = c.next.next;
				return true;
			}

			c = c.next;
		}

		return false;
	}

	/**
	 * Returns <code>true</code> if the string is
	 * in this dictionary.
	 *
	 * Complexity: O(1) expected time.
	 *
	 * @param s		String to search for
	 */
	@Override
	public boolean contains(String s)
	{
		// Null cannot be hashed, and thus it is never a value
		if (s == null)
			return false;

		int i = h(s);
		ListElement c = table[i];

		if (c == null)
			return false;

		do
		{
			if (c.value.equals(s))
			{
				System.out.println("Value c: " + c + " equals " + s);
				return true;
			}

			c = c.next;
		}
		while (c != null && c.next != null);

		return false;
	}

	/**
	 * Calculate the table index of a given String using its hashcode.
	 *
	 * @param s		Input string
	 * @return		Table index
	 */
	private int h(String s) { return Math.abs(s.hashCode() % size); }
}