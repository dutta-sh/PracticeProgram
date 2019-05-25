class JetNode{
    int val;
    JetNode next;
    JetNode(int x) { val = x; }
}

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
        JetNode n1 = new JetNode(10);
        JetNode n2 = new JetNode(20);
        JetNode n3 = new JetNode(30);
        JetNode n4 = new JetNode(40);
        JetNode n5 = new JetNode(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        print(n1);

        Jet sl = new Jet();
        JetNode h = sl.reverseSubList(n1, 2, 4);
        print(h);
    }

    private static void print(JetNode n) {
        while(n != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }

    private JetNode reversedHead;


    private JetNode reverseSubList(JetNode head, int m, int n) {
        //do validations
        if(head == null || head.next == null || m <= 0 || n <= 0 || n <= m) {
            return head;
        }

        JetNode t = head;
        int ct = 0;

        while(t != null) {
            ct++;
            t = t.next;
        }

        if(m >= ct || n >= ct)
            return head;

        if(m == 1 && n == ct) {
            JetNode temp = head;
            reverse(temp, temp.next, n, m);
            return reversedHead;
        }

        //actual reversal
        JetNode m_1_th = head;
        t = head;
        for(int i = 1; i <= n; i++) {
            t = t.next;
            if(i == m - 1) {
                m_1_th = t;
            }
        }
        JetNode n_plus_1th = t.next;

        JetNode temp = m_1_th.next;
        JetNode n_th = reverse(temp, temp.next, n, m);
        m_1_th.next = reversedHead;
        n_th.next = n_plus_1th;

        return head;
    }


    private JetNode reverse(JetNode start, JetNode nextNode, int endIdx, int currIdx) {
        if(currIdx == endIdx) {
            reversedHead = start;
            return start;
        }

        //3 <- 4 <- 5    
        JetNode reversed = reverse(nextNode, nextNode.next, endIdx, ++currIdx);
        //1 -> 2 -> <- 3 <- 4 <- 5
        start.next.next = start;
        //1 -> 2 <- 3 <-4  <- 5
        start.next = null;
        return start;
    }
}