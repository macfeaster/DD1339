package stack;

import java.util.NoSuchElementException;

/**
 * An implementation of the Stack interface.
 *
 * @author		Mauritz Zachrisson
 * @version		0.1
 */
public class GenericStack<T> implements Stack<T>
{
	private StackElement<T> top;    // Top element in stack.
	private int size;               // Number of elements in stack.

	/**
	 * A stack element.
	 */
	private static class StackElement<T>
	{
		public T data;
		public StackElement<T> next;

		public StackElement(T data)
		{
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * Creates an empty stack.
	 */
	public GenericStack()
	{
		top = null;
		size = 0;
	}

	/**
	 * Inserts the given element at the beginning of this stack.
	 */
	@Override
	public void push(T element)
	{
		StackElement<T> currentTop = top;
		top = new StackElement<>(element);
		top.next = currentTop;

		size++;
	}

	/**
	 * Returns the top element of this stack.
	 * Returns <code>null</code> if the stack is empty.
	 */
	@Override
	public T top() throws NoSuchElementException
	{
		if (isEmpty())
			throw new NoSuchElementException();
		else
			return top.data;
	}

	/**
	 * Removes and returns the top element from this stack.
	 * Returns <code>null</code> if the list is empty.
	 */
	@Override
	public T pop() throws NoSuchElementException
	{
		// Check that the list is not empty
		if (isEmpty())
			throw new NoSuchElementException();

		// Extract the data and modify the list
		T removedData = top.data;
		top = top.next;
		size--;

		// Return the extracted data
		return removedData;
	}

	/**
	 * Returns the number of elements in this stack.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Returns <code>true</code> if stack list contains no elements.
	 */
	@Override
	public boolean isEmpty()
	{
		return (size == 0);
	}
}