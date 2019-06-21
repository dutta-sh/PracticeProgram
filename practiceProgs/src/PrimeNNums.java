import java.util.ArrayList;
import java.util.List;

public class PrimeNNums {

    private static List<Integer> primes = new ArrayList<>();

    private static void getNPrimes(int n) {
        int nextNum = 3;
        while(primes.size() < n) {
            boolean isPrime = true;
            int checkUpto = (int)Math.floor(Math.sqrt(nextNum));
            for(int prime : primes) {
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

    private static List<Integer> primesRec = new ArrayList<>();

    private static void getNPrimesRec(int n, int nextNum) {
        if(primesRec.size() == n)
            return;

        boolean isPrime = true;
        int checkUpto = (int)Math.floor(Math.sqrt(nextNum));
        for(int prime : primesRec) {
            if(prime <= checkUpto && nextNum % prime == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
            primesRec.add(nextNum);
        }

        getNPrimesRec(n, nextNum + 2);
    }

    public static void main(String[] args) {
        primes.add(2);
        getNPrimes(20);
        System.out.println(primes);

        primesRec.add(2);
        getNPrimesRec(20, 3);
        System.out.println(primesRec);
    }
}
