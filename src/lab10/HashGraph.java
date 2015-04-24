package lab10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 * 
 * @author Mauritz Zachrisson
 * @version 4/22/2015
 */
public class HashGraph implements Graph {
	/**
	 * The map edges[v] contains the key-value pair (w, c) if there is an edge
	 * from v to w; c is the cost assigned to this edge. The maps may be null
	 * and are allocated only when needed.
	 */
	private final Map<Integer, Integer>[] edges;
	private final static int INITIAL_MAP_SIZE = 4;

	/** Number of edges in the graph. */
	private int numEdges;

	/**
	 * Constructs a HashGraph with n vertices and no edges. Time complexity:
	 * O(n)
	 * 
	 * @throws IllegalArgumentException
	 *             if n < 0
	 */
	public HashGraph(int n)
	{
		if (n < 0)
			throw new IllegalArgumentException("n = " + n);

		// The array will contain only Map<Integer, Integer> instances created
		// in addEdge(). This is sufficient to ensure type safety.
		@SuppressWarnings("unchecked")
		Map<Integer, Integer>[] a = new HashMap[n];
		edges = a;
	}

	/**
	 * Add an edge without checking parameters.
	 */
	private void addEdge(int from, int to, int cost) {
		if (edges[from] == null)
			edges[from] = new HashMap<>(INITIAL_MAP_SIZE);
		if (edges[from].put(to, cost) == null)
			numEdges++;
	}

	/**
	 * {@inheritDoc Graph} Time complexity: O(1).
	 */
	@Override
	public int numVertices()
	{
		return edges.length;
	}

	/**
	 * {@inheritDoc Graph} Time complexity: O(1).
	 */
	@Override
	public int numEdges()
	{
		return numEdges;
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public int degree(int v) throws IllegalArgumentException
	{
		if (v < 0 || v >= edges.length)
			throw new IllegalArgumentException("v out of range");

		if (edges[v] != null)
			return edges[v].size();
		else
			return 0;
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public VertexIterator neighbors(int v)
	{
		if (edges[v] == null)
			return new VertexIterator()
			{
				@Override
				public boolean hasNext()
				{
					return false;
				}

				@Override
				public int next() throws NoSuchElementException
				{
					throw new NoSuchElementException("Nothing more in iteration.");
				}
			};

		Iterator<Integer> neighbors = edges[v].keySet().iterator();

		return new VertexIterator()
		{
			@Override
			public boolean hasNext()
			{
				return neighbors.hasNext();
			}

			@Override
			public int next() throws NoSuchElementException
			{
				return neighbors.next();
			}
		};
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public boolean hasEdge(int v, int w)
	{
		if (v < 0 || v >= edges.length)
			throw new IllegalArgumentException("v out of range");
		if (w < 0 || w >= edges.length)
			throw new IllegalArgumentException("w out of range");

		return edges[v] != null && edges[v].containsKey(w);
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public int cost(int v, int w) throws IllegalArgumentException
	{
		// If no edges exist, it has no cost
		if (edges[v] == null)
			return NO_COST;

		// If given edge exists, return its cost
		if (edges[v].containsKey(w))
			return edges[v].get(w);
		else
			return NO_COST;
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public void add(int from, int to) throws IllegalArgumentException
	{
		if (from < 0 || from > edges.length)
			throw new IllegalArgumentException("from argument out of range");

		if (to < 0 || to > edges.length)
			throw new IllegalArgumentException("to argument out of range");

		add(from, to, NO_COST);
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public void add(int from, int to, int c) throws IllegalArgumentException
	{
		if (c < -1)
			throw new IllegalArgumentException("Cost must be non-negative.");

		addEdge(from, to, c);
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public void addBi(int v, int w)
	{
		add(v, w);
		add(w, v);
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public void addBi(int v, int w, int c)
	{
		add(v, w, c);
		add(w, v, c);
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public void remove(int from, int to)
	{
		if (hasEdge(from, to))
		{
			edges[from].remove(to);
			numEdges--;
		}
	}

	/**
	 * {@inheritDoc Graph}
	 */
	@Override
	public void removeBi(int v, int w)
	{
		remove(v, w);
		remove(w, v);
	}

	/**
	 * Returns a string representation of this graph.
	 * 
	 * @return a String representation of this graph
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for (int v = 0; v < edges.length; v++)
		{
			if (edges[v] == null)
				continue;

			for (int i : edges[v].keySet())
			{
				int cost = edges[v].get(i);

				if (cost == NO_COST)
					sb.append(String.format("(%d,%d), ", v, i));
				else
					sb.append(String.format("(%d,%d,%d), ", v, i, cost));
			}
		}

		// Remove trailing comma
		if (numEdges > 0)
			sb.setLength(sb.length() - 2);

		return sb.insert(0, "{").append("}").toString();
	}
}