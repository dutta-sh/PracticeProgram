package sorting;

/**
 * Created by Shouvik on 7/16/2017.
 * Take the first element as a sorted sub-array.
 * Insert the second element into the sorted sub-array (shift elements if needed).
 * Insert the third element into the sorted sub-array.
 * Repeat until all elements are inserted.
 */
public class InsertionSort {
    public static void main(String[] args) {
        sort2(new int[]{38, 27, 43, 3, 9, 82, 10});
    }

    private static void sort2(int[] x) {
        for(int i = 1; i < x.length; i++) {
            int temp = x[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(temp > x[j])
                    break;

                x[j + 1] = x[j];
            }
            x[j + 1] = temp;
            print(x);
        }
    }

    public static void print(int[] data) {
        for (int num : data)
            System.out.print(num + " ");

        System.out.println();
    }
}
