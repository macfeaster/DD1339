package lab5;

public class Tree<T extends Comparable<T>>
{
	private Node<T> root = null;
	private int size = 0;

	private class Node<N extends Comparable<N>>
	{
		N data;
		Node<N> left;
		Node<N> right;
	}

	public boolean contains(T data)
	{
		// Null check
		if (data == null)
			return false;

		Node<T> node = root;

		// Iterate down the tree
		while (node != null)

			// If the node is found, return true
			if (data.compareTo(node.data) == 0)
				return true;

				// If node is greater than data, go left
			else if (data.compareTo(node.data) < 0)
				node = node.left;

				// Otherwise, go right
			else
				node = node.right;

		// If search found nothing, return false
		return false;
	}

	public boolean add(T data)
	{
		// TODO

		return false;
	}

	public int size()
	{
		// TODO
		return 0;
	}

	public int depth()
	{
		// TODO
		return 0;
	}

	public int leaves()
	{
		return leavesCounter(root);
	}

	private boolean isEmpty()
	{
		return (root == null);
	}

	@Override
	public String toString()
	{
		// TODO
		return null;
	}

	private int leavesCounter(Node<T> node)
	{
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;

		return leavesCounter(node.left) + leavesCounter(node.right);
	}
}
