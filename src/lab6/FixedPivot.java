package lab6;

import lab6.util.Sort;

/**
 * Sort arrays using the fixed pivot v[first], and no insertion.
 */
public class FixedPivot extends Sort
{
	/**
	 * Sorts the array into ascending numerical order.
	 * Uses the fixed pivot v[first], and no insertion sort.
	 *
	 * @param v			Array to sort
	 */
	@Override
	public void sort(int[] v)
	{
		// Sort with pivot v[0]
		quickSort(v, 0, v.length - 1, false);
	}

	/**
	 * Select a pivot in a given range.
	 *
	 * @param first 	Lower bound
	 * @param last  	Higher bound
	 * @return 			Pivot index for the given sub-selection
	 */
	@Override
	protected int pivot(int first, int last)
	{
		return first;
	}
}
