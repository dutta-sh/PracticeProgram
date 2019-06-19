public class RecurCompress {

    public static void main(String[] args) {

        String str = "aaaabbccccd";
        //System.out.println(recur(0, 0, str));
        System.out.println(recur(1, 1, str));
    }

    private static String recur(int pos, int ct, String str) {
        if(pos == str.length())
            return str.charAt(pos - 1) + "" + ct;

        if(/*pos == 0 || */str.charAt(pos) == str.charAt(pos - 1))
            return recur(pos + 1, ++ct, str);

        return str.charAt(pos - 1) + "" + ct + recur(pos + 1, 1, str);
    }
}
