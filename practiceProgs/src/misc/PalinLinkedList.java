package misc;

public class PalinLinkedList {

    public static boolean isPalin(ListNode n) {
        if(n == null || n.next == null)
            return true;

        ListNode slow = n;
        ListNode fast = n;
        ListNode slowPrev = null;

        while(fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //for odd length, slow is in the middle, for even, slow is 2nd of 2 mid nodes
        //also, for odd length, fast is not null, for even fast.next is not null
        ListNode mid = null;
        if(fast != null) {
            mid = slow;
            slow = slow.next;
        }

        slowPrev.next = null;

        ListNode secHalfReversed = reverse(slow);
        boolean isPalin = compare(n, secHalfReversed);

        slow = reverse(secHalfReversed);
        if(mid == null)
            slowPrev.next = slow;
        else {
            slowPrev.next = mid;
            mid.next = slow;
        }

        return isPalin;
    }


    public static ListNode reverse(ListNode h) {
        ListNode n = h;
        ListNode next;
        ListNode prev = null;

        while(n != null) {
            next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }
        h = prev;
        return h;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(20);
        ListNode n3 = new ListNode(30);
        ListNode n4 = new ListNode(20);
        ListNode n5 = new ListNode(10);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        ListNode h = n1;

        print(h);
        System.out.println(isPalin(h));
        print(h);

        ListNode n0 = new ListNode(30);
        n3.next = n0; n0.next = n4; n4.next = n5;

        print(h);
        System.out.println(isPalin(h));
        print(h);
    }

    private static void print(ListNode n) {
        while(n != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }

    private static boolean compare(ListNode m, ListNode n) {
        if(m == null && n == null)
            return true;

        if(m == null || n == null || m.val != n.val)
            return false;

        return compare(m.next, n.next);
    }
}


