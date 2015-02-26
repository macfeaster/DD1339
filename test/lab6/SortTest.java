package lab6;

import lab6.util.Data;
import lab6.util.Sort;
import lab6.util.Stopwatch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortTest
{
	Data[][] data;
	Sort[] algorithms;

	@Before
	public void setUp()
	{
		data = new Data[][] {
				new Data[] {
						new Data(100, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(500, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(1000, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(5000, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(10000, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(50000, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(100000, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(500000, Integer.MAX_VALUE, Data.Order.ASCENDING),
						new Data(1000000, Integer.MAX_VALUE, Data.Order.ASCENDING)
				},
				new Data[] {
						new Data(100, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(500, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(1000, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(5000, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(10000, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(50000, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(100000, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(500000, Integer.MAX_VALUE, Data.Order.DESCENDING),
						new Data(1000000, Integer.MAX_VALUE, Data.Order.DESCENDING)
				},
				new Data[] {
						new Data(100, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(500, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(1000, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(5000, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(10000, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(50000, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(100000, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(500000, Integer.MAX_VALUE, Data.Order.RANDOM),
						new Data(1000000, Integer.MAX_VALUE, Data.Order.RANDOM)
				},
				new Data[] {
						new Data(100, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(500, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(1000, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(5000, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(10000, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(50000, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(100000, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(500000, Integer.MAX_VALUE, Data.Order.SAME),
						new Data(1000000, Integer.MAX_VALUE, Data.Order.SAME)
				}
		};

		algorithms = new Sort[] {
				new FixedPivot(),
				new FixedInsertion(),
				new RandomPivot(),
				new RandomInsertion(),
				new JavaSort()
		};
	}

	@Test
	public void testSortAscending()
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
	public void testSortDescending()
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
	public void testSortRandom()
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

	@Test
	public void testTimeConsumption()
	{
		final int reps = 10;
		final Stopwatch clock = new Stopwatch();

		for (int i = 0; i < reps; i++)
		{
			// Per data type
			for (Data[] type : data)
			{
				for (Sort alg : algorithms)
				{
					System.out.print("INSERT INTO quicksort VALUES(" + i + ", '" + type[0].getOrder() + "', '");
					// Per data type (ascending, descending, random)
					System.out.print(alg.getClass().getSimpleName() + "', ");

					for (Data d : type)
					{
						clock.reset().start();

						int[] data = d.get();

						alg.sort(data);

						long time = clock.stop().milliseconds();

						System.out.print(time + ", ");
					}

					System.out.println("); ");
				}
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