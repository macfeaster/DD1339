package lab2;

/**
 * A singly linked list.
 *
 * @author		Mauritz Zachrisson
 * @version		0.1
 */
public class LinkedList<T>
{
	private ListElement<T> first;   // First element in list.
	private ListElement<T> last;    // Last element in list.
	private int size;               // Number of elements in list.

	/**
	 * A list element.
	 */
	private static class ListElement<T>
	{
		public T data;
		public ListElement<T> next;

		public ListElement(T data)
		{
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * This TEST METHOD returns true if the following invariants hold:
	 * <ul>
	 *   <li> size equals the number of list elements, </li>
	 *   <li> if size == 0, first == null and last == null, </li>
	 *   <li> if size > 0, first != null and last != null, </li>
	 *   <li> if size == 1, first == last, </li>
	 *   <li> last.next == null. </li>
	 * </ul>
	 */
	public boolean isHealthy()
	{
		// Check that size matches actual count
		if (count() != size)
			return false;

		// Check that an empty list is really empty
		if (size == 0 && (first != null || last != null))
			return false;

		// Check that a populated list's last or false are not null
		if (size > 0 && (first == null || last == null))
			return false;

		// Check that first == last in a one element list
		if (size == 1 && first != last)
			return false;

		// Check that last.next == null if last != null
		if (last != null)
			if (last.next != null)
				return false;

		return true;
	}

	/**
	 * Count the amount of elements in the list
	 */
	private int count()
	{
		if (first == null)
			return 0;

		ListElement<T> e = first;
		int count = 1;

		while (e.next != null)
		{
			e = e.next;
			count++;
		}

		return count;
	}

	/**
	 * Creates an empty list.
	 */
	public LinkedList()
	{
		first = null;
		last = null;
		size = 0;
	}

	/**
	 * Inserts the given element at the beginning of this list.
	 */
	public void addFirst(T element)
	{
		ListElement<T> currentFirst = first;
		first = new ListElement<>(element);
		first.next = currentFirst;

		if (isEmpty())
			last = first;

		size++;
	}

	/**
	 * Inserts the given element at the end of this list.
	 */
	public void addLast(T element)
	{
		// Create a new element for the new data
		ListElement<T> newLast = new ListElement<>(element);

		// Handle edge case: empty list
		if (isEmpty())
		{
			first = newLast;
			last = newLast;
		}
		else
		{
			// Link the current last element to the new one
			// And make the new last the last element
			last.next = newLast;
			last = newLast;
		}

		// Increase the size counter
		size++;
	}

	/**
	 * Returns the first element of this list.
	 * Returns <code>null</code> if the list is empty.
	 */
	public T getFirst()
	{
		if (size == 0 || first == null)
			return null;
		else
			return first.data;
	}

	/**
	 * Returns the last element of this list.
	 * Returns <code>null</code> if the list is empty.
	 */
	public T getLast()
	{
		// Edge case: empty list
		if (size == 0)
			return null;
			// Last is null
		else if (last == null)
		{
			// Edge case: last is actually first
			// If last is null but first isn't return first
			return first != null ? first.data : null;
		}
		// Last exists
		else
			return last.data;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * Returns <code>null</code> if <code>index</code> is out of bounds.
	 */
	public T get(int index)
	{
		ListElement<T> e = getElement(index);
		return (e != null) ? e.data : null;
	}

	private ListElement<T> getElement(int index)
	{
		if (index > size || index < 0 )
			return null;

		ListElement<T> current = first;
		int i = 0;

		while (i < index)
		{
			if (current == null)
				return null;
			current = current.next;
			i++;
		}

		return (current != null) ? current : null;
	}

	/**
	 * Removes and returns the first element from this list.
	 * Returns <code>null</code> if the list is empty.
	 */
	public T removeFirst()
	{
		// Check that the list is not empty
		if (size == 0)
			return null;

		// Extract the data and modify the list
		T removedData = first.data;
		first = first.next;
		size--;

		// If the first element removed is the only element
		// set the last element to null to completely empty the list
		if (isEmpty())
			last = null;

		// Return the extracted data
		return removedData;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear()
	{
		first = null;
		last = null;
		size = 0;
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Returns <code>true</code> if this list contains no elements.
	 */
	public boolean isEmpty()
	{
		return (size == 0);
	}

	/**
	 * Returns a string representation of this list. The string
	 * representation consists of a list of the elements enclosed in
	 * square brackets ("[]"). Adjacent elements are separated by the
	 * characters ", " (comma and space). Elements are converted to
	 * strings by the method toString() inherited from Object.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		ListElement<T> current = first;
		int i = 0;

		while (i < size)
		{
			if (current == null)
				break;
			sb.append(current.data).append(", ");
			current = current.next;
			i++;
		}

		if (sb.length() > 2)
			sb.setLength(sb.length() - 2);

		return String.format("[%s]", sb);
	}
}