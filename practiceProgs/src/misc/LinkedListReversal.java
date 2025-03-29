package misc;

public class LinkedListReversal {
    private static Node head;
    public static void main(String[] args) {
        Node n = new Node(0);
        head = n;
        for(int i = 1; i < 5; i++) {
            Node next = new Node(i);
            n.next = next;
            n = next;
        }
        print(head);

        reverse(head, head.next);
        print(head);
    }

    public static void reverse(Node currNode, Node nextNode) {
        if(nextNode == null) {
            head = currNode;
            return;
        }

        reverse(nextNode, nextNode.next);
        nextNode.next = currNode;
        currNode.next = null;
    }

    public static void print(Node n) {
        while(n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
