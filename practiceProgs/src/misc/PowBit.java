package misc;

import java.util.ArrayList;
import java.util.List;

public class PowBit {

    public float pow(int base, int power) {
        List<Integer> bases = new ArrayList<>();

        boolean isNeg = false;
        if(power < 0) {
            power = -1*power;
            isNeg = true;
        }

        while(power != 0) {
            if((power & 1)  == 1) {
                bases.add(base);
            }
            base = base * base;
            power = power >> 1;
        }

        float mul = 1;
        for(int val : bases) {
            mul *= val;
        }

        return !isNeg ? mul : 1/mul;
    }

    public static void main(String[] args) {
        PowBit powBit = new PowBit();
        System.out.println(powBit.pow(2, -2));
    }
}
