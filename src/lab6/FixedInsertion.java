package lab6;

import lab6.util.Sort;

/**
 * Sort arrays using the fixed pivot v[first], with insertion.
 */
public class FixedInsertion extends Sort
{
	/**
	 * Sorts the array into ascending numerical order.
	 * Uses the fixed pivot v[mid], and insertion sort.
	 *
	 * @param v			Array to sort
	 */
	@Override
	public void sort(int[] v)
	{
		// Sort with pivot v[0], using insertion sort
		quickSort(v, 0, v.length - 1, true);
	}

	/**
	 * Select a pivot in a given range.
	 *
	 * @param first		Lower bound
	 * @param last  	Higher bound
	 * @return			Pivot index for the given sub-selection
	 */
	@Override
	protected int pivot(int first, int last)
	{
		return (first + last) / 2;
	}
}
