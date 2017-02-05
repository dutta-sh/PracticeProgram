import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

class Vertex {
    private String name;
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    
    public Vertex(String name){
    	if(name == null)
    		throw new RuntimeException("Vertex name can't be null");
        this.name = name;
    }

    public void addEdge(Edge edge){
        if(!edges.contains(edge))
        	edges.add(edge);
    }

    public boolean removeEdge(Edge e){
        return edges.remove(e);
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<Edge> getEdges(){
        return edges;
    }

    public String toString() {
    	StringBuilder strBld = new StringBuilder();
		strBld.append(name + " --> ");
        for(Edge e : edges){
        	strBld.append(e + ",");
        }
    	return strBld.toString();
    }
    
    public boolean equals(Object o){
        if(o instanceof Vertex) {
        	Vertex v = (Vertex)o;
            return this.name.equals(v.name);
        }
        return false;
    }
    
    public int hashCode() {
    	return name.hashCode();
    }
}

class Edge {
    private Vertex v1;
    private Vertex v2;
    
    public Edge(Vertex v1, Vertex v2){
    	if(v1 == null || v2 == null)
    		throw new RuntimeException("Vertices of Edge can't be null");
    	if(v1.getName().compareTo(v2.getName()) == 0) {
    		throw new RuntimeException("Can't create Edge within same Vertex " + v1);
    	} else if(v1.getName().compareTo(v2.getName()) < 0) {
    		this.v1 = v1;
    		this.v2 = v2;
    	} else {
    		this.v1 = v2;
    		this.v2 = v1;
    	}
    }

    public Vertex getV1(){
        return v1;
    }

    public Vertex getV2(){
        return v2;
    }

    public String toString(){
        return "{" + v1.getName() + ", " + v2.getName() + "}";
    }
    
    public boolean equals(Object o){
        if(o instanceof Edge) {
        	Edge e = (Edge)o;
            return e.v1.equals(v1) && e.v2.equals(v2);
        }
        return false;
    }
    
    public int hashCode() {
    	return (v1.getName() + v2.getName()).hashCode();
    }
}

public class Graph {
    private LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
    
    public Graph(Collection<Vertex> vertices){
        this.vertices.addAll(vertices);
    }
    
    public void addEdge(Vertex v1, Vertex v2){
    	if(vertices.contains(v1) && vertices.contains(v2)) {
    		Edge e = new Edge(v1, v2);    
            v1.addEdge(e);
            v2.addEdge(e);
    	}
    }
    
    public boolean removeEdge(Edge e){
        return (e.getV1().removeEdge(e) && e.getV2().removeEdge(e));
    }
        
    public void addVertex(Vertex vertex){
    	removeVertex(vertex);
        vertices.add(vertex);
    }
        
    public boolean removeVertex(Vertex vertex){
    	if(vertices.contains(vertex)) {
    		while(vertex.getEdges().size() > 0){
                removeEdge(vertex.getEdges().get(0));
            }
    		vertices.remove(vertex);
    		return true;
    	}
        return false;
    }
    
    public LinkedHashSet<Vertex> getVertices(){
        return vertices;
    }
    
    public LinkedHashSet<Edge> getEdges(){
    	LinkedHashSet<Edge> edges = new LinkedHashSet<Edge>();
    	for(Vertex v : vertices) {
    		edges.addAll(v.getEdges());
    	}
        return edges;
    }
    
    public String toString() {
    	StringBuilder strBld = new StringBuilder();
    	for(Vertex v : vertices){
    		strBld.append(v + "\r\n");
        }
    	return strBld.toString();
    }
}