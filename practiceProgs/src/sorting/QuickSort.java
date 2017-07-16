package sorting;

public class QuickSort  {
    private static int[] numbers;

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high-low)/2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;

                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    public static void main(String[] args) {
        numbers = new int[] {10, 50, 40, 30, 20};

        if (numbers ==null || numbers.length==0){
            return;
        }
        quicksort(0, numbers.length - 1);

        for(int val : numbers)
            System.out.print(val + ",");
    }
}