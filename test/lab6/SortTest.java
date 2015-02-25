package lab6;

import lab6.util.Data;
import lab6.util.Sort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortTest
{
	Data[][] data;
	Sort[] algorithms;

	@Before
	public void setUp() throws Exception
	{
		data = new Data[][] {
				new Data[] {
						new Data(100, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(200, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(400, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(800, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(1600, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(3200, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(6400, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(12800, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(25600, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(51200, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(102400, Integer.MAX_VALUE, Data.Order.ASCENDING)
				},
				new Data[] {
						new Data(100, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(200, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(400, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(800, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(1600, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(3200, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(6400, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(12800, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(25600, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(51200, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(102400, Integer.MAX_VALUE, Data.Order.DESCENDING)
				},
				new Data[] {
						new Data(100, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(200, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(400, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(800, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(1600, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(3200, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(6400, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(12800, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(25600, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(51200, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(102400, Integer.MAX_VALUE, Data.Order.RANDOM)
				}
		};

		algorithms = new Sort[] {
				new FixedPivot(),
				new FixedInsertion(),
				new RandomPivot(),
				new RandomInsertion()
		};
	}

	@Test
	public void testSortAscending() throws Exception
	{
		// Test sorting for ascending values
		Data[] type = data[0];

		for (Data d : type)
		{
			for (Sort alg : algorithms)
			{
				// Set up a copy of the data
				int[] data = d.get();

				// Sort it
				alg.sort(data);

				// Test sorting
				assertTrue(isSorted(data));
			}
		}
	}

	@Test
	public void testSortDescending() throws Exception
	{
		// Test sorting for ascending values
		Data[] type = data[1];

		for (Data d : type)
		{
			for (Sort alg : algorithms)
			{
				// Set up a copy of the data
				int[] data = d.get();

				// Sort it
				alg.sort(data);

				// Test sorting
				assertTrue(isSorted(data));
			}
		}
	}

	@Test
	public void testSortRandom() throws Exception
	{
		// Test sorting for ascending values
		Data[] type = data[2];

		for (Data d : type)
		{
			for (Sort alg : algorithms)
			{
				// Set up a copy of the data
				int[] data = d.get();

				// Sort it
				alg.sort(data);

				// Test sorting
				assertTrue(isSorted(data));
			}
		}
	}


	/**
	 * Check whether a given int array is sorted.
	 *
	 * @param v		Array to examine
	 * @return		True if sorted, false otherwise
	 */
	private boolean isSorted(int[] v)
	{
		// Look for unsorted elements
		for (int i = 0; i < v.length - 1; i++)
			if (v[i] > v[i + 1])
				return false;

		// If none were found, the array is sorted
		return true;
	}
}