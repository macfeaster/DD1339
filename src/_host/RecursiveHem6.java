package _host;

public class RecursiveHem6
{
    public static void main(String[] args) {
        RecursiveHem6 r = new RecursiveHem6();

        int[] v = {12, 20, 5, 3, 9, 42, 23, 234, 643, 345, 34, 5, 34, 5, 34, 5, 34, 5, 73, 73, 123, 754, 12, 2};

        System.out.println(r.sum(v, 0, 4));
        System.out.println(r.sumIterative(v, 0, 4));

        System.out.println(r.maxIterative(v));
        System.out.println(r.maxRecursive(v));
    }

	/**
	 * Computes n!.
	 * Precondition: 0 <= n <= 20.
	 * (20! < 2^63 - 1, the maximum value of a long.)
	 */
	public long factorial(int n) {
		if (n == 0) {
			return 1;
		} else {   // n > 0
			return n*factorial(n - 1);
		}
	}

	public long iterative(int n)
	{
		long base = n;

        while (n > 1)
        {
            base = base * (n - 1);
            n--;
        }

        return base;
	}

    /**
     * Computes the sum of the elements from v[first] to v[last].
     * Precondition: 0 <= first <= last < v.length.
     */
    public long sum(int[] v, int first, int last) {
        if (first == last) {
            return v[first];
        } else {   // first < last
            return v[first] + sum(v, first + 1, last);
        }
    }

    public long sumIterative(int[] v, int first, int last)
    {
        long sum = 0;

        for (int i = first; i <= last; i++)
            sum += v[i];

        return sum;
    }

    public int maxIterative(int[] v)
    {
        int max = 0;

        for (int e : v)
            if (e > max)
                max = e;

        return max;
    }

    public int maxRecursive(int[] v)
    {
        return recHelper(v, 0, 0);
    }

    private int recHelper(int[] v, int index, int max)
    {
        // Make sure we're not playing outside the array
        if(index >= v.length)
            return max;

        // If new max is found, change the rules, otherwise, go on
        if (v[index] > max)
            return recHelper(v, index + 1, v[index]);
        else
            return recHelper(v, index + 1, max);
    }
}