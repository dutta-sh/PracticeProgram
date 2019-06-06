public class Kadane {

    public static void main (String[] args)
    {
        int [] a = {-2, -3, -1, -2, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

    static int maxSubArraySum(int[] array) {
        // Write your code here.
        int maxHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for(int num : array) {
            if(num > maxHere + num)
                maxHere = num;
            else
                maxHere += num;

            if(maxHere > maxSoFar)
                maxSoFar = maxHere;
        }

        return maxSoFar;
    }
}
