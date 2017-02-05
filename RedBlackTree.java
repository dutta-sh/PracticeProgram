import java.util.Scanner;

public class RedBlackTree {
	private Node root; 				// root of the RBT

	enum Color {
		RED, BLACK;
	}
	
	private class Node {
		private String key;
		private String val;
		private Node lChild;
		private Node rChild;
		private Color color;

		public Node(String keyV, String valV) {
			this.val = valV;
			this.key = keyV;
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

	public void add(String key, String val) {
		root = add(root, key, val);
		root.color = Color.BLACK;
	}

	// insert the value in the subtree rooted at node
	private Node add(Node node, String key, String val) {
		if (node == null)
			return new Node(key, val);

		int i = 0; 
		/*for (i = 0; i < key.length(); ) {
			if (key.indexOf(node.key) != -1)
				i++;			
			else 
				break;			
		}*/
			
		if (key.charAt(i) < node.key.charAt(i))
			node.lChild = add(node.lChild, key, val);
		else if (key.charAt(i) > node.key.charAt(i))
			node.rChild = add(node.rChild, key, val);
		
		// fix-up any right-leaning links
		if (isRed(node.rChild) && !isRed(node.lChild))
			node = rotateLeft(node);
		if (isRed(node.lChild) && isRed(node.lChild.lChild))
			node = rotateRight(node);
		if (isRed(node.lChild) && isRed(node.rChild))
			flipColors(node);

		return node;
	}

	// search for key
	public String search(String key) {
		Node node = root;
		while (node != null) {
			int cmp = key.compareTo(node.key);
			if (cmp < 0)
				node = node.lChild;
			else if (cmp > 0)
				node = node.rChild;
			else
				return node.val;
		}
		return "";
	}
	
	// checking whether key node exists
	public boolean contains(String key) {
		Node node = root;
		while (node != null) {
			int cmp = key.compareTo(node.key);
			if (cmp < 0)
				node = node.lChild;
			else if (cmp > 0)
				node = node.rChild;
			else
				return true;
		}
		return false;
	}
	
	// delete the minimum value rooted at node
	private Node deleteMin(Node node) {
		if (node.lChild == null)
			return null;

		if (!isRed(node.lChild) && !isRed(node.lChild.lChild))
			node = moveRedLeft(node);

		node.lChild = deleteMin(node.lChild);
		return balance(node);
	}

	public void delete(String key) {
		if (!contains(key))
			return;

		// if both children of root are black, set root to red
		if (!isRed(root.lChild) && !isRed(root.rChild))
			root.color = Color.RED;

		root = delete(root, key);
		if (!isEmpty())
			root.color = Color.BLACK;
	}

	// delete the value rooted at node
	private Node delete(Node node, String key) {
		if (key.compareTo(node.key) < 0) {
			if (!isRed(node.lChild) && !isRed(node.lChild.lChild))
				node = moveRedLeft(node);
			node.lChild = delete(node.lChild, key);
		} else {
			if (isRed(node.lChild))
				node = rotateRight(node);
			if (key.compareTo(node.key) == 0 && (node.rChild == null))
				return null;
			if (!isRed(node.rChild) && !isRed(node.rChild.lChild))
				node = moveRedRight(node);
			if (key.compareTo(node.key) == 0) {
				Node x = min(node.rChild);
				node.key = x.key;
				node.rChild = deleteMin(node.rChild);
			} else
				node.rChild = delete(node.rChild, key);
		}
		return balance(node);
	}

	// make a left-leaning link lean to the right
	private Node rotateRight(Node node) {
		Node x = node.lChild;
		node.lChild = x.rChild;
		x.rChild = node;
		x.color = x.rChild.color;
		x.rChild.color = Color.RED;
		return x;
	}

	// make a right-leaning link lean to the left
	private Node rotateLeft(Node node) {
		Node x = node.rChild;
		node.rChild = node.lChild;
		x.lChild = node;
		x.color = x.lChild.color;
		x.lChild.color = Color.RED;
		return x;
	}

	// flip the colors of a node and its two children
	private void flipColors(Node node) {
		// h must have opposite color of its two children
		node.color = (node.color == Color.BLACK ? Color.RED : Color.BLACK);
		node.lChild.color = (node.lChild.color == Color.BLACK ? Color.RED : Color.BLACK);
		node.rChild.color = (node.rChild.color == Color.BLACK ? Color.RED : Color.BLACK);
	}

	// Assuming that node is red and both node.left and node.left.left
	// are black, make node.left or one of its children red.
	private Node moveRedLeft(Node node) {
		flipColors(node);
		if (isRed(node.rChild.lChild)) {
			node.rChild = rotateRight(node.rChild);
			node = rotateLeft(node);
			flipColors(node);
		}
		return node;
	}

	// Assuming that node is red and both node.right and node.right.left
	// are black, make node.right or one of its children red.
	private Node moveRedRight(Node node) {
		flipColors(node);
		if (isRed(node.lChild.lChild)) {
			node = rotateRight(node);
			flipColors(node);
		}
		return node;
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
		RedBlackTree st = new RedBlackTree();
		
		// adding values in tree
		st.add("hello", "world");
		st.add("goodbye", "everyone");
		st.add("name", "student");
		st.add("occupation", "student");
		st.add("year", "2016");
		st.add("gpa", "4.0");
		st.add("lab", "yes");
		st.add("assignment", "no");
		st.add("department", "cs");

		// searching values
		String val = st.search("department");
		if (val != "")
			System.out.println(val);
		
		System.out.println(st);
		
		// dele
		st.delete("hello");
		
		sc.close();
		System.out.println(st);
	}
}