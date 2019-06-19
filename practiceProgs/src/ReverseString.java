public class ReverseString {
    public static void main(String[] args) {
        String s = "shouvik";
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        if(s.equals(""))
            return "";

        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
