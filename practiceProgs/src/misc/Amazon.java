package misc;

import java.util.*;

public class Amazon {

    public static List<String> foo(String inputStr, int num) {
        // Write your code here
        int len = inputStr.length();
        List<String> response = new ArrayList<>();
        for(int i = 0; i <= len - num; i++) {
            String sub = inputStr.substring(i, i + num);    //sliding window string

            Set<Character> charSet = new HashSet<>();
            boolean charFoundTwice = false;                   //stores if exactly one char is present twice
            for(Character c : sub.toCharArray()) {
                if(!charSet.contains(c)) {       //add this char - this is new
                    charSet.add(c);
                } else if(charFoundTwice && charSet.contains(c)) {   //another char is already present twice
                    charFoundTwice = false;
                    break;
                } else if(!charFoundTwice && charSet.contains(c)) {   //this char is present twice
                    charFoundTwice = true;
                }
            }

            if(charFoundTwice) {
                if(!response.contains(sub))
                    response.add(sub);
            }
        }

        Collections.sort(response);

        return response;
    }

    public static void main(String[] args) {
        List<String> s1 = Arrays.asList("a", "b");
        List<String> s2 = Arrays.asList("d", "e");
        List<String> s3 = Arrays.asList("c", "e");
        List<String> s4 = Arrays.asList("f", "g", "c");

        List<List<String>> list = new ArrayList<>();
        list.add(s1); list.add(s2); list.add(s3); list.add(s4);

        System.out.println(foo(list));

    }

    static class MyNode {
        String s;
        Set<MyNode> neighbors = new HashSet<>();

        public MyNode(String s) {
            this.s = s;
        }

        public void addNeighbor(MyNode n) {
            neighbors.add(n);
        }

        public String toString() {
            String nei = "";
            for(MyNode n : neighbors) {
                nei += n.s + " ";
            }
            return (s + " -> " + nei);
        }
    }

    public static List<String> foo(List<List<String>> itemAssociation) {
        //generate the graph
        Map<String, MyNode> graph = new HashMap<>();
        for(List<String> items : itemAssociation) {
            int size = items.size();
            for(int i = 0; i < size; i++) {
                MyNode node = graph.getOrDefault(items.get(i), new MyNode(items.get(i)));
                graph.put(items.get(i), node);

                if(i != size - 1) {
                    MyNode n = graph.getOrDefault(items.get(i + 1), new MyNode(items.get(i + 1)));
                    node.addNeighbor(n);
                    n.addNeighbor(node);
                    graph.put(items.get(i + 1), n);
                }

                if(i != 0) {
                    MyNode n = graph.getOrDefault(items.get(i - 1), new MyNode(items.get(i - 1)));
                    node.addNeighbor(n);
                    n.addNeighbor(node);
                    graph.put(items.get(i - 1), n);
                }
            }
        }
        System.out.println(graph);

        Set<String> visited = new HashSet<>();
        Set<String> longest = new TreeSet<>();
        for(String s : graph.keySet()) {
            Set<String> thisVisit = new TreeSet<>();
            dfs(graph.get(s), visited, thisVisit);

            if(thisVisit.size() > longest.size())
                longest = thisVisit;
        }

        String s = "recur(t, )";
        s.replaceAll("\\(\\)", "");

        return new ArrayList(longest);
    }

    public static void dfs(MyNode n, Set<String> visited, Set<String> thisVisit) {
        if(!visited.contains(n.s)) {
            visited.add(n.s);
            thisVisit.add(n.s);
            for(MyNode neighbor : n.neighbors) {
                dfs(neighbor, visited, thisVisit);
            }
        }
    }


    public List<List<Integer>> sumToHundred(List<Integer> input) {

        Map<Integer,Integer> found = new HashMap<>();
        Map<Integer,Integer> expectation = new HashMap<>();
        List<List<Integer>> output = new ArrayList<>();

        for(int elem : input) {
            if(expectation.containsKey(elem)) {
                List<Integer> tuple = new ArrayList<>();
                tuple.add(100 - elem, elem);
                output.add(tuple);

                int freq = expectation.get(elem);
                if(freq > 1) {
                    expectation.put(elem, --freq);
                } else {
                    expectation.remove(elem);
                }

                freq = found.get(elem);
                if(freq > 1) {
                    found.put(elem, --freq);
                } else {
                    found.remove(elem);
                }

            } else {
                if(found.containsKey(elem)) {
                    found.put(elem, found.get(elem)+1);
                } else {
                    found.put(elem, 1);
                }

            }
        }
        return output;

    }
}
