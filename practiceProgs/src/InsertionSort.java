public class InsertionSort {
    private static int[] arr;

    private static void sort() {
        for(int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        arr = new int[]{2, 5, 1, 7, 9, 4};
        sort();
        for(int i  : arr) {
            System.out.print(i +  " ");
        }
    }
}
