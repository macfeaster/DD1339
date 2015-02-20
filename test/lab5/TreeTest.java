package lab5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest
{
	Tree<Integer> t = new Tree<>();

	@Before
	public void setUp()
	{
		t.add(1);
		t.add(2);
		t.add(3);
	}

	@Test
	public void testContains()
	{
		assertTrue(t.contains(1));
		assertTrue(t.contains(2));
		assertTrue(t.contains(3));

		assertFalse(t.contains(4));
		assertFalse(t.contains(null));
	}

	@Test
	public void testAdd()
	{
		// Make sure stuff already added collides
		assertFalse(t.add(1));
		assertFalse(t.add(2));
		assertFalse(t.add(3));

		// Assert addition of anything else is possible
		assertTrue(t.add(4));
		assertTrue(t.add(5));
		assertTrue(t.add(6));

		// Assert addition of big integers is possible
		assertTrue(t.add(2247));
		assertTrue(t.add(100));

		// Assert that adding them again does not work
		assertFalse(t.add(100));
		assertFalse(t.add(2247));

		// Assert addition of negative integers works
		assertTrue(t.add(-2247));
		assertFalse(t.add(-2247));

		// Addition of null is prohibited
		assertFalse(t.add(null));
	}

	@Test
	public void testSize()
	{
		assertEquals(3, t.size());

		assertTrue(t.add(4));
		assertTrue(t.add(5));
		assertTrue(t.add(6));
		assertEquals(6, t.size());
	}

	@Test
	public void testDepth()
	{
		assertEquals(3, t.depth());

		Tree<Integer> t2 = new Tree<>();

		t2.add(20);
		t2.add(10);
		t2.add(15);
		assertEquals(3, t2.depth());
	}

	@Test
	public void testLeaves()
	{
		Tree<Integer> t2 = new Tree<>();
		t2.add(20); // Root node
		t2.add(10); // root.left
		t2.add(8); // 10.left
		t2.add(6); // 8.left
		t2.add(4); // 6.left => depth = 4

		assertEquals(1, t2.leaves());
	}

	@Test
	public void testToString()
	{
		// Check sequentially built tree
		assertEquals("[1, 2, 3]", t.toString());

		// Check non-sequentially built tree
		Tree<Integer> t2 = new Tree<>();
		t2.add(20);
		t2.add(10);
		t2.add(2);
		t2.add(15);
		assertEquals("[2, 10, 15, 20]", t2.toString());

		// Test empty tree
		Tree<Integer> t3 = new Tree<>();
		assertEquals("[]", t3.toString());
	}
}