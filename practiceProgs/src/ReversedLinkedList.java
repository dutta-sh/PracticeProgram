public class ReversedLinkedList {

    private static MyNode h;

    public static void main(String[] args) {
        MyNode n1 = new MyNode();  n1.val = 10;
        MyNode n2 = new MyNode();  n2.val = 20;
        MyNode n3 = new MyNode();  n3.val = 30;
        MyNode n4 = new MyNode();  n4.val = 40;
        MyNode n5 = new MyNode();  n5.val = 50;

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        h = n1;
        while (h != null) {
            System.out.print(h.val + " -> ");
            h = h.next;
        }
        System.out.println("null");

        reverseRec(n1, n1.next);
        //h = reverseList(n1);

        while (h != null) {
            System.out.print(h.val + " -> ");
            h = h.next;
        }
        System.out.println("null");
    }

    public static MyNode reverseRec(MyNode node, MyNode nextNode) {
        if (nextNode == null) {
            h = node;
            return node;
        }

        MyNode here = reverseRec(nextNode, nextNode.next);
        here.next = node;
        node.next = null;

        return node;
    }

    public static MyNode reverseList(MyNode head) {
        if(head == null || head.next == null)
            return head;

        MyNode p1 = head;
        MyNode p2 = p1.next;

        p1.next = null;
        while(p1 != null && p2 != null){
            MyNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        return p1;
    }
}


class MyNode {
    int val;
    MyNode next;
}