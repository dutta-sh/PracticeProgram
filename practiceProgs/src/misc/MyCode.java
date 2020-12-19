package misc;

public class MyCode {
    public static void main (String[] args) {
        System.out.println(isPalindrome("abaaba"));
    }


    private static boolean isPalindrome(String str) {
        if(str.length() <= 1)
            return true;

        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }


    private static boolean isPalin(String str) {
        int n = str.length();

        for(int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(n - i - 1))
                return false;
        }
        return true;
    }
}