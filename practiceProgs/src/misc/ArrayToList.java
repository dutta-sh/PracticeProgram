package misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        List<Integer> list = Arrays.asList(arr);

        Collections.addAll(list, arr);

        int[] arr1 = new int[]{1, 2, 3,4};
        Arrays.sort(arr1);

    }
}
