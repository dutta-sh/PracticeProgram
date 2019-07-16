public class MulBitwise {

    public int mul(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        int val = 0;

        while(small != 0) {
//            if(small % 2 == 1) {
//                val += big;
//            }
//            small = small/2;
//            big = big << 1;

            if((small & 1) == 1) {
                val += big;
            }
            small = small >> 1;
            big = big << 1;
        }

        return val;
    }

    public static void main(String[] args) {
        MulBitwise mulBitwise = new MulBitwise();
        System.out.println(mulBitwise.mul(21, 5));
    }
}
