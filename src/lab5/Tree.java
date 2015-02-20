package lab5;

/**
 * A Tree data structure implementation.
 *
 * @param <T>		Java Generics data type
 * @author			Mauritz Zachrisson
 */
public class Tree<T extends Comparable<T>>
{
	private Node<T> root = null;
	private int size = 0;

	// Private Node helper class
	private class Node<N extends Comparable<N>>
	{
		N data;
		Node<N> left = null;
		Node<N> right = null;

		public Node(N data)
		{
			this.data = data;
		}
	}

	/**
	 * Check whether the tree contains a given data piece.
	 *
	 * @param data		Data to search for
	 * @return			true if found, false otherwise
	 */
	public boolean contains(T data)
	{
		// Null check
		if (data == null)
			return false;

		Node<T> node = root;

		// Iterate down the tree
		while (node != null)
		{
			// If the node is found, return true
			if (data.compareTo(node.data) == 0)
				return true;

				// If node is greater than data, go left
			else if (data.compareTo(node.data) < 0)
				node = node.left;

				// Otherwise, go right
			else
				node = node.right;
		}

		// If search found nothing, return false
		return false;
	}

	/**
	 * Add a node to the tree.
	 *
	 * @param data		Data to insert
	 * @return			True on insert, false on duplicate
	 */
	public boolean add(T data)
	{
		// Null addition is prohibited
		if (data == null)
			return false;

		// If root element is null, create it
		if (root == null)
		{
			root = new Node<>(data);
			size++;
			return true;
		}

		// Start search at root node
		Node<T> node = root;

		// Iterate down the tree
		while (true)
		{
			// If node is found, return false (prohibit duplicate)
			if (data.compareTo(node.data) == 0)
				return false;

			// If node is greater than data, go left
			else if (data.compareTo(node.data) < 0)
			{
				// If left child is null, a leaf is reached and data should be added
				if (node.left == null)
				{
					node.left = new Node<>(data);
					size++;
					return true;
				}

				// Otherwise, continue searching
				else node = node.left;
			}

			// Otherwise, go right
			else
			{
				// If right child is null, a leaf is reached and data should be added
				if (node.right == null)
				{
					node.right = new Node<>(data);
					size++;
					return true;
				}

				// Otherwise, continue searching
				else node = node.right;
			}
		}
	}

	/**
	 * Get the number of elements currently in the tree.
	 *
	 * @return 		Tree size as an integer
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Calculate the depth of the tree, i.e. the number of branches.
	 *
	 * @return		Tree depth as an integer
	 */
	public int depth()
	{
		return depthCounter(root);
	}

	// Private depth helper method
	private int depthCounter(Node<T> node)
	{
		// Nothing here
		if (node == null)
			return 0;

		// Calculate depth of sub-branches
		int left = depthCounter(node.left);
		int right = depthCounter(node.right);

		// Return result
		return Math.max(left, right) + 1;
	}

	/**
	 * Calculate the tree leaf count, i.e. the number of nodes with no children.
	 *
	 * @return		Tree leaf count as an integer
	 */
	public int leaves()
	{
		// Generate number of leaves and return
		return leavesCounter(root);
	}

	// Private leaf count helper method
	private int leavesCounter(Node<T> node)
	{
		// Nothing here
		if (node == null)
			return 0;

		// If leaf, increase leaf counter
		if (node.left == null && node.right == null)
			return 1;

		// Continue searching the tree
		return leavesCounter(node.left) + leavesCounter(node.right);
	}

	/**
	 * Generate a sorted String representation of the tree.
	 */
	@Override
	public String toString()
	{
		// Generate empty response for empty trees
		if (size == 0)
			return "[]";

		// Set up StringBuilder
		StringBuilder sb = new StringBuilder();

		// Generate the response String
		buildString(root, sb);
		sb.setLength(sb.length() - 2);

		// Return the formatted response
		return String.format("[%s]", sb);
	}

	// Private toString helper method
	private void buildString(Node<T> node, StringBuilder sb)
	{
		// If left child exists, traverse it
		if (node.left != null)
			buildString(node.left, sb);

		// Perform visit action, i.e. add the data
		sb.append(node.data).append(", ");

		// If right child exists, traverse it
		if (node.right != null)
			buildString(node.right, sb);
	}
}