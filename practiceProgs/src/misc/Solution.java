package misc;

import java.util.*;

//public class misc.Solution {
//
//    public int solution(String S) {
//        if (S.length() == 0)    //empty string
//            return -1;
//
//        int begin = 0;
//        int end = S.length() - 1;
//        int openCt = 0;
//        int closeCt = 0;
//        int equalAt = -1;
//
//        //move one step from begin and one step from end until convergence
//        //and check at every point if we have a ( or )
//        while(begin <= end && begin < S.length() && end > 0) {
//            if (openCt <= closeCt) {
//                if (S.charAt(begin) == '(')
//                    openCt++;
//
//                begin++;
//            } else {
//                if (S.charAt(end) == ')')
//                    closeCt++;
//                end--;
//            }
//
//            //if both are equal, equality must be at one to right
//            if (openCt == closeCt)
//                equalAt = end + 1;
//        }
//        return equalAt;
//    }
//}

//import java.util.*;
//
//class misc.Solution {
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        List<List<Integer>> results = new ArrayList<>();
//        recur(1, new ArrayList<Integer>(), results, k, n);
//        return results;
//    }
//
//    public void recur(int numStart, List<Integer> temp, List<List<Integer>> results, int k, int n) {
//        if(n == 0) {
//            results.add(new ArrayList<>(temp));
//        }
//
//        // if(temp.size() >= k)
//        //     return;
//
//        for(int i = numStart; i <= 9; i++) {
//            if(i <= n) {
//                temp.add(i);
//                System.out.println(temp);
//                recur(i + 1, temp, results, k, n - i);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        misc.Solution s = new misc.Solution();
//        s.combinationSum3(3, 7);
//    }
//}

class Solution {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int j = 1;
        int sum = nums[0];
        System.out.println(nums.length);
        while(j < nums.length) {
            sum += nums[j++];
            //System.out.println((j-1) + ":" + sum);
            if(isConditionSatisfied(k,sum))
                return true;
        }

        j = 0;
        while(j < nums.length - 2) {
            sum -= nums[j++];
            System.out.println((j-1) + "::" + sum);
            if(isConditionSatisfied(k,sum))
                return true;
        }

        ////////////////

        int left = 0;
        int right=1;

        while (right<nums.length) {
            sum += nums[right];
            int temp = sum;
            if(isConditionSatisfied(k,sum)){
                return true;
            }

            while (right - left > 1) {
                sum -=nums[left];
                left++;
                if(isConditionSatisfied(k,sum)){
                    return true;
                }
            }
            left = 0;//rest left and temp as there are negative numbers and condition is atleast 2 elements
            sum = temp;
            right++;
        }
        return false;
    }

    public static boolean isConditionSatisfied(int k, int sum ){
        if(k == 0 && sum == 0)
            return true;
        if(k != 0 && sum % k == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{18,373,97,499,525,170,133,376,77,279,257,168,319,335,237,36,236,41,360,131,172,279,405,
                236,296,377,348,411,135,411,273,230,103,274,211,427,101,243,31,485,282,40,28,81,6,318,502,521,140,110,
                467,248,404,107,108,129,113,113,333,83,242,194,112,446,463,102,145,107,73,47,53,455,301,150,314,13,180,
                119,234,509,199,503,69,224,228,427,309,497,342,329,518,35,425,343,417,509,85,234,426,334};

        System.out.println(checkSubarraySum(nums, 250));
    }
}