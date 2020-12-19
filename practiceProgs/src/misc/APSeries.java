package misc;

import java.util.Arrays;
import java.util.Collections;

public class APSeries {
    public static int solve(int[] A) {
        int l = A.length;
        int maxCount = -1;
        for(int i = 0; i < l; i++) {
            for(int j = i+1; j < l; j++) {
                int ap = Math.abs(A[i]-A[j]);
                int count = 2;
                int diff = ap;
                for(int k = 0; k < l; k++) {
                    if(k == i || k == j)
                        continue;

                    int ap2 = Math.abs(A[j]-A[k]);
                    if(diff == ap2) {
                        count++;
                        System.out.println(A[i] + ", " + A[j] + ", " + A[k] + " = " + count);
                        diff += ap;
                    }
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        //int[] A = new int[]{100, 10, 8, 300, 6, 1, 4, 2};
        int[] A = new int[]{1, 2, 4, 6, 8, 10, 100, 300};
        System.out.println(solve(A));
    }
}
