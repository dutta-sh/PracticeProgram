public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(getLongestPalin("dcaababaacd"));
        System.out.println(getShortestPalin("abacccccc"));
    }

    private static String getLongestPalin(String s) {
        int[] pos = new int[] {0, 0};
        for(int i = 1; i < s.length() - 1; i++) {
            int[] even = palinPos(i - 1, i, s);
            int[] odd = palinPos(i - 1, i + 1, s);
            pos = maxLen(pos, maxLen(even, odd));
        }
        return s.substring(pos[0], pos[1]);
    }


    private static int[] palinPos(int l, int r, String s) {
        while(l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[] {l+1, r};
    }

    private static int[] maxLen(int[] a, int[] b) {
        return a[1] - a[0] > b[1] - b[0] ? a : b;
    }

    //////////////////////////

    private static String getShortestPalin(String s) {
        return getShortestRec(s, 1);
    }

    private static String getShortestRec(String s, int i) {
        if(i == s.length())
            return String.valueOf(s.charAt(i - 1));

        if(s.charAt(i - 1) == s.charAt(i))
            return s.substring(i - 1, i + 1);

        if(i < s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1))
            return s.substring(i - 1, i + 2);

        return getShortestRec(s, ++i);
    }
}
