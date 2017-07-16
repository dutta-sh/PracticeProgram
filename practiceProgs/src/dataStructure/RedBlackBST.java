package dataStructure;

import java.util.Scanner;

public class RedBlackBST {
	private Node root; 				// root of the BST

	enum Color {
		RED, BLACK;
	}
	
	private class Node {
		private Integer val;
		private Node lChild;
		private Node rChild;
		private Color color;

		public Node(Integer val) {
			this.val = val;
			this.color = Color.RED;
		}
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == Color.RED;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(Integer val) {
		Node x = root;
		while (x != null) {
			int cmp = val.compareTo(x.val);
			if (cmp < 0)
				x = x.lChild;
			else if (cmp > 0)
				x = x.rChild;
			else
				return true;
		}
		return false;
	}

	public void add(Integer val) {
		root = add(root, val);
		root.color = Color.BLACK;
	}

	// insert the value in the subtree rooted at h
	private Node add(Node h, Integer val) {
		if (h == null)
			return new Node(val);

		if (val < h.val)
			h.lChild = add(h.lChild, val);
		else if (val > h.val)
			h.rChild = add(h.rChild, val);

		// fix-up any right-leaning links
		if (isRed(h.rChild) && !isRed(h.lChild))
			h = rotateLeft(h);
		if (isRed(h.lChild) && isRed(h.lChild.lChild))
			h = rotateRight(h);
		if (isRed(h.lChild) && isRed(h.rChild))
			flipColors(h);

		return h;
	}

	// delete the minimum value rooted at h
	private Node deleteMin(Node h) {
		if (h.lChild == null)
			return null;

		if (!isRed(h.lChild) && !isRed(h.lChild.lChild))
			h = moveRedLeft(h);

		h.lChild = deleteMin(h.lChild);
		return balance(h);
	}

	public void delete(Integer val) {
		if (!contains(val))
			return;

		// if both children of root are black, set root to red
		if (!isRed(root.lChild) && !isRed(root.rChild))
			root.color = Color.RED;

		root = delete(root, val);
		if (!isEmpty())
			root.color = Color.BLACK;
	}

	// delete the value rooted at h
	private Node delete(Node h, Integer val) {
		if (val.compareTo(h.val) < 0) {
			if (!isRed(h.lChild) && !isRed(h.lChild.lChild))
				h = moveRedLeft(h);
			h.lChild = delete(h.lChild, val);
		} else {
			if (isRed(h.lChild))
				h = rotateRight(h);
			if (val.compareTo(h.val) == 0 && (h.rChild == null))
				return null;
			if (!isRed(h.rChild) && !isRed(h.rChild.lChild))
				h = moveRedRight(h);
			if (val.compareTo(h.val) == 0) {
				Node x = min(h.rChild);
				h.val = x.val;
				h.rChild = deleteMin(h.rChild);
			} else
				h.rChild = delete(h.rChild, val);
		}
		return balance(h);
	}

	// make a left-leaning link lean to the right
	private Node rotateRight(Node h) {
		Node x = h.lChild;
		h.lChild = x.rChild;
		x.rChild = h;
		x.color = x.rChild.color;
		x.rChild.color = Color.RED;
		return x;
	}

	// make a right-leaning link lean to the left
	private Node rotateLeft(Node h) {
		Node x = h.rChild;
		h.rChild = x.lChild;
		x.lChild = h;
		x.color = x.lChild.color;
		x.lChild.color = Color.RED;
		return x;
	}

	// flip the colors of a node and its two children
	private void flipColors(Node h) {
		// h must have opposite color of its two children
		h.color = (h.color == Color.BLACK ? Color.RED : Color.BLACK);
		h.lChild.color = (h.lChild.color == Color.BLACK ? Color.RED : Color.BLACK);
		h.rChild.color = (h.rChild.color == Color.BLACK ? Color.RED : Color.BLACK);
	}

	// Assuming that h is red and both h.left and h.left.left
	// are black, make h.left or one of its children red.
	private Node moveRedLeft(Node h) {
		flipColors(h);
		if (isRed(h.rChild.lChild)) {
			h.rChild = rotateRight(h.rChild);
			h = rotateLeft(h);
			flipColors(h);
		}
		return h;
	}

	// Assuming that h is red and both h.right and h.right.left
	// are black, make h.right or one of its children red.
	private Node moveRedRight(Node h) {
		flipColors(h);
		if (isRed(h.lChild.lChild)) {
			h = rotateRight(h);
			flipColors(h);
		}
		return h;
	}

	// restore red-black tree invariant
	private Node balance(Node h) {
		if (isRed(h.rChild))
			h = rotateLeft(h);
		if (isRed(h.lChild) && isRed(h.lChild.lChild))
			h = rotateRight(h);
		if (isRed(h.lChild) && isRed(h.rChild))
			flipColors(h);

		return h;
	}

	// the smallest value in subtree rooted at x
	private Node min(Node x) {
		if (x.lChild == null)
			return x;
		else
			return min(x.lChild);
	}

	@Override
	public String toString() {
		StringBuilder strBld = new StringBuilder();
		printChildren(root, strBld);
		return strBld.toString();
	}

	private void printChildren(Node temp, StringBuilder strBld) {
		if (temp == null)
			return;
		printChildren(temp.lChild, strBld);
		strBld.append(temp.val + ", ");
		printChildren(temp.rChild, strBld);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RedBlackBST st = new RedBlackBST();
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter value:");
			Integer val = Integer.parseInt(sc.next());
			st.add(val);
		}
		sc.close();
		System.out.println(st);
	}
}