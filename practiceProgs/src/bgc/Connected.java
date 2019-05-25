package bgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Connected {

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length < 3) {
            System.out.println("Usage: java Connected <citymap file path> <source city> <destination city>");
            System.exit(0);
        }

        Connected connected = new Connected();
        connected.execute(args[0], args[1], args[2]);
    }

    public void execute(String fileName, String sourceCity, String destinationCity) throws FileNotFoundException {
        File file = new File(fileName);
        Map<String, Vertex> nameToVertexMap = createGraph(file);
        Map<String, Integer> nameToZoneMap = markZones(nameToVertexMap);

        //check if two cities are connected (will be in the same zone)
        Integer sourceZone = nameToZoneMap.get(sourceCity);
        Integer desinationZone = nameToZoneMap.get(destinationCity);

        if(sourceZone != null && desinationZone != null && sourceZone.equals(desinationZone)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public Map<String, Vertex> createGraph(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Map<String, Vertex> nameToVertexMap = new HashMap<>();

        //create graph while reading the file
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String source = line.split(",")[0].trim();
            String destination = line.split(",")[1].trim();

            Vertex sVertex = nameToVertexMap.computeIfAbsent(source, s -> new Vertex(s));
            Vertex dVertex = nameToVertexMap.computeIfAbsent(destination, d ->new Vertex(d));

            sVertex.addEdge(dVertex);
            dVertex.addEdge(sVertex);
        }

        return nameToVertexMap;
    }

    public Map<String, Integer> markZones(Map<String, Vertex> nameToVertexMap) {
        Map<String, Integer> nameToZoneMap = new HashMap<>();
        //create map of zones from graph traversal
        int zone = 1;
        for(String name : nameToVertexMap.keySet()) {
            Vertex v = nameToVertexMap.get(name);
            if(!v.isVisited()) {
                doDFS(v, nameToZoneMap, zone);
                zone++;
            }
        }
        System.out.println(nameToZoneMap);
        return nameToZoneMap;
    }

    private void doDFS(Vertex v, Map<String, Integer> nameToZoneMap, int zone) {
        if(!v.isVisited()) {
            v.setVisited(true);
            nameToZoneMap.put(v.getCity(), zone);
            for(Vertex neighbor : v.getAdjList()) {
                doDFS(neighbor, nameToZoneMap, zone);
            }
        }
    }
}