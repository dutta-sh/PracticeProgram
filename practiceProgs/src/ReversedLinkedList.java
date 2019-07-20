public class ReversedLinkedList {

    private static ListNode h;

    public static void main(String[] args) {
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(20);
        ListNode n3 = new ListNode(30);
        ListNode n4 = new ListNode(40);
        ListNode n5 = new ListNode(50);

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

    public static void reverseRec(ListNode node, ListNode nextNode) {
        if (nextNode == null) {
            h = node;
            return;
            //return node;
        }

//        ListNode here = reverseRec(nextNode, nextNode.next);
//        here.next = node;
//        node.next = null;
//
//        return node;

        reverseRec(nextNode, nextNode.next);
        nextNode.next = node;
        node.next = null;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;

        p1.next = null;
        while(p1 != null && p2 != null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        return p1;
    }
}