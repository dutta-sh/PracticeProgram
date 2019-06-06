import java.util.ArrayList;

public class IslandCount {
    private static int[] dx = new int[] {1, 0, -1, 0};
    private static int[] dy = new int[] {0, 1, 0, -1};
    private static int[][] m;
    private static boolean[][] visited;
    private static int r;
    private static int c;

    public static ArrayList<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        m = matrix;
        r = matrix.length;
        c = matrix[0].length;
        visited = new boolean[r][c];

        ArrayList<Integer> sizes = new ArrayList<>();

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(isSafe(i, j)) {
                    int size = dfs(i, j, 0);
                    sizes.add(size);
                }
            }
        }
        return sizes;
    }

    private static boolean isSafe(int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c && m[i][j] == 1 && !visited[i][j];
    }

    private static int dfs(int i, int j, int ct) {
        visited[i][j] = true;
        ct++;
        for(int k = 0; k <= 3; k++) {
            int dr = i + dx[k];
            int dc = j + dy[k];
            if(isSafe(dr, dc)) {
                ct = dfs(dr, dc, ct);
            }
        }
        return ct;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,0,0,1,0},
                {1,0,1,0,0},
                {0,0,1,0,1},
                {1,0,1,0,1},
                {1,0,1,1,0}};

        ArrayList<Integer> sizes = riverSizes(matrix);

        System.out.println(sizes);
    }
}
