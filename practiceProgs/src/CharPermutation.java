/**
 * Created by Shouvik on 7/13/2017.
 */
public class CharPermutation {

    public static void main(String[] args) {
        permutation("", "abc");
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
