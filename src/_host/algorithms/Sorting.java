package _host.algorithms;

public class Sorting
{
	/**
	 * Sort an array using insertion sort
	 *
	 * @param a		Int array to sort
	 */
	public void insertionSort(int[] a)
	{
		// For all numbers in the array except the first one
		for (int j = 1; j < a.length; j++)
		{
			// The current number as a temporary variable
			int key = a[j];

			// For all the numbers left of of the current one,
			// larger than the current one, stepping from the right
			int i = j - 1;

			while (i >= 0 && a[i] > key)
			{
				// Move them one step to the right
				a[i + 1] = a[i];
				i--;
			}

			// ... to make room for insertion of this one
			a[i+1] = key;
		}
	}

	public int max(int[] a)
	{
		// Assume the 0th is max
		int m = a[0];

		// Find maxes greater than the current one
		for (int i = 1; i < a.length; i++)
			if (a[i] > m)
				m = a[i];

		return m;
	}

	/**
	 * Sort the elements in ascending order.
	 * This algorithm has time complexity Theta(n*n), where n is
	 * the length of the array.
	 *
	 * @param a    An array of integers.
	 */
	public void selectionSort(int[] a)
	{
		int n = a.length;

		for (int i = 0; i < n - 1; i++)
		{
			// find index m of min element in a[i..n-1]
			int m = i;

			for (int j = i + 1; j < n; j++)
				if (a[j] < a[m])
					m = j;

			// swap a[i] and a[m]
			int temp = a[i];
			a[i] = a[m];
			a[m] = temp;
		}
	}

	public int[] reverse(int[] a)
	{
		int n = a.length;
		int[] b = new int [n];

		for (int i = 0; i < n; i++)
		{
			b[n-1-i] = a[i];
		}

		return b;
	}
}