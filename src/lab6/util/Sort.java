package lab6.util;

public abstract class Sort
{
	/**
	 * Sorts the array into ascending numerical order.
	 */
	public abstract void sort(int[] v);

	/**
	 * Sorts the elements of the sub-vector v[first..last].
	 *
	 * @param v				Array to sort
	 * @param first			Index to begin sorting at
	 * @param last			Index to end sorting at
	 * @param insertion		Use insertion sort for small arrays
	 */
	protected void quickSort(int[] v, int first, int last, boolean insertion)
	{
		// Check whether insertion sort should be used.
		if (insertion)
		{
			// Use insertion for less than 10 elements.
			if (last - first < 10)
			{
				insertionSort(v, first, last);
				return;
			}
		}
		// Otherwise, only use quick sort
		else
		{
			if (first >= last) // Less than two elements
				return;
		}

		// Calculate a new pivot based on the range
		int pivot = pivot(first, last);
		int p = v[pivot];

		// Partition the elements so that every number of
		// v[first..mid] <= p and every number of v[mid+1..last] > p.
		int[] res = partition(v, first, last, p);
		int mid = (res[0] + res[1]) / 2;

		quickSort(v, first, mid, insertion);
		quickSort(v, mid + 1, last, insertion);
	}

	/**
	 * Reorders the elements of the sub-array v[first..last] so that
	 * all elements in v[first..low-1] are less than pivot,
	 * all elements in v[low..high] are equal to pivot,
	 * all elements in v[high+1..last] are greater than pivot.
	 *
	 * Precondition: first < last.
	 */
	private int[] partition(int[] v, int first, int last, int pivot)
	{
		int low = first;
		int mid = first;
		int high = last;

		while (mid <= high) {
			// Invariant:
			//  - v[first..low-1] < pivot
			//  - v[low..mid-1] = pivot
			//  - v[mid..high] are unknown
			//  - v[high+1..last] > pivot
			//
			//       < pivot   = pivot      unknown     > pivot
			//     -----------------------------------------------
			// v: |          |          |a            |           |
			//     -----------------------------------------------
			//     ^          ^          ^           ^           ^
			//    first      low        mid         high        last
			//
			int a = v[mid];
			if (a < pivot) {
				v[mid] = v[low];
				v[low] = a;
				low++;
				mid++;
			} else if (a == pivot) {
				mid++;
			} else { // a > pivot
				v[mid] = v[high];
				v[high] = a;
				high--;
			}
		}

		return new int[] {low, high};
	}

	/**
	 * Select a pivot in a given range.
	 *
	 * @param first		Lower bound
	 * @param last		Higher bound
	 * @return			Pivot index for the given sub-selection
	 */
	protected abstract int pivot(int first, int last);

	/**
	 * Sort an array using insertion sort
	 *
	 * @param v		Int array to sort
	 */
	private void insertionSort(int[] v, int first, int last)
	{
		for(int i = first + 1; i < last + 1; i++) {
			int temp = v[i];
			int j;
			for(j = i - 1; j >= first && temp < v[j]; j--)
				v[j + 1] = v[j];
			v[j + 1] = temp;
		}
	}
}