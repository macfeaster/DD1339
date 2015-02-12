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
		// Calculate index position based on hashcode
		int i = h(s);
		ListElement c = new ListElement(s);
		boolean contains = !contains(s);

		if (table[i] == null)
			table[i] = c;
		else
			c.next = table[i];

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

		for (ListElement e = table[i]; e != null; e = e.next)
			if (e.next != null)
				if (s.equals(e.next.value))
				{
					e.next = e.next.next;
					return true;
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
		int i = h(s);

		for (ListElement e = table[i]; e != null; e = e.next)
			if (s.equals(e.value))
				return true;

		return false;
	}

	/**
	 * Calculate the table index of a given String using its hashcode.
	 *
	 * @param s		Input string
	 * @return		Table index
	 */
	private int h(String s)
	{
		if (s == null)
			return 0;
		else
			return Math.abs(s.hashCode() % size);
	}
}