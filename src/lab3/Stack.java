package lab3;

import java.util.NoSuchElementException;

public interface Stack<T>
{
    /**
     * Pushes an element o into the top of the lab3.stack,
     * i.e. adds it to the first position of it.
     *
     * @param o     Object to add.
     */
    public void push(T o);

    /**
     * Removes and returns the top element of the lab3.stack,
     * i.e. extracts the element at the first position.
     *
     * @return      The element that was removed.
     * @throws      NoSuchElementException if the lab3.stack is empty.
     */
    public T pop() throws NoSuchElementException;

    /**
     * Returns the first element at the top of the lab3.stack,
     * without removing it from the lab3.stack.
     *
     * @return      The element at the top of the lab3.stack.
     * @throws      NoSuchElementException if the lab3.stack is empty.
     */
    public T top() throws NoSuchElementException;

    /**
     * Returns the current size of the lab3.stack.
     *
     * @return      Size of the lab3.stack as an integer.
     */
    public int size();

    /**
     * Checks whether the lab3.stack is empty.
     *
     * @return      True if empty, false otherwise.
     */
    public boolean isEmpty();
}
