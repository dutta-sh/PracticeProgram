public class QuickSort {

    private static int[] arr;

    private static void sort(int l, int r) {
        if(l < r) {
            int pivot = partition(l, r);
            sort(l, pivot - 1);
            sort(pivot + 1, r);
        }
    }

    private static int partition(int l, int r) {
        int idx = l - 1;
        for(int i = l; i < r; i++) {
            if(arr[i] <= arr[r]) {
                idx++;
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
            }
        }

        int pivot = idx + 1;
        int temp = arr[pivot];
        arr[pivot] = arr[r];
        arr[r] = temp;

        return pivot;
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
