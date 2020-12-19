package misc;

import java.util.Arrays;

public class PrimesTillN {

    private static void printPrimesTillN(int n) {
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i*i <= n; i++) {
            if(prime[i]) {
                int j = 2*i;
                while(j <= n) {
                    prime[j] = false;
                    j += i;
                }
            }
        }

        int ct = 0;
        for(int i = 1; i <=n; i++) {
            if(prime[i]) {
                ct++;
                System.out.print(i + ", ");
            }
        }
        System.out.println("\r\nTotal primes: " + ct);
    }

    public static void main(String[] args) {
        printPrimesTillN(400000);
    }
}
