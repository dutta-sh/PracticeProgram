package misc;

public class GFG {

    static int findIndex(String str) {
        int len = str.length();
        int opn[] = new int[len + 1];
        int cls[] = new int[len + 1];
        int index = -1;

        if(str.length() == 0)
            return index;

        opn[0] = 0;
        cls[len] = 0;

        if (str.charAt(0)=='(')
            opn[1] = 1;
        if (str.charAt(len-1) == ')')
            cls[len - 1] = 1;

        // Store the number of opening brackets at each index
        for (int i = 1; i < len; i++) {
            if ( str.charAt(i) == '(' )
                opn[i+1] = opn[i] + 1;
            else
                opn[i+1] = opn[i];
        }

        // Store the number of closing brackets at each index
        for (int i = len-2; i >= 0; i--) {
            if ( str.charAt(i) == ')' )
                cls[i] = cls[i+1] + 1;
            else
                cls[i] = cls[i+1];
        }

        // check if there is no opening or closing brackets
        if (opn[len] == 0)
            return len;
        if (cls[0] == 0)
            return 0;

        // check if there is any index at which both brackets are equal
        for (int i=0; i<=len; i++)
            if (opn[i] == cls[i])
                index = i;

        return index;
    }

    // Driver Method
    public static void main(String[] args) {
        String str = "(()))(()()())))";
        System.out.println(findIndex(str));

        //str = "))";
        System.out.println(findEqualBrackets(str));
    }

    public static int findEqualBrackets(String S) {
        if (S.length() == 0)    //empty string
            return -1;

        int begin = 0;
        int end = S.length() - 1;
        int openCt = 0;
        int closeCt = 0;
        int equalAt = 0;

        //move one step from begin and one step from end until convergence
        //and check at every point if we have a ( or )

        while(begin <= end && begin < S.length() && end > 0) {
            System.out.println(begin + " " + end + " " + openCt + " " + closeCt);
            if (openCt <= closeCt) {
                if (S.charAt(begin) == '(')
                    openCt++;

                begin++;
            } else {
                if (S.charAt(end) == ')')
                    closeCt++;
                end--;
            }

            //if both are equal, equality must be at one to right
            if (openCt == closeCt)
                equalAt = end + 1;
        }
        return equalAt;
    }
}
