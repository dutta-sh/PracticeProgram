package misc;

public class LargestPalin {

    public static void main(String[] args) {
        System.out.println('a' ^ 256);


//        for(int i = 999; i > 99; i--) {
//            for(int j = i; j > 99; j--) {
//                long val = i * j;
//
//                if(isPalin(val)) {
//                    System.out.println(val + ", " + i + ", " + j);
//                    System.out.println("***************");
//                }
//            }
//        }
    }

    public static boolean isPalin(long num) {
        String str = String.valueOf(num);
        return isPalin(str, 0, str.length() - 1);
    }

    public static boolean isPalin(String s, int l, int r) {
        if(l >= r)
            return true;

        if(s.charAt(l) == s.charAt(r))
            return isPalin(s, ++l, --r);

        return false;
    }
}
