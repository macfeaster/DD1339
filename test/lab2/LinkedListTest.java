package lab2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest
{
    public static final String ELEMENT = "Psy";
    private final LinkedList<String> list = new LinkedList<>();

    @Before
    public void setUp() 
    {
        list.addFirst("First");
        list.addLast("Last");
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
    @Test
    public void testIsHealthy() 
    {
        list.clear();

        // Test for size == 0
        assertTrue(list.isHealthy());

        list.addFirst("First");
        list.addLast("Second");
        list.addLast("Last");

        // Test for size > 0
        assertTrue(list.isHealthy());

        // Test for size == 1
        list.clear();
        list.addFirst("First");
        assertTrue(list.isHealthy());

        list.clear();

    }

    @Test
    public void testAddFirst() 
    {
        list.addFirst(ELEMENT);
        assertEquals(ELEMENT, list.getFirst());
        assertTrue(list.isHealthy());
    }

    @Test
    public void testAddLast() 
    {
        list.addLast(ELEMENT);
        assertEquals(ELEMENT, list.getLast());
        assertTrue(list.isHealthy());
    }

    @Test
    public void testGetFirst() 
    {
        assertEquals("First", list.getFirst());
        list.clear();
        assertNull(list.getFirst());
        assertTrue(list.isHealthy());

        list.addLast("Last");
        assertEquals("Last", list.getFirst());
    }

    @Test
    public void testGetLast() 
    {
        assertEquals("Last", list.getLast());
        list.clear();
        assertNull(list.getLast());
        assertTrue(list.isHealthy());

        list.addFirst("First");
        assertEquals("First", list.getLast());
    }

    @Test
    public void testGet() 
    {
        list.clear();
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertNull(list.get(200));
        assertTrue(list.isHealthy());

        list.clear();
        list.addFirst("2");
        list.addFirst("1");
        list.addLast("3");
        list.addLast("4");
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    public void testRemoveFirst() 
    {
        list.addFirst(ELEMENT);
        list.removeFirst();

        assertNotEquals(ELEMENT, list.getFirst());
        assertTrue(list.isHealthy());

        list.clear();
        list.removeFirst();
    }

    @Test
    public void testClear() 
    {
        list.clear();
        assertNull(list.getFirst());
        assertNull(list.getLast());
        assertEquals(0, list.size());
        assertTrue(list.isHealthy());
    }

    @Test
    public void testSize() 
    {
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() 
    {
        assertEquals(false, list.isEmpty());

        list.clear();
        assertEquals(true, list.isEmpty());
        assertTrue(list.isHealthy());
    }

    @Test
    public void testToString() 
    {
        assertEquals("[First, Last]", list.toString());
    }
}