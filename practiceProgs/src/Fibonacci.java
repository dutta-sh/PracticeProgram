public class Fibonacci {

    public static void main(String[] args) {
        int i = fn(8);
        System.out.println(i);
    }

    public static int fn(int i) {
        if(i <= 1) return i;
        return fn(i - 1) + fn(i - 2);
    }
}
