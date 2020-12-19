package misc;

import java.util.*;

public class GraphNode {
    String name;
    Map<GraphNode, Integer> adjacency = new HashMap<>();
    Integer distance = Integer.MAX_VALUE;
    List<GraphNode> shortestPath = new ArrayList<>();

    public void addDestination(GraphNode destination, int distance) {
        adjacency.put(destination, distance);
    }

    public GraphNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        shortestPath.forEach(g -> strBld.append(g.name));
        strBld.append(name);

        return name + " :: " + distance + " :: " + strBld;
    }
}
