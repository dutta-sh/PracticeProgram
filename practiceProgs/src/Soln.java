import java.util.*;

public class Soln {

    public static int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8

        Coord AB = new Coord(A, B, "AB");
        Coord AC = new Coord(A, C, "AC");
        Coord AD = new Coord(A, D, "AD");
        Coord BC = new Coord(B, C, "BC");
        Coord BD = new Coord(B, D, "BD");
        Coord CD = new Coord(C, D, "CD");

        List<Coord> coords = Arrays.asList(new Coord[] {AB, AC, AD, BC, BD, CD});
        Collections.sort(coords, Collections.reverseOrder());
        //System.out.println(coords);

        Coord coord1 = coords.get(0);
        String co1 = coord1.getName().substring(0, 1);
        String co2 = coord1.getName().substring(1);

        Coord coord2 = null;

        for(Coord entry : coords) {
            if(!entry.getName().contains(co1) && !entry.getName().contains(co2)) {
                coord2 = entry;
                break;
            }
        }

        return (coord1.getDist() * coord1.getDist()) + (coord2.getDist() * coord2.getDist());

    }

    public static void main(String[] args) {
        System.out.print(solution(2, 4, 2, 4));
    }
}

class Coord implements Comparable{

    private int dist;
    private String name;

    public Coord(int x, int y, String name) {
        this.name = name;
        this.dist = Math.abs(x - y);
    }

    public int getDist() {
        return dist;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return this.dist - ((Coord) o).dist;
    }

    @Override
    public String toString() {
        return "Coord{" + "dist=" + dist + ", name='" + name + '}';
    }
}
