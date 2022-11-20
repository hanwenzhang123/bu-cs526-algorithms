package nodeTrees;

import java.util.ArrayList;
import java.util.List;

// binary search tree storing integers
public class IntBST extends NodeBinaryTree<Integer> {

	//private int size = 0;

	public IntBST() {	}

	public int size() {
		return size;
	}

	public void setSize(int s) { size = s; }
	
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Places element e at the root of an empty tree and returns its new Node.
	 *
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */

	public Node<Integer> addRoot(Integer e) throws IllegalStateException {
		if (size != 0)
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Print a binary tree horizontally Modified version of
	 * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 * Modified by Keith Gutfreund
	 * 
	 * @param n Node in tree to start printing from
	 */
	
	  public void print(Node<Integer> n){ print ("", n); }
	  
	  public void print(String prefix, Node<Integer> n){
		  if (n != null){
			  print(prefix + "       ", right(n));
			  System.out.println (prefix + ("|-- ") + n.getElement());
			  print(prefix + "       ", left(n));
		  }
	  }
	  
	  
	  public void inorderPrint(Node<Integer> n) {
		if (n == null)
			return;
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}

	
	public Iterable<Node<Integer>> children(Node<Integer> n) {
		List<Node<Integer>> snapshot = new ArrayList<>(2); // max capacity of 2 
		if (left(n) != null) 
			snapshot.add(left(n)); 
		if (right(n) != null)
			snapshot.add(right(n)); return snapshot; 
	}
	
	public int height(Node<Integer> n) throws IllegalArgumentException { 
		if (isExternal(n)) { return 0; } 
		int h = 0; // base case if p is external
		for (Node<Integer> c : children(n)) h = Math.max(h, height(c)); return h + 1; 
	}

	// makeBinaryTree receives an array of integers a with a size of 2^k-1, and sorted in non-decreasing order
	// which it outputs an IntBST, which is a complete binary tree with all integers in the array a

	public static IntBST makeBinaryTree(int[] a){
		// complete this method
		return binaryTreeBuilder(a, 0, a.length - 1);
	}

	// binaryTreeBuilder is a method that recursively splits the array into three parts
	// leftSubarray, "middle node", rightSubarray and then builds a binary tree from each subarray recursively
	// The leftSubtree, "middle node," and the rightSubtree are then combined to make a binary tree
	// @param a - an array of integers that was originally received from makeBinaryTree method
	// @param startIndex - current subarray start index
	// @param endIndex - current subarray end index
	// @return an IntBST, a complete binary search tree implemented as array a
	public static IntBST binaryTreeBuilder(int[] a, int startIndex, int endIndex){

		// Base case
		if (startIndex > endIndex) {
			return null;
		}

		//create a new BST tree which will be returned
		IntBST tree = new IntBST();

		// find the middle element of the array
		int middle = (startIndex + endIndex)/2;

		// add root node using the middle element to tree - middle comes the root
		Node root = tree.addRoot(a[middle]);

		// IntBST build the left side of the tree using recursion - call binaryTreeBuilder
		IntBST leftTree = binaryTreeBuilder(a, startIndex, middle -1);

		// IntBST build the right side of the tree using recursion - call binaryTreeBuilder
		IntBST rightTree = binaryTreeBuilder(a, middle + 1, endIndex);

		// increment the tree size
		tree.setSize(a.length);

		// attach left and right trees to join middle node as root
		if (leftTree != null) {
			root.setLeft(leftTree.root);
		}
		if (rightTree != null) {
			root.setRight(rightTree.root);
		}

		return tree;
	};

}
