import java.util.*;

public class CustomTreeMap {

    public static void main(String[] args) {
        CustomTreeMap ctm = new CustomTreeMap();
        ctm.test();
    }

    public static class Node {
        int x, y, val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "x=" + x + ", y=" + y + ", val=" + val + '}';
        }
    }

    public void test() {
        Queue<Node> myQueue = new PriorityQueue<>((o1, o2) -> {
            if(o1.x != o2.x)
                return o1.x - o2.x;
            else if(o1.y != o2.y)
                return o1.y - o2.y;
            else
                return o1.val - o2.val;
        });

        Set<Node> mySet = new TreeSet<>((o1, o2) -> {
            if(o1.y != o2.y)
                return o1.y - o2.y;
            else if(o1.x != o2.x)
                return o1.x - o2.x;
            else
                return o1.val - o2.val;
        });

        Map<Node, String> myMap = new TreeMap<>((o1, o2) -> {
            if(o1.val != o2.val)
                return o1.val - o2.val;
            else if(o1.y != o2.y)
                return o1.y - o2.y;
            else
                return o1.x - o2.x;
        });

        Node n1 = new Node(0, 0, 30);
        Node n2 = new Node(0, 1, 20);
        Node n3 = new Node(1, 0, 10);

        myQueue.add(n3); myQueue.add(n2); myQueue.add(n1);
        mySet.add(n3); mySet.add(n2); mySet.add(n1);
        myMap.put(n3, n3.toString()); myMap.put(n2, n2.toString()); myMap.put(n1, n1.toString());

        while(!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }
        System.out.println("---------------------------");
        for(Node n : mySet) {
            System.out.println(n);
        }
        System.out.println("---------------------------");
        for(Node n :  myMap.keySet()) {
            System.out.println(n);
        }
        System.out.println("---------------------------");



        List<String> list = new ArrayList<>();
        Collections.reverse(list);
        list.toArray(new String[list.size()]);


        int[][] intervals = new int[][] {{1,2}, {0, 5}, {9, 10}};
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.toString(intervals[0]));
    }
}