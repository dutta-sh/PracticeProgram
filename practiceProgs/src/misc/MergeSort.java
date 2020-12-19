package misc;

public class MergeSort {

    private static int[] arr;

    private static void sort(int l, int r) {
        if(l < r) {
            int m = (l + r)/2;
            sort(l, m);
            sort(m + 1, r);
            merge(l, m, r);
        }
    }

    public static void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for(int i = 0; i < n1; i++) {
            lArr[i] = arr[ l + i];
        }
        for(int j = 0; j < n2; j++) {
            rArr[j] = arr[ m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        arr = new int[]{2, 5, 1, 7, 9, 4};
        int l = 0;
        int r = arr.length - 1;

        sort(l, r);

        for(int i  : arr) {
            System.out.print(i +  " ");
        }
    }
}
