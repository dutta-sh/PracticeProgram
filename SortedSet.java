import java.io.File;
import java.util.Scanner;

public class SortedSet {
	private Node root;
	
	private class Node{
		private Integer val;
		private Node lChild;
		private Node rChild;
		
		public Node(Integer val){
			this.val = val;
		}
	}
	
	public boolean isEmpty(){
		if(root == null)
			return true;
		else
			return false;
	}
	
	public void add(Integer val){
		Node node = new Node(val);
		if(root == null){
			root = node;
			return;
		}
		
		Node parent = null;	//parent of element to be inserted
		Node temp = root;	//used to move down the tree until the child is null
		while(temp != null){
			parent = temp;
			if(val < temp.val)
				temp = temp.lChild;
			else if(val > temp.val)
				temp = temp.rChild;		
		}
		if (val < parent.val)
			parent.lChild = node;
		else
			parent.rChild = node;
	}
	
	public void remove(Integer val){
		Node temp = root;
		Node parent = null;
		boolean isLChild = false;
		boolean isRChild = false;
		while( temp != null){
			if (val < temp.val){
				parent = temp;
				temp = temp.lChild;
				isLChild = true;
				isRChild = false;
			}else if (val > temp.val){
				parent = temp;
				temp = temp.rChild;
				isLChild = false;
				isRChild = true;
			}else { // found the node
				//both children are null
				if(temp.lChild == null && temp.rChild == null){
					if (isLChild)
						parent.lChild = null;
					if (isRChild)
						parent.rChild = null;
					break;
				}
				//one only child is present
				if((temp.lChild == null && temp.rChild !=null) || (temp.lChild != null && temp.rChild == null)){
					if(isLChild && temp.rChild != null)
						parent.lChild = temp.rChild;
					if (isLChild && temp.lChild != null)
						parent.lChild = temp.lChild;
					
					if (isRChild && temp.rChild != null)
						parent.rChild = temp.rChild;
					if (isRChild && temp.lChild !=null)
						parent.rChild = temp.lChild;
					break;
				}
				//both children are present
				if(temp.lChild != null && temp.rChild != null){
					Node rSubTree = temp.rChild;
					Node tempParent = null;// we are keeping this reference so that we can set child to null at the end
					while(rSubTree.lChild != null){ // get smaller node from the right subtree
						tempParent = rSubTree;
						rSubTree = rSubTree.lChild;
					}
					
					if (tempParent != null){
						tempParent.lChild = rSubTree.rChild;
						rSubTree.rChild = temp.rChild;
					}
					rSubTree.lChild = temp.lChild;
					
					if (isLChild)
						parent.lChild = rSubTree;
					if (isRChild)
						parent.rChild = rSubTree;
					if (parent == null)	// removing the root, so replaces the root with right subtree
						root = rSubTree;
					break;
				}
			}
		}
	}

	public boolean contains(Integer val){
		Node temp = root;
		while (temp != null){
			if (val < temp.val)
				temp = temp.lChild;
			else if (val > temp.val)
				temp = temp.rChild;
			else
				return true; // value is found
		}
		return false;
	}
	
	@Override
	public String toString(){
		StringBuilder strBld = new StringBuilder();
		printChildren(root, strBld);
		return strBld.toString();
	}
	
	private void printChildren(Node temp, StringBuilder strBld){// to print the tree in sorted order
		if(temp==null)
			return;
		printChildren(temp.lChild, strBld);
		strBld.append(temp.val + ", ");
		printChildren(temp.rChild, strBld);	
	}
	
	public static void main(String[] args) throws Exception{
		File inFile = new File("infile.dat");
		Scanner sc = new Scanner(inFile);
		String input = sc.nextLine();
		sc.close();
		
		SortedSet set = new SortedSet();
//		System.out.println(set.isEmpty());
		for(String in : input.split(",")) {
			set.add(Integer.parseInt(in.trim()));
		}
		
//		System.out.println(set.isEmpty());
		System.out.println("Sorted Set A Contains " + set);
		
		System.out.print("User Input = ");
		sc = new Scanner(System.in);
		Integer findElem = Integer.parseInt(sc.nextLine());
		sc.close();
		
		String result = set.contains(findElem) ? "Yes" : "No";
		System.out.println(result);
		
//		System.out.println(set.contains(70));
//		System.out.println(set.contains(150));
//		set.remove(50);
//		System.out.println(set);
	}
}