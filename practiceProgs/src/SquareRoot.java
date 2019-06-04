public class SquareRoot {


    public static void main(String[] args) {
        int num = 125;
        System.out.println(sqrt(num, 1, num/2));
    }

    private static int sqrt(int n, int l, int r) {
        if(l > r)
            return r;

        int mid = l + (r-l)/2;

        if(mid*mid == n)
            return mid;
        if(mid*mid > n)
            return sqrt(n, l, mid - 1);
        else
            return sqrt(n,mid + 1, r);
    }

}
