import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    public static void main(String[] args) {
        List<MyObject> objs = Arrays.asList(new MyObject("xyz"), new MyObject("abc"), new MyObject("def"));
        Collections.sort(objs);
        System.out.println(objs);
    }
}

class MyObject implements Comparable {

    String str;

    public MyObject(String str) {
        this.str = str;
    }

    @Override
    public int compareTo(Object o) {
        MyObject o1 = (MyObject)o;
        return str.compareTo(o1.str);
    }

    @Override
    public String toString() {
        return "MyObject{" + "str='" + str + '\'' + '}';
    }
}