import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Integer> fnMap = new HashMap<>();

    public static void main(String[] args) {
        int i = fn2(8);
        System.out.println(i);
    }

//    f(1) -> 1
//    f(2) -> 1
//    f(3) -> 2
//    f(4) -> 3
//    f(5) -> 5
//    f(6) -> 8
//    f(7) -> 13
//    f(8) -> 21

    //using simple recursion
    public static int fn(int i) {
        if(i <= 1) return i;
        int j = fn(i - 1);
        int k = fn(i - 2);
        return j + k;
        //return fn(i - 1) + fn(i - 2);
    }

    //using dynamic programming
    public static int fn2(int i) {
        if(i <= 1) {
            fnMap.put(i, 1);
            System.out.println("Adding to map: " + i + "::::" + "1");
            return i;
        }
        int fn_i_1;
        int fn_i_2;

        if(fnMap.get(i - 1) != null) {
            fn_i_1 = fnMap.get(i - 1);
            System.out.println("Got from map:" + (i-1) + "::::" + fn_i_1);
        } else {
            fn_i_1 = fn2(i - 1);
            fnMap.put(i - 1, fn_i_1);
            System.out.println("Adding to map: " + (i-1) + "::::" + fn_i_1);
        }

        if(fnMap.get(i - 2) != null) {
            fn_i_2 = fnMap.get(i - 2);
            System.out.println("Got from map:" + (i-2) + "::::" + fn_i_2);
        } else {
            fn_i_2 = fn2(i - 2);
            fnMap.put(i - 2, fn_i_2);
            System.out.println("Adding to map: " + (i-2) + "::::" + fn_i_2);
        }

        return fn_i_1 + fn_i_2;
    }

}
