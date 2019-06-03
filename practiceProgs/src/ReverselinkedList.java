public class ReverselinkedList {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.push(10); ll.push(20);ll.push(30);ll.push(40);
        System.out.println(ll);

        LinkedList reversed = new LinkedList();
        reversed = reverse(ll.head, reversed);
        System.out.println(reversed);
    }

    private static LinkedList reverse(ListNode node, LinkedList reversed) {
        if(node != null) {
            reversed.push(node.val);
            reverse(node.next, reversed);
        }
        return reversed;
    }
}


class LinkedList {

    ListNode head = null;

    public void push(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public String toString() {
        ListNode node = head;
        StringBuilder strBld = new StringBuilder();
        while(node != null) {
            strBld.append(node.val + " ");
            node = node.next;
        }
        return strBld.toString();
    }
}