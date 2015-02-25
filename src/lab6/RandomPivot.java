package lab6;

import lab6.util.Sort;

import java.util.Random;

/**
 * Sort arrays using the a random pivot, and no insertion.
 */
public class RandomPivot extends Sort
{
	/**
	 * Sorts the array into ascending numerical order.
	 * Uses a random pivot selection, and no insertion sort.
	 *
	 * @param v		Array to sort
	 */
	@Override
	public void sort(int[] v)
	{
		// Perform quick sort on the array
		quickSort(v, 0, v.length - 1, false);
	}

	/**
	 * Select a pivot in a given range.
	 *
	 * @param first Lower bound
	 * @param last  Higher bound
	 * @return Pivot index for the given sub-selection
	 */
	@Override
	protected int pivot(int first, int last)
	{
		return first + new Random().nextInt(last - first);
	}
}
