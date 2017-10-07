import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumberGenerator {
    private static Map<Integer, String> numNameMap = new HashMap();
    private static Map<Integer, String> numPosnMap = new HashMap();
    private static Map<Integer, String> posPosnMap = new HashMap();
    private static StringBuilder strBld = new StringBuilder();

    public static void numNames() {
        numNameMap.put(1, "One");numNameMap.put(2, "Two");numNameMap.put(3, "Three");
        numNameMap.put(4, "Four");numNameMap.put(5, "Five");numNameMap.put(6, "Six");
        numNameMap.put(7, "Seven");numNameMap.put(8, "Eight");numNameMap.put(9, "Nine");
        numNameMap.put(0, "Zero");
    }

    public static void posnNames() {
        numPosnMap.put(1, "");
        numPosnMap.put(2, "-ty");
        numPosnMap.put(0, " hundred");
    }

    public static void posnPosn() {
        posPosnMap.put(0, "");
        posPosnMap.put(1, " thousand");
        posPosnMap.put(2, " million");
        posPosnMap.put(3, " billion");
        posPosnMap.put(4, " trillion");
    }


    public static void main(String[] args) {
        numNames();
        posnNames();
        posnPosn();

        getNum(1234567899);
        System.out.println(strBld.toString());
    }

    public static void getNum(int num) {
        Stack<Integer> numStack = new Stack<>();
        while(num != 0) {
            int mod = num%10;
            numStack.push(mod);
            num = num/10;
        }

        while(!numStack.empty()) {
            int pos = numStack.size();
            int val = numStack.pop();
            if(val != 0) {
                strBld.append(numNameMap.get(val)).append(numPosnMap.get(pos%3)).append(" ");
                pos = numStack.size();
                if(pos%3 == 0) {
                    strBld.append(posPosnMap.get(pos/3)).append(" ");
                }
            }
        }
    }
}
