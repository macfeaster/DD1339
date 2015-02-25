package lab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest2
{

    private LinkedList<Object> list1;
    private LinkedList<Object> list2;
    private LinkedList<Object> list3;

    private int n1; // Expected size of list1
    private int n2; // Expected size of list2
    private int n3; // Expected size of list3

    @Before
    public void setUp() {

        list1 = new LinkedList<>();
        list1.addFirst("carrot");
        list1.addFirst("broccoli");
        list1.addLast("batman");
        list1.addLast("eggplant");
        n1 = 4;

        list2 = new LinkedList<>();
        n2 = 0;

        list3 = new LinkedList<>();
        list3.addFirst("swag");
        n3 = 1;
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testIsHealthy() {
        assertTrue(list1.isHealthy());
        assertTrue(list2.isHealthy());
        assertTrue(list3.isHealthy());
    }

    @Test
    public void testLinkedList() {

        assertTrue(list1.isHealthy());

        assertTrue(list2.isHealthy());
        assertNull(list2.getFirst());
        assertNull(list2.getLast());
        assertEquals(n2, list2.size());

        assertEquals(list3.getFirst(), list3.getLast());
        assertEquals(n3, list3.size());

    }

    @Test
    public void testAddFirst() {

        list1.addFirst("avocado");
        assertEquals("avocado", list1.getFirst());
        assertTrue("avocado" != list1.getLast());
        assertEquals(++n1, list1.size());
        assertTrue(list1.isHealthy());

        list2.addFirst("superman");
        assertEquals("superman", list2.getFirst());
        assertEquals("superman", list2.getLast());
        assertEquals(++n2, list2.size());
        assertTrue(list2.isHealthy());

    }

    @Test
    public void testAddLast() {

        list1.addLast("Frankly, my dear, I don't give a damn.");
        assertEquals("Frankly, my dear, I don't give a damn.", list1.getLast());
        assertTrue("Frankly, my dear, I don't give a damn." != list1.getFirst());
        assertEquals(++n1, list1.size());
        assertTrue(list1.isHealthy());

        list2.addLast("You're gonna need a bigger boat.");
        assertEquals("You're gonna need a bigger boat.", list2.getFirst());
        assertEquals("You're gonna need a bigger boat.", list2.getLast());
        assertEquals(++n2, list2.size());
        assertTrue(list2.isHealthy());
    }

    @Test
    public void testGetFirst() {

        assertEquals("broccoli", list1.getFirst());

        assertNull(list2.getFirst());
    }

    @Test
    public void testGetLast() {

        assertEquals("eggplant", list1.getLast());

        assertNull(list2.getLast());
    }

    @Test
    public void testGet() {

        assertEquals("broccoli", list1.get(0));
        assertEquals("carrot", list1.get(1));
        assertEquals("batman", list1.get(2));
        assertEquals("eggplant", list1.get(3));
        assertNull(list1.get(4));
        assertNull(list1.get(-1));

        assertNull(list2.get(0));
        assertNull(list2.get(1));
    }

    @Test
    public void testRemoveFirst() {

        assertEquals("broccoli", list1.removeFirst());
        assertEquals(--n1, list1.size());
        assertEquals("carrot", list1.getFirst());
        assertTrue(list1.isHealthy());

        assertNull(list2.getFirst());
        assertTrue(list2.isHealthy());
    }

    @Test
    public void testClear() {

        list1.clear();
        n1 = 0;
        assertNull(list1.getFirst());
        assertNull(list1.getLast());
        assertEquals(n1, list1.size());
        assertTrue(list1.isEmpty());
        assertTrue(list1.isHealthy());

        list2.clear();
        assertNull(list2.getFirst());
        assertNull(list2.getLast());
        assertEquals(n1, list2.size());
        assertTrue(list2.isEmpty());
        assertTrue(list2.isHealthy());
    }

    @Test
    public void testSize() {

        assertEquals(n1, list1.size());
        list1.addFirst("avocado");
        assertEquals(++n1, list1.size());
        list1.removeFirst();
        assertEquals(--n1, list1.size());
        assertTrue(list1.isHealthy());

        assertEquals(n2, list2.size());
        list2.removeFirst();
        assertEquals(n2, list2.size());

        assertEquals(n3, list3.size());
        list3.removeFirst();
        assertEquals(--n3, list3.size());
        list3.addFirst("yolo");
        assertEquals(++n3, list3.size());
    }

    @Test
    public void testIsEmpty() {

        assertFalse(list1.isEmpty());
        list1.clear();
        assertTrue(list1.isEmpty());
        list1.addFirst("potato");
        assertFalse(list1.isEmpty());
        assertTrue(list1.isHealthy());

        assertTrue(list2.isEmpty());
        assertTrue(list2.isHealthy());

        assertFalse(list3.isEmpty());
        list3.removeFirst();
        assertTrue(list3.isEmpty());
        assertTrue(list3.isHealthy());
    }

    @Test
    public void testToString() {

        assertEquals("[broccoli, carrot, batman, eggplant]", list1.toString());

        assertEquals("[]", list2.toString());

        assertEquals("[swag]", list3.toString());
    }
}