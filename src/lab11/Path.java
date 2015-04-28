package lab11;

import lab10.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses a text file describing a Graph object, and finds one short route
 * (if applicable), between two points supplied as program arguments.
 */
public class Path
{
	// Data constants
    static final String FILE = "path.txt";
    static final String COMMENT = "//";
	static final Pattern pattern = Pattern.compile("(\\d+)\\s(\\d+)\\s(\\d+)");

	// Instance variables
	int from, to, size;
    List<String> lines;
	Graph g;

	/**
	 * Program entry point.
	 */
	public static void main(String[] args)
    {
		// Try to run program components
		// If a critical error is encountered, halt execution and print it
        try
        {
            new Path()
                    .parseInput(args)
                    .loadFile()
					.cleanInput()
					.initGraph()
					.checkInput()
                    .parseGraph()
                    .performBfs();
		}
        catch (IllegalArgumentException e)
        {
			System.err.println("IllegalArgumentException: " + e.getMessage());
            System.err.println("Usage: java Path FROM TO (FROM, TO non-negative)");
        }
        catch (IOException e)
        {
            System.err.printf("%s: %s%n", e.getClass().getSimpleName(), e.getMessage());
        }
    }

	/**
	 * Parse input arguments from the command-line.
	 *
	 * @param args		Args from main method
	 * @throws			IllegalArgumentException
	 */
    private Path parseInput(String[] args) throws IllegalArgumentException
    {
		// Prohibit more or less than two program arguments
		if (args.length != 2)
			throw new IllegalArgumentException("Illegal amount of arguments supplied");

		// Prohibit non-numeric program arguments
		try
		{
			from = Integer.parseInt(args[0]);
			to = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e)
		{
			throw new IllegalArgumentException("Non-numeric arguments supplied");
		}

        return this;
    }

	/**
	 * Load file contents.
	 *
	 * @throws			IOException
	 */
    private Path loadFile() throws IOException
    {
		java.nio.file.Path path = Paths.get("out", "production", "DD1339", FILE);
		boolean exists = Files.exists(path);

        if (!exists)
            throw new FileNotFoundException("Could not find graph file " + FILE);

        lines = Files.readAllLines(path);

        return this;
    }

	/**
	 * Clean the file lines buffer from comments and empty lines.
	 */
	private Path cleanInput()
	{
		List<String> parsed = new ArrayList<>();

		for (String s : lines)
		{
			// Search for a comment
			int c = s.indexOf(COMMENT);

			// If comment is found, grab only the data before it
			if (c >= 0)
				s = s.substring(0, c);

			// Trim whitespace
			s = s.trim();

			// If there is content left, put it in the parsed list
			if (s.length() > 0)
				parsed.add(s);
		}

		lines = parsed;
		return this;
	}

	/**
	 * Create a Graph object based on the size variable found in the file.
	 *
	 * @throws			IllegalArgumentException
	 */
    private Path initGraph() throws IllegalArgumentException
	{
		try
		{
			String s = lines.get(0);
			size = Integer.parseInt(s);
			g = new HashGraph(size);
			lines.remove(0);
		}
		catch (NumberFormatException e)
		{
			throw new NumberFormatException("Graph size variable could not be found.");
		}

		return this;
	}

	/**
	 * Perform checks on whether FROM and TO program arguments are in allowed range.
	 *
	 * @throws			IllegalArgumentException
	 */
	private Path checkInput() throws IllegalArgumentException
	{
		if (from < 0 || from >= size)
			throw new IllegalArgumentException("FROM argument not in graph range: 0-" + (size - 1));

		if (to < 0 || to >= size)
			throw new IllegalArgumentException("TO argument not in graph range: 0-" + (size - 1));

		return this;
	}

	/**
	 * Parse file data into Graph edges.
	 *
	 * @throws			IOException
	 */
    private Path parseGraph() throws IOException
	{
        for (String s : lines)
        {
			Matcher m = pattern.matcher(s);

			// Run matches method to match regex, throw exception if it fails
			if (!m.matches())
				throw new IOException("Malformed data encountered: '" + s + "' could not be parsed.");

			// Parse numbers (does not need try catch since regex matches integers)
			int gFrom = Integer.parseInt(m.group(1));
			int gTo = Integer.parseInt(m.group(2));
			int gCost = Integer.parseInt(m.group(3));

			if (gFrom < 0 || gFrom > size)
				throw new IOException("Malformed data encountered: '" + s + "': " + gFrom + " out of range");

			if (gTo < 0 || gTo > size)
				throw new IOException("Malformed data encountered: '" + s + "': " + gTo + " out of range");

			g.add(gFrom, gTo, gCost);
		}

        return this;
    }

	/**
	 * Perform the BFS to build path description.
	 * Print it and exit the program once one short path is found,
	 * otherwise print an empty line.
	 */
	private void performBfs()
	{
		StringBuilder[] paths = new StringBuilder[g.numVertices()];
		paths[from] = new StringBuilder();

		bfs(g, from, (graph, current, previous) -> {

            paths[current] = new StringBuilder(paths[previous]).append(current);

			// If a path is found, report it and exit the program
            if (current == to)
			{
				System.out.println(paths[current]);
				System.exit(0);
			}
            else
                paths[current].append(" - ");
		});

		// If no path was found, print an empty line
		System.out.println();
	}

	/**
	 * Search through a Graph object using Breadth-First Search.
	 *
	 * @param g			Graph object to search
	 * @param v			Vertex to begin search from
	 * @param action	Visit action to perform
	 */
	private void bfs(Graph g, int v, VertexActionThree action)
	{
		// Use a Queue for BFS
		Queue<GraphPath> q = new LinkedList<>();
		boolean[] visited = new boolean[g.numVertices()];

		visited[v] = true;
		q.add(new GraphPath(v, v));

		while(!q.isEmpty())
		{
			// De-queue a GraphPath and perform visit action
			GraphPath n = q.remove();
			action.act(g, n.current, n.previous);

			VertexIterator it = g.neighbors(n.current);

			while (it.hasNext())
			{
				int i = it.next();

				// If the Vertex is not visited, visit and add it to queue
				if (!visited[i])
				{
					visited[i] = true;
					q.add(new GraphPath(i, n.current));
				}
			}
		}
	}
}

/**
 * Package local class to keep track of a vertex, and a previously visited vertex
 */
class GraphPath
{
	public int current, previous;

	public GraphPath(int current, int previous)
	{
		this.current = current;
		this.previous = previous;
	}
}