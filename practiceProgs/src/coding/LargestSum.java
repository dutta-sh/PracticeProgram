package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LargestSum {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            String[] numStrs = s.split(",");
            List<Integer> nums = new ArrayList<>();
            for(String numStr : numStrs) {
                nums.add(Integer.parseInt(numStr));
            }

            for(Integer num : nums) {

            }
        }
    }
}
