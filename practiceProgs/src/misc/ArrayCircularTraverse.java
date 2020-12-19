package misc;

import java.util.ArrayList;
import java.util.List;

public class ArrayCircularTraverse {

    public static void main(String[] args) {
        int[][] array = new int[][] {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        List<Integer> list = spiralTraverse(array);
        System.out.println(list);
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        boolean[][] visited = new boolean[array.length][array[0].length];
        List<Integer> list = new ArrayList<>();
        visit(0, 0, array, visited, list, array.length*array[0].length);
        return list;
    }

    public static void visit(int r, int c, int[][] array, boolean[][] visited, List<Integer> list, int total) {
        int count = 0;
        while(count < total) {
            while(isValid(r, c, visited)) {
                visited[r][c] = true;
                list.add(array[r][c++]);
                count++;
            }
            c--;r++;
            while(isValid(r, c, visited)) {
                visited[r][c] = true;
                list.add(array[r++][c]);
                count++;
            }
            r--;c--;
            while(isValid(r, c, visited)) {
                visited[r][c] = true;
                list.add(array[r][c--]);
                count++;
            }
            c++;r--;
            while(isValid(r, c, visited)) {
                visited[r][c] = true;
                list.add(array[r--][c]);
                count++;
            }
            r++;c++;
        }
    }

    public static boolean isValid(int r, int c, boolean[][] visited) {
        return r >= 0 && c >= 0 && r < visited.length && c < visited[0].length && !visited[r][c];
    }
}
