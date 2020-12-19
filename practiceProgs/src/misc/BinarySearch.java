package misc;

public class BinarySearch {

    //A zero-indexed array A consisting of N integers is given.
    // An equilibrium index of this array is any integer P such that 0 ≤ P < N


    private static int[] arr = {2, 3, 5, 7, 8, 9, 10};

    public static void main(String[] args) {
        System.out.println(binarySearch(0, arr.length - 1, 9));
    }


    private static int binarySearch(int left, int right, int find) {
        if(left >= right)
            return -1;
        
        int mid = (left + right)/2; // which is = left + (right - left)/2;
        if(arr[mid] == find)
            return mid;

        if(arr[mid] > find)
            return binarySearch(left, mid - 1, find);
        else
            return binarySearch(mid + 1, right, find);

    }
}
