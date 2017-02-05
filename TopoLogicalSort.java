import java.io.File;
import java.util.*;

public class TopoLogicalSort {
	private List<LinkedList<Integer>> adjList; // adjacency List
	
	public TopoLogicalSort(int vertexCount){
		adjList = new ArrayList<LinkedList<Integer>>(vertexCount);
	}
	
	public void addVertex(int v){ // add vertex to the graph
		adjList.add(v, new LinkedList<Integer>());
	}
	
	public void addEdge(int v, int w){
		adjList.get(v).add(w);
	}

	// recursive function for topologicalSort
	private void topologicalSortUtil(int v, boolean visited[], List<Integer> sorted) {
		visited[v] = true; //node is visited
		
		// recur for all adjacent vertices
		for(Integer i : adjList.get(v)){
			if (!visited [i])
				topologicalSortUtil(i, visited, sorted);
		}
		sorted.add(v);
	}
	
	public void topologicalSort(){
		List<Integer> sorted = new ArrayList();
		boolean visited[] = new boolean[adjList.size()]; // mark all the vertices as not visited
		for (int i = 0; i < adjList.size(); i++)
			if (visited[i] ==  false)
				topologicalSortUtil(i, visited, sorted);
		
		for (Integer v: sorted){
			System.out.print(v + " ");}
		
	}
	
	public static void main(String args[]) throws Exception{

		File f = new File("input.dat");
		Scanner in = new Scanner(f);
		String countOfNodes = in.nextLine();
		
		TopoLogicalSort t = new TopoLogicalSort(Integer.parseInt(countOfNodes));
		String[] vertices = in.nextLine().split(" ");
		for(String vertex : vertices){
			
			t.addVertex(Integer.parseInt(vertex));
			
		}
		
		while(in.hasNext()){
			String[] line = in.nextLine().split(" ");
			
			int v1 = Integer.parseInt(line[0].trim());
			int v2 = Integer.parseInt(line[1].trim());
			t.addEdge(v1, v2);
		}
		in.close();
		
		t.topologicalSort();
	}
}
