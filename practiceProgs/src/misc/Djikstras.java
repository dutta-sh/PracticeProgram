package misc;

import java.util.*;

public class Djikstras {

    public void compute(GraphNode source) {
        Set<GraphNode> settled = new HashSet<>();
        Set<GraphNode> unSettled = new HashSet<>();

        source.distance = 0;
        unSettled.add(source);

        while(!unSettled.isEmpty()) {
            //get the one with lowest distance as of now
            GraphNode curr = null;
            Integer min = Integer.MAX_VALUE;
            for(GraphNode g : unSettled) {
                if(g.distance < min) {
                    min = g.distance;
                    curr = g;
                }
            }

            unSettled.remove(curr);
            for(GraphNode destination : curr.adjacency.keySet()) {
                if(!settled.contains(destination)) {
                    unSettled.add(destination);

                    //update min distance and shortest path if this is min than current
                    Integer d = curr.adjacency.get(destination);
                    if(d + curr.distance < destination.distance) {
                        destination.distance = d + curr.distance;

                        List<GraphNode> shortestSoFar = new ArrayList<>(curr.shortestPath);
                        shortestSoFar.add(curr);
                        destination.shortestPath = shortestSoFar;
                    }
                }
            }
            settled.add(curr);
        }
    }

    public void invoke() {
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        GraphNode nodeF = new GraphNode("F");

        List<GraphNode> graph = new ArrayList<>();
        graph.add(nodeA);
        graph.add(nodeB);
        graph.add(nodeC);
        graph.add(nodeD);
        graph.add(nodeE);
        graph.add(nodeF);

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        compute(nodeA);

        graph.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Djikstras djikstras = new Djikstras();
        djikstras.invoke();
    }
}
