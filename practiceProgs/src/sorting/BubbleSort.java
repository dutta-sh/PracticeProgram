package sorting;

/**
 * Created by Shouvik on 7/14/2017.
 * Scan the array, swapping adjacent pair of elements if they are not in relative order.
 * This bubbles up the largest element to the end.
 * Scan the array again, bubbling up the second largest element.
 * Repeat until all elements are in order.
 */
public class BubbleSort {

    public static void main(String[] args) {
        sortArray1(new int[]{38, 27, 43, 3, 9, 82, 10});
        System.out.println("---------------------------");
        sortArray2(new int[]{38, 27, 43, 3, 9, 82, 10});
        System.out.println("---------------------------");
        sortArray3(new int[]{38, 27, 43, 3, 9, 82, 10});
    }

    public static void sortArray1(int[] x) {
        for (int i = x.length - 1; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 0; j <= i - 1; j++) { // bubble up
                if (x[j] > x[j + 1]) {
                    swap(x, j, j + 1);
                    swapped = true;
                }
            }
            print(x);
            if (!swapped)
                break;
        }
    }

    public static void sortArray2(int[] x) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i] > x[i + 1]) {
                    swap(x, i, i + 1);
                    swapped = true;
                }
            }
            print(x);
        }
    }

    public static void sortArray3(int[] x) {
        boolean swapped;
        do {
            swapped = false;
            for(int i = 0; i < x.length - 1; i ++) {
                if(x[i] > x[i + 1]) {
                    swap(x, i, i + 1);
                    swapped = true;
                }
            }
            print(x);
        } while(swapped);
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
