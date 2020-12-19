package misc;

public class Jet {
    /*
    Input:
    1 -> 2 -> 3 -> 4 -> 5
    m = 2
    n = 4
    
    Output:
    1 -> 4 -> 3 -> 2 -> 5
    m <= n
    */

    public static void main(String args[] ) throws Exception {
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(20);
        ListNode n3 = new ListNode(30);
        ListNode n4 = new ListNode(40);
        ListNode n5 = new ListNode(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        print(n1);

        Jet sl = new Jet();
        ListNode h = sl.reverseSubList(n1, 2, 4);
        print(h);
    }

    private static void print(ListNode n) {
        while(n != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }

    private ListNode reversedHead;


    private ListNode reverseSubList(ListNode head, int m, int n) {
        //do validations
        if(head == null || head.next == null || m <= 0 || n <= 0 || n <= m) {
            return head;
        }

        ListNode t = head;
        int ct = 0;

        while(t != null) {
            ct++;
            t = t.next;
        }

        if(m >= ct || n >= ct)
            return head;

        if(m == 1 && n == ct) {
            ListNode temp = head;
            reverse(temp, temp.next, n, m);
            return reversedHead;
        }

        //actual reversal
        ListNode m_1_th = head;
        t = head;
        for(int i = 1; i <= n; i++) {
            t = t.next;
            if(i == m - 1) {
                m_1_th = t;
            }
        }
        ListNode n_plus_1th = t.next;

        ListNode temp = m_1_th.next;
        ListNode n_th = reverse(temp, temp.next, n, m);
        m_1_th.next = reversedHead;
        n_th.next = n_plus_1th;

        return head;
    }


    private ListNode reverse(ListNode start, ListNode nextNode, int endIdx, int currIdx) {
        if(currIdx == endIdx) {
            reversedHead = start;
            return start;
        }

        //3 <- 4 <- 5    
        ListNode reversed = reverse(nextNode, nextNode.next, endIdx, ++currIdx);
        //1 -> 2 -> <- 3 <- 4 <- 5
        start.next.next = start;
        //1 -> 2 <- 3 <-4  <- 5
        start.next = null;
        return start;
    }
}