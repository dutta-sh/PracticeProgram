package dataStructure;

import java.util.ArrayList;
import java.util.Stack;

//http://www.java2blog.com/2015/12/depth-first-search-in-java.html
public class DFS {

	static ArrayList<Node> nodes = new ArrayList<Node>();

	static class Node {
		char data;
		boolean visited;

		Node(char data) {
			this.data = data;
		}

		public String toString() {
			return ((Character) data).toString();
		}
	}

	
	public void dfsUsingStack(int adjMatrix[][], Node node) {
		Stack<Node> stack = new Stack<Node>();
		System.out.println(node.data + "\t");
		node.visited = true;
		stack.push(node);
		while(!stack.isEmpty()) {
			System.out.println("looking for neighbors of: " + node);
			node = findNeighbor(adjMatrix, node);
			if(node != null) {
				System.out.println(node.data + "\t");
				node.visited = true;
				stack.push(node);
			} else {
				//stack.pop();
				node = stack.pop();
			}
		}
	}
	
//	public void dfsUsingStack(int adjMatrix[][], Node node) {
//		Stack<Node> stack = new Stack<Node>();
//		stack.add(node);
//		do {
//			System.out.println(node.data + "\t");
//			node.visited = true;
//			node = findNeighbor(adjMatrix, node);
//			if (node != null) {
//				stack.add(node);
//				System.out.println("neighbor:" + node);
//				System.out.println("stack:" + stack);
//				node = stack.pop();
//			}
//		} while (!stack.isEmpty());
//	}

	public Node findNeighbor(int adjMatrix[][], Node x) {
		int nodeIndex = -1;
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).equals(x)) {
				nodeIndex = i;
				break;
			}
		}
		for (int j = 0; j < adjMatrix[nodeIndex].length; j++) {
			if (adjMatrix[nodeIndex][j] == 1) {
				if(!nodes.get(j).visited)
					return nodes.get(j);
			}
		}
		return null;
	}

	public static void main(String arg[]) {
		Node nodeA = new Node('a');
		nodes.add(nodeA);
		nodes.add(new Node('b'));
		nodes.add(new Node('c'));
		nodes.add(new Node('d'));
		nodes.add(new Node('e'));
		nodes.add(new Node('f'));
		nodes.add(new Node('g'));
		nodes.add(new Node('h'));
		nodes.add(new Node('s'));
		int adjMatrix[][] = { 
				{ 0, 1, 0, 0, 0, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 0, 0, 1 }, 
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 1, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 1, 0, 1, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 0 } 
				};

		DFS dfsExample = new DFS();
		System.out.println("The dataStructure.DFS traversal of the graph using stack ");
		dfsExample.dfsUsingStack(adjMatrix, nodeA);
		System.out.println();
	}
}