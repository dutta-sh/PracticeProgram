package misc;

/**
 * Created by Shouvik on 7/5/2017.
 */
public class TryCatchExample {

    private static String getVal() {
        try {
            String str = "name";
            throw new Exception("My error");
        } catch (Exception e) {
            return "abcd";
        } finally {
            System.out.println("In finally");
            //return "xyz";
        }
    }

    public static void main(String[] args) {
        String val = getVal();
        System.out.println(val);
    }
}
