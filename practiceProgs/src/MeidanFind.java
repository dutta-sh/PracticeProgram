public class MeidanFind {

    static int arr[] = {4, 7, 8, 9, 1, 5};

    public static void main(String[] args) {
        int left = 0 ;
        int right = arr.length - 1;
        int kth = right/2;
        int nth = arr.length %2 == 0 ? arr.length/2 - 1 : -1;

        selection(left, right, kth);
        if(nth != - 1)
            selection(left, right, nth);
    }


    private static int selection(int left, int right, int kth) {
        int pivotIdx = -1;
        while(kth != pivotIdx) {
            pivotIdx = partition(left, right);

            System.out.println(left + "______" + right);
            System.out.println(pivotIdx);
            print();

            if(kth < pivotIdx)
                right = pivotIdx - 1;
            else if (kth > pivotIdx)
                left = pivotIdx + 1;
            else
                System.out.println(pivotIdx + "-->" + arr[pivotIdx]);
        }

        return arr[pivotIdx];
    }

    private static int partition(int low, int high) {
        int pivotVal = arr[high];
        int idx = low - 1;

        for(int j = low; j < high; j++) {
            if(pivotVal >= arr[j]) {
                idx++;
                int temp = arr[j];
                arr[j] = arr[idx];
                arr[idx] = temp;
            }
        }

        int pivotPos = idx + 1;
        int temp = arr[pivotPos];
        arr[pivotPos] = arr[high];
        arr[high] = temp;

        return pivotPos;
    }

    private static void print() {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
