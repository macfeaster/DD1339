package lab10;

import java.util.Random;

/**
 * An example implementation of depth first search, with usage examples.
 * 
 * @author Mauritz Zachrisson, Stefan Nilsson
 * @version 4/32/2015, 2012-12-30
 */
public class GraphAlgorithms
{
	// Internal sub-max field
	private static int submax = 0;

	/**
	 * Builds an undirected graph and prints the components to stdout.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) throws Exception
	{
		// Generate graphs
		Graph m = buildGraph(1000, MatrixGraph.class);
		Graph h = buildGraph(1000, HashGraph.class);
		long time;

		time = System.currentTimeMillis();
		System.out.printf("MatrixGraph: %s%n", m);
		System.out.printf("Components in total: %d (max has %d vertices)%n", countComponents(m), maxComponent(m));
		System.out.printf("Time delta: %d ms%n", System.currentTimeMillis() - time);

		time = System.currentTimeMillis();
		System.out.printf("HashGraph: %s%n", h);
		System.out.printf("Components in total: %d (max has %d vertices)%n", countComponents(h), maxComponent(h));
		System.out.printf("Time delta: %d ms%n", System.currentTimeMillis() - time);
	}

	public static Graph buildGraph(int size, Class<? extends Graph> alg) throws Exception
	{
		// Construct given Graph class
		Graph g = alg.getDeclaredConstructor(int.class).newInstance(size);
		Random r = new Random();

		// Randomize both whether edge should be placed and edge endpoints
		for (int i = 0; i < size; i++)
			if (r.nextBoolean())
				g.addBi(r.nextInt(size), r.nextInt(size));

		return g;
	}

	public static int countComponents(Graph g)
	{
		// Initialize variables
		int n = g.numVertices();
		int c = 0;
		boolean[] visited = new boolean[n];

		// For all the vertices
		for (int i = 0; i < n; i++)
		{
			if (!visited[i])
			{
				// Perform DFS
				dfs(g, i, visited, (g1, v) -> {});
				c++;
			}
		}

		return c;
	}


	public static int maxComponent(Graph g)
	{
		// Initialize variables
		int n = g.numVertices();
		int max = 0;
		boolean[] visited = new boolean[n];

		// For all the vertices
		for (int i = 0; i < n; i++)
		{
			if (!visited[i])
			{
				// Set submax to zero and count through DFS
				submax = 0;
				dfs(g, i, visited, (g1, v) -> submax++);

				// If larger submax is found, replace max
				if (submax > max)
					max = submax;
			}
		}

		return max;
	}

	/**
	 * Prints the components of g to stdout. Each component is written on a
	 * separate line.
	 */
	private static void printComponents(Graph g)
	{
		VertexAction printVertex = (g1, v) -> System.out.print(v + " ");
		int n = g.numVertices();
		boolean[] visited = new boolean[n];

		for (int v = 0; v < n; v++)
		{
			if (!visited[v])
			{
				dfs(g, v, visited, printVertex);
				System.out.println();
			}
		}
	}

	/**
	 * Traverses the nodes of g that have not yet been visited. The nodes are
	 * visited in depth-first order starting at v. The act() method in the
	 * VertexAction object is called once for each node.
	 * 
	 * @param g
	 *            an undirected graph
	 * @param v
	 *            start vertex
	 * @param visited
	 *            visited[i] is true if node i has been visited
	 */
	private static void dfs(Graph g, int v, boolean[] visited, VertexAction action)
	{
		if (visited[v])
			return;

		visited[v] = true;
		action.act(g, v);

		for (VertexIterator it = g.neighbors(v); it.hasNext();)
			dfs(g, it.next(), visited, action);
	}
}
