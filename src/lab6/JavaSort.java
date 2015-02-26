package lab6;

import lab6.util.Sort;

import java.util.Arrays;

/**
 * Sort an array using Java's sorting algorithm.
 */
public class JavaSort extends Sort
{
	/**
	 * Sorts the array into ascending numerical order.
	 *
	 * @param v		Array to sort
	 */
	@Override
	public void sort(int[] v)
	{
		Arrays.sort(v);
	}

	/**
	 * Select a pivot in a given range.
	 * Not used here since Arrays.sort requires no pivot.
	 *
	 * @param first Lower bound
	 * @param last  Higher bound
	 * @return Pivot index for the given sub-selection
	 */
	@Override
	protected int pivot(int first, int last) { return 0; }
}
