package bgc;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String city;
    private boolean visited;
    private List<Vertex> adjList = new ArrayList<>();

    public Vertex(String city) {
        this.city = city;
    }

    public void addEdge(Vertex cityCode) {
        adjList.add(cityCode);
    }

    public String getCity() {
        return city;
    }

    public List<Vertex> getAdjList() {
        return adjList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}