/**
 * Created by Shouvik on 7/5/2017.
 */
public class LinkedListExample {
    private Node start;
    private Node end;

    public void add(String val) {
        if(start == null) {
            start = new Node(val);
            end = start;
        } else {
            Node newNode = new Node(val);
            end.setNext(newNode);
            end = newNode;

//            Node node = start;
//            while(node.getNext() != null)
//                node = node.getNext();
//
//            Node last = new Node(val);
//            node.setNext(last);
        }
    }

    public String toString() {
        if(start == null) return null;
        Node node = start;
        StringBuilder strBld = new StringBuilder();
        while(node != null) {
            strBld.append(node.getVal() + ",");
            node = node.getNext();
        }
        return strBld.toString();
    }

    public static void main(String[] args) {
        LinkedListExample linkedList = new LinkedListExample();
        linkedList.add("abcd");
        linkedList.add("efgh");
        linkedList.add("ijkl");
        linkedList.add("wxyz");
        System.out.println(linkedList);
    }
}

class Node {
    private String val;
    private Node next;

    public Node(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}