package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            String numbers = s.split(";")[0];
            String kStr = s.split(";")[1];
            String[] numStrs = numbers.split(",");

            //ensure k is integer
            int k = Integer.parseInt(kStr);
            if(k <=0) throw new Exception("k is not a positive integer " + k);

            //ensure numbers are integers
            Integer[] nums = new Integer[numStrs.length];
            for(int i = 0; i < numStrs.length; i++) {
                nums[i] = Integer.parseInt(numStrs[i]);
            }

            //how many full iterations
            int iterations = nums.length/k;

            StringBuilder strBld = new StringBuilder();

            //print each loop backwards
            for(int i = 1; i <=iterations; i++) {
                int startPos = (k * i) - 1;
                int endPos = k * (i - 1);
                for(int j = startPos; j >= endPos; j--) {
                    strBld.append(numStrs[j]).append(",");
                }
            }

            //print remainder as it is
            int remainder = nums.length%k;
            if(remainder != 0) {
                for(int j = iterations * k; j < nums.length; j++) {
                    strBld.append(numStrs[j]).append(",");
                }
            }

            String finalStr = strBld.toString().substring(0, strBld.toString().length() - 1);
            System.out.println(finalStr);
        }
    }
}