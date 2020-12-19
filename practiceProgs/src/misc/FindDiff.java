package misc;

/**
 * Having an array of integers and a number X,
 * find all pairs of integers in the array which
 * have a difference equal to the number X.
 */
public class FindDiff {

    public static void main(String[] args) {
        int x = 10;

        //works for all numbers
        //time complexity O(n^2)
        int[] dataArr = new int[]{100, 80, 60, 45, 70, 25, 20, 10, 15, 40, -10, 0, -20};
        for(int i = 0; i < dataArr.length; i++) {
            for(int j = i+1; j < dataArr.length; j++) {
                if(dataArr[i] - dataArr[j] == x)
                    System.out.println(dataArr[j] + " ::: " + dataArr[i]);
                if(dataArr[j] - dataArr[i] == x)
                    System.out.println(dataArr[i] + " ::: " + dataArr[j]);
            }
        }

        System.out.println("-------------------------------------------");

        //works for non-negative numbers only
        //time complexity O(n)
        dataArr = new int[]{100, 80, 60, 45, 70, 25, 20, 10, 15, 40, 0};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < dataArr.length; i++) {
            if(dataArr[i] >= max)
                max = dataArr[i];
            if(dataArr[i] <= min)
                min = dataArr[i];
        }
        boolean[] marker = new boolean[max + 1];

        for(int i = 0; i < dataArr.length; i++) {
            if(dataArr[i] - x >= min && marker[dataArr[i] - x])
                System.out.println((dataArr[i] - x) + " ::: " + dataArr[i]);
            if(dataArr[i] + x <= max && marker[dataArr[i] + x])
                System.out.println(dataArr[i] + " ::: " + (dataArr[i] + x));

            marker[dataArr[i]] = true;
        }
    }
}
