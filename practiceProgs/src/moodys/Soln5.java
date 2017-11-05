package moodys;

import java.util.Scanner;

public class Soln5 {

    static int playGame(String s, int[] arr) {
        char[] boxes = s.toCharArray();

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int[] arr = new int[n];
        int minCoins = Integer.MAX_VALUE;
        int minPos = 0;
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();

            if(minCoins > arr[i]) {
                minCoins = arr[i];
                minPos = i;
            }
        }
        int result = playGame(s, arr);
        System.out.println(result);
        in.close();
    }
}