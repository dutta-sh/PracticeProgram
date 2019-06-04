import java.util.ArrayList;
import java.util.List;

public class PrimeNNums {

    private static List<Integer> primes = new ArrayList<>();

    private static void getNPrimes(int n) {
        primes.add(2);

        int nextNum = 3;
        while(primes.size() < n) {
            boolean isPrime = true;
            for(int prime : primes) {
                int checkUpto = (int)Math.floor(Math.sqrt(nextNum));
                if(prime <= checkUpto && nextNum % prime == 0) {
                //if(nextNum % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primes.add(nextNum);
            }
            nextNum += 2;
        }
    }

    private static void getNPrimesRec(int n, int nextNum) {
        if(primes.size() == n)
            return;

        boolean isPrime = true;
        for(int prime : primes) {
            int checkUpto = (int)Math.floor(Math.sqrt(nextNum));
            if(prime <= checkUpto && nextNum % prime == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
            primes.add(nextNum);
        }

        getNPrimesRec(n, nextNum + 2);
    }

    public static void main(String[] args) {
        getNPrimes(20);

        //primes.add(2);
        //getNPrimesRec(20, 3);
        System.out.println(primes);
    }
}
