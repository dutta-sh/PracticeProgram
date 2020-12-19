package misc;

public class PrimeFactors {

    private static void primeFactors(int n) {
        while(n%2 == 0) {
            System.out.print(2 + ", ");
            n = n/2;
        }

        int f = 3;
        while(n != 1) {
            while(n%f == 0) {
                System.out.print(f + ", ");
                n = n/f;
            }

            f += 2;
        }
    }

    public static void main(String[] args) {
        primeFactors(315);
    }
}
