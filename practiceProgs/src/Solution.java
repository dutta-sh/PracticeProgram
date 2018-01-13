public class Solution {

    public int solution(String S) {
        if (S.length() == 0)    //empty string
            return -1;

        int begin = 0;
        int end = S.length() - 1;
        int openCt = 0;
        int closeCt = 0;
        int equalAt = -1;

        //move one step from begin and one step from end until convergence
        //and check at every point if we have a ( or )
        while(begin <= end && begin < S.length() && end > 0) {
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
