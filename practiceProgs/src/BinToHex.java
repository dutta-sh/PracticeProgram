/**
 * Created by Shouvik on 7/14/2017.
 */
public class BinToHex {

    public static void main(String[] args) {
        System.out.println("AB".hashCode()); //c[0]*31^(n-1) + c[1]*31^(n-2).....+ c[n-2]*31^(1) + c[n-1]*31^(0)

        String binary ="1111";
        String hex = "F";

        int n1 = convertToBase(binary, 2);
        int n2 = convertToBase(hex, 16);
        if (n1 < 0 || n2 < 0) {
            System.out.println(binary + " and " + hex + " are not same");
        } else {
            System.out.println(binary + " and " + hex + " are same:" + n1);
        }
    }


    public static int digitToValue(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        else if (c >= 'A' && c <= 'F') return 10 + c - 'A';
        else if (c >= 'a' && c <= 'f') return 10 + c - 'a';
        return -1;
    }

    public static int convertToBase(String number, int base) {
        if (base < 2 || (base > 10 && base != 16)) return -1;
        int value = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = digitToValue(number.charAt(i));
            if (digit < 0 || digit >= base) {
                return -1;
            }
            int exp = number.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }
}
