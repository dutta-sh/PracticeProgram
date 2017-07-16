package cs570;

/**
 * Created by Shouvik on 7/12/2017.
 */
public class Demo {

    public static void main(String[] args) {

        int i = 546;
        while(i != 0) {
            int remainder = i%10;
            i = i/10;
            System.out.print(remainder);
        }
    }
}
