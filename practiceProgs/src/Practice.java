public class Practice {

    public static void main(String[] args) {
        String str = "(()))(()()())))";

        str = ")((())(";
        System.out.println(solution(str));
        System.out.println(solution1(str));
    }

    public static int solution(String s) {

        int foundAt = -1;
        int start = 0;
        int end = s.length() - 1;
        int openCt = 0;
        int closeCt = 0;

        while(start <= end) {
            if(openCt < closeCt) {
                if(s.charAt(start) == '(')
                    openCt++;
                start++;
            } else {
                if(s.charAt(end) == ')')
                    closeCt++;
                end--;
            }
            if(openCt == closeCt)
                foundAt = end + 1;
        }
        return foundAt;
    }

    public static int solution1(String s) {

        int[] openBkt = new int[s.length() + 1];
        int[] closeBkt = new int[s.length() + 1];

        int ct = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                openBkt[i] = ++ct;

            System.out.print(openBkt[i] + " ");
        }
        System.out.println();

        ct = 0;
        for(int i = s.length() - 1; i >=0; i--) {
            if(s.charAt(i) == ')')
                closeBkt[i] = ++ct;

            System.out.print(closeBkt[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < s.length(); i++) {
            if(openBkt[i] == closeBkt[i])
                return i;
        }

        return -1;
    }
}
