package misc;

public class LinkedListPalin {
    static ListNode t;

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        //head.next.next.next = new misc.ListNode(40);
        head.next.next.next = new ListNode(30);
        head.next.next.next.next = new ListNode(20);
        head.next.next.next.next.next = new ListNode(10);

        t = head;

        System.out.println(isPalin(head));
    }

    private static boolean isPalin(ListNode n) {
        boolean isPalinSoFar = true;
        if(n.next != null) {
            isPalinSoFar = isPalin(n.next);
        }

        if(!isPalinSoFar)
            return false;

        if(n.val != t.val)
            return false;

        t = t.next;
        return true;
    }
}
