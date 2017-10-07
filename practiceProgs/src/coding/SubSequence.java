package coding;

public class SubSequence {

    public static void main(String[] args) {
        String str1 = "babgbag";
        String str2 = "bag";

        System.out.println(count(str1, str2, str1.length(), str2.length()));
    }

    public static int count(String a, String b, int m, int n) {
        //if both are empty or second is empty, return 1
        if ((m == 0 && n == 0) || n == 0)
            return 1;

        //if only first string is empty return 0
        if (m == 0 && n != 0)
            return 0;

        //if last chars are same recursive for remaining strings by
        //consider last chars of both strings and ignore last char of first string
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return count(a, b, m - 1, n - 1) + count(a, b, m - 1, n);
        else
            //if last chars are diff, ignore last char of first and recur for rest
            return count(a, b, m - 1, n);
    }
}