package dataStructure;

public class BST<T extends Comparable> {

    class Node<T extends Comparable> {
        private T data = null;
        private Node<T> lChild = null;
        private Node<T> rChild = null;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;

    public void add(T data) {
        Node<T> node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }

        Node parent = null;	//parent of element to be inserted
        Node temp = head;	//used to move down the tree until the child is null
        while(temp != null){
            parent = temp;
            if(data.compareTo(temp.data) < 0)
                temp = temp.lChild;
            else if(data.compareTo(temp.data) > 0)
                temp = temp.rChild;
        }
        if (data.compareTo(parent.data) < 0)
            parent.lChild = node;
        else
            parent.rChild = node;
    }

    public boolean contains(T data){
        Node temp = head;
        while (temp != null){
            if (data.compareTo(temp.data) < 0)
                temp = temp.lChild;
            else if (data.compareTo(temp.data) > 0)
                temp = temp.rChild;
            else
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder strBld = new StringBuilder();
        printChildren(head, strBld);
        return strBld.toString();
    }

    private void printChildren(Node temp, StringBuilder strBld){// to print the tree in sorted order
        if(temp == null)
            return;
        printChildren(temp.lChild, strBld);
        strBld.append(temp.data + ", ");
        printChildren(temp.rChild, strBld);
    }


    public static void main(String[] args) {
        BST<String> bst = new BST();
        bst.add("ABCD");
        bst.add("JFK");
        bst.add("JFKL");
        bst.add("ABC");
        bst.add("XYZ");

        System.out.println(bst.toString());
    }
}
