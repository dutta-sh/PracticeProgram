import java.io.*;
import java.util.*;

class FBBinarySearch {

    /*
    We have N different apps with different user growth rates. At a given time t, measured in days, the number of users using an app is g^t
    (for simplicity we'll allow fractional users), where g is the growth rate for that app. These apps will all be launched at the same time
    and no user ever uses more than one of the apps. We want to know how many total users there are when you add together the number of users from each app.
            After how many full days will we have 1 billion total users across the N apps?
            Signature
            int getBillionUsersDay(float[] growthRates)
    Input
1.0 < growthRate < 2.0 for all growth rates
1 <= N <= 1,000
    Output
    Return the number of full days it will take before we have a total of 1 billion users across all N apps.
    Example 1
    growthRates = [1.5]
    output = 52
    Example 2
    growthRates = [1.1, 1.2, 1.3]
    output = 79
    Example 3
    growthRates = [1.01, 1.02]
    output = 1047*/

    // Add any helper functions you may need here
    private float getUsers(float[] rates, int days) {
        float u = 0.0f;
        for(float rate : rates) {
            u += Math.pow(rate, days);
        }
        return u;
    }


    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        int days = 1;
        float users = getUsers(growthRates, days);

        while (users < 1000000000.0) {
            days = 2 * days;
            users = getUsers(growthRates, days);
        }

        int min = days / 2;
        int max = days;

        while (min < max) {
            int mid = (min + max) / 2;

            if(mid == min)
                return max;

            users = getUsers(growthRates, mid);
            if (users > 1000000000.0)
                max = mid;
            else
                min = mid;

            System.out.println(min + ":::" + max + ":::" + mid);
        }
        return min;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        int expected_1 = 79;
        int output_1 = getBillionUsersDay(test_1);
        check(expected_1, output_1);

        float[] test_2 = {1.01f, 1.02f};
        int expected_2 = 1047;
        int output_2 = getBillionUsersDay(test_2);
        check(expected_2, output_2);


        // Add your own test cases here

    }
    public static void main(String[] args) {
        new FBBinarySearch().run();
    }


    int getTotalTime(int[] arr) {
        // Write your code here

        List<Integer> list = new ArrayList<>();
        for(int a : arr) {
            list.add(a);
        }
        Collections.sort(list);

        int total = 0;
        int size = list.size();
        while(size > 1) {
            int sum = list.get(size - 1) + list.get(size - 2);
            total += sum;

            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size - 2; i++) {
                temp.add(list.get(i));
            }
            temp.add(sum);

            list = temp;
            size = list.size();
        }
        return total;
    }
}