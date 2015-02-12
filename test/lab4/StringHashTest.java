package lab4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for StringHash class
 */
public class StringHashTest
{
	private StringHash set;
	private StringHash set2;

	@Before
	public void setUp()
	{
		// Set up dictionaries
		set = new StringHash(2);
		set2 = new StringHash(20);

		// Add some counter data
		for (int i = 0; i < 2000; i++)
			set2.add("Integer " + i);
	}

	@Test
	public void testAdd()
	{
		// Test regular add
		assertTrue(set.add("Psy"));
		assertTrue(set.add("Oppa"));

		// Test for large sets
		for (int i = 0; i < 2000; i++)
			assertFalse(set2.add("Integer " + i));
	}

	@Test
	public void testAddNull()
	{
		// Adding null will not work
		assertFalse(set.add(null));
	}

	@Test
	public void testAddDuplicates()
	{
		// Adding duplicates should return false
		assertTrue(set.add("Psy"));
		assertFalse(set.add("Psy"));
	}

	@Test
	public void testRemove()
	{
		// Removal of counters should return true
		for (int i = 0; i < 2000; i++)
			assertTrue(set2.remove("Integer " + i));

		// Add some dummy data
		set.add("Psy");
		set.add("Oppa");
		set2.add(null);

		// Removal of existing content should return true
		// Removal of non-existent content should return false
		assertTrue(set.remove("Psy"));
		assertFalse(set.remove("Style!"));

		// Removal of null will not work
		assertFalse(set2.remove(null));
	}

	@Test
	public void testContains()
	{
		// Empty list should be empty
		assertFalse(set.contains("Psy"));
		assertFalse(set.contains(null));

		// The counter data should be there
		for (int i = 0; i < 2000; i++)
			assertTrue(set2.contains("Integer " + i));
	}
}