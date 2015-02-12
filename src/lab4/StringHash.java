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
		// One must add actual Strings to a StringHash
		if (s == null)
			return false;

		// Calculate slot position based on hashcode
		int i = h(s);

		// Create a new element for the String
		ListElement c = new ListElement(s);

		// If the dictionary contains the String, return false
		if(contains(s))
			return false;

		// If this slot is empty, populate it
		if (table[i] == null)
			table[i] = c;
		else
		{
			// If not, insert the new element
			c.next = table[i];
			table[i] = c;
		}

		return true;
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
		// Null cannot be removed, since null is prohibited
		if (s == null)
			return false;

		// Calculate slot position based on hashcode
		int i = h(s);

		// Iterate over the elements in the linked list:
		//    e: current element
		//    prev: previous element
		for (ListElement e = table[i], prev = e; e != null; prev = e, e = e.next)
			if (e.value.equals(s))
			{
				// If element to be removed is first within the list,
				// move the list one step
				if (e == table[i])
					table[i] = table[i].next;
				// Otherwise have its predecessor point to its successor
				else
					prev.next = e.next;

				return true;
			}

		// Element was not found
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
		// Null cannot be removed, since null is prohibited
		if (s == null)
			return false;

		// Calculate slot position based on hashcode
		int i = h(s);

		// Look in the appropriate slot, if found return true
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
		return Math.abs(s.hashCode() % size);
	}
}