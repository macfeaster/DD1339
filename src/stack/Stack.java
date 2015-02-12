package stack;

import java.util.NoSuchElementException;

public interface Stack<T>
{
    /**
     * Pushes an element o into the top of the stack,
     * i.e. adds it to the first position of it.
     *
     * @param o     Object to insert.
     */
    public void push(T o);

    /**
     * Removes and returns the top element of the stack,
     * i.e. extracts the element at the first position.
     *
     * @return      The element that was removed.
     * @throws      NoSuchElementException if the stack is empty.
     */
    public T pop() throws NoSuchElementException;

    /**
     * Returns the first element at the top of the stack,
     * without removing it from the stack.
     *
     * @return      The element at the top of the stack.
     * @throws      NoSuchElementException if the stack is empty.
     */
    public T top() throws NoSuchElementException;

    /**
     * Returns the current size of the stack.
     *
     * @return      Size of the stack as an integer.
     */
    public int size();

    /**
     * Checks whether the stack is empty.
     *
     * @return      True if empty, false otherwise.
     */
    public boolean isEmpty();
}
