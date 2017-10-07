package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            String seq = s.split(",")[0];
            String subSeq = s.split(",")[1];

            System.out.println(count(seq, seq.length(), subSeq, subSeq.length()));
        }
    }

    public static int count(String a, int aLen, String b, int bLen) {
        //if only first string is empty return 0
        if (aLen == 0 && bLen != 0)
            return 0;

        //if both are empty or second is empty, return 1
        if ((aLen == 0 && bLen == 0) || bLen == 0)
            return 1;

        //if last chars are same recursive for remaining strings by
        //consider last chars of both strings and ignore last char of first string
        if (a.charAt(aLen - 1) == b.charAt(bLen - 1))
            return count(a, aLen - 1, b, bLen - 1) + count(a, aLen - 1, b, bLen);
        else
            //if last chars are diff, ignore last char of first and recur for rest
            return count(a, aLen - 1, b, bLen);
    }
}
