package stack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class StackTest
{
    GenericStack<String> stack = new GenericStack<>();

    @Test
    public void testPush() throws Exception
    {
        // Test push
        stack.push("Flowerbed");
        assertEquals("Flowerbed", stack.top());
    }

    @Test(expected = NoSuchElementException.class)
    public void testTop() throws Exception
    {
        // Test for empty stack
        stack.top();

        // Test for populated stack
        stack.push("Top");
        assertEquals("Top", stack.top());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPop() throws Exception
    {
        // Test for empty stack
        stack.pop();

        // Test for populated stack
        stack.push("Top");
        stack.push("Topmost");
        assertEquals("Topmost", stack.pop());
        assertEquals("Top", stack.pop());
    }

    @Test
    public void testSize() throws Exception
    {
        // Test for empty stack
        assertEquals(0, stack.size());

        // Test for regular stack
        stack.push("Top");
        stack.push("Topmost");
    }

    @Test
    public void testIsEmpty() throws Exception
    {
        // Test for empty stack
        assertEquals(true, stack.isEmpty());

        // Test for populated stack
        stack.push("Element");
        assertEquals(false, stack.isEmpty());

        // Test for popped stack
        stack.pop();
        assertEquals(true, stack.isEmpty());
    }
}