package misc;

public class Palindrome {

    public static void main(String[] args) {
        String str = "aba";
        System.out.println(isPalin(str));
    }

    private static boolean isPalin(String str) {
        if(str == null)
            return false;
        if(str.isEmpty())
            return true;

        return compareChars(str, 0, str.length() - 1);
    }

    private static boolean compareChars(String str, int l, int r) {
        if(l > r || l == r)
            return true;

        if(str.charAt(l) == str.charAt(r))
            return compareChars(str, l+1, r-1);

        return false;
    }
}
