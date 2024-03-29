package lab10;

/**
 * This interface contains a single act method intended to be called during a
 * traversal of a graph.
 * 
 * @author Stefan Nilsson
 * @version 2012-12-30
 */

public interface VertexActionThree
{
	/**
	 * An action performed when a search of the graph g visits node v.
	 * 
	 * @param g
	 *            a graph
	 * @param v
	 *            a vertex in the graph
	 */
	void act(Graph g, int v, int u);
}
