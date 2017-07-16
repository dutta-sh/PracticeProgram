package sorting;

/**
 * Created by Shouvik on 7/16/2017.
 * Find the smallest element, and put it to the first position.
 * Find the next smallest element, and put it to the second position.
 * Repeat until all elements are in the right positions.
 */
public class SelectionSort {

    public static void main(String[] args) {
        sort(new int[]{38, 27, 43, 3, 9, 82, 10});
    }

    private static void sort(int[] x) {
        for(int i = 0; i < x.length; i++) {
            int minPos = i;
            for(int j = i+1; j < x.length; j++) {
                if(x[minPos] > x[j])
                    minPos = j;
            }
            if(minPos != i) {
                swap(x, i, minPos);
                print(x);
            }
        }
    }

    public static void swap(int[] x, int p1, int p2) {
        int temp;
        temp = x[p1];
        x[p1] = x[p2];
        x[p2] = temp;
    }

    public static void print(int[] data) {
        for (int num : data)
            System.out.print(num + " ");

        System.out.println();
    }
}
