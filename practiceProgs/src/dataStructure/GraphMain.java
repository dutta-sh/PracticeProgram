package dataStructure;

import java.util.Arrays;
import java.util.List;

public class GraphMain {
	public static void main(String[] args){
		Vertex a = new Vertex("a"); 
        Vertex b = new Vertex("b"); 
        Vertex c = new Vertex("c"); 
        Vertex d = new Vertex("d"); 
        Vertex e = new Vertex("e");
        List<Vertex> vList = Arrays.asList(a, b, c, d, e);
        
		Graph graph = new Graph(vList);        
        //duplicate edges not added
        for(int i = 0; i < vList.size() - 1; i++){
            for(int j = i + 1; j < vList.size(); j++){
               graph.addEdge(vList.get(i), vList.get(j));
               graph.addEdge(vList.get(i), vList.get(j));
            }
        }
        
        System.out.println(graph);
        System.out.println("---------------------------------");
        
        graph.addVertex(d);
        System.out.println(graph);
        System.out.println("---------------------------------");
        
        System.out.println("Contains {b, c}: " + graph.getEdges().contains(new Edge(b, c)));	//true
        System.out.println("Removed  {b, c}: " + graph.removeEdge(new Edge(b, c))); 			//true
        System.out.println("Contains {b, c}: " + graph.getEdges().contains(new Edge(b, c)));	//false
        System.out.println("Contains {c, d}: " + graph.getEdges().contains(new Edge(c, d)));	//false
        System.out.println("Contains dataStructure.Vertex:a " + graph.getVertices().contains(b)); 			//true
        System.out.println("Contains dataStructure.Vertex:f " + graph.getVertices().contains(new Vertex("f")));//false
        System.out.println("Removed dataStructure.Vertex:c " + graph.removeVertex(c)); 						//true
        System.out.println("---------------------------------");
        System.out.println(graph); //a,b,e,d
    }
}