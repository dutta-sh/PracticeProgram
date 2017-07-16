import java.util.Scanner;

/**
 * Write me a program that that accepts an array of integers,
 * and prints out the pairs of these integers that sum to 7.
 * For example, If the input is [1, 2, 3, 4, 5, 6], the output could be
 * (1,6), (2, 5), (3, 4), or (6,1), (5, 2), (4,3).
 * Different combinations of the same pair of numbers
 * e.g, (1, 6) and (6, 1) are not distinct.
 */
public class NumberSum {
    public static void main(String[] args) {
        System.out.println("Enter the numbers as csv (no spaces):");
        Scanner in  = new Scanner(System.in);
        String input = in.next();

        String[] numStr = input.split(",");
        int[] dataArr = new int[numStr.length];
        for(int i = 0; i < numStr.length; i++) {
            dataArr[i] = Integer.parseInt(numStr[i]);
        }

        int sum = 7;
        //int[] dataArr = new int[]{10, 2, 5, 7, 3, 9, 4, 1, 0, 6};
        System.out.println("Looking for pairs whose sum is: " + sum);

        printPairs(dataArr, sum);
        System.out.println("-------------------------------------------");
        printPairs2(dataArr, sum);

    }

    //works for non-negative numbers only
    //time complexity O(n)
    private static void printPairs(int[] dataArr, int sum) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dataArr.length; i++) {
            if(dataArr[i] >= max)
                max = dataArr[i];
        }

        boolean[] marker = new boolean[max + 1];
        for(int i = 0; i < dataArr.length; i++) {
            marker[dataArr[i]] = true;
        }

        for(int i = 0; i < dataArr.length; i++) {
            if(sum - dataArr[i] >=0 && sum - dataArr[i] <= max && marker[sum - dataArr[i]])
                System.out.println(dataArr[i] + " ::: " + (sum - dataArr[i]));
        }
    }

    //works for all numbers
    //time complexity O(n^2)
    private static void printPairs2(int[] dataArr, int sum) {
        for(int i = 0; i < dataArr.length; i++) {
            for(int j = 0; j < dataArr.length; j++) {
                if(sum - dataArr[i] == dataArr[j])
                    System.out.println(dataArr[i] + " ::: " + dataArr[j]);
            }
        }
    }
}
