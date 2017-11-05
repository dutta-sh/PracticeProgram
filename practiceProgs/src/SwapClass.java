public class SwapClass {

    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 20;
        swap(i, j);
        System.out.println(i);
        System.out.println(j);

        MyCustom c1 = new MyCustom(10);
        MyCustom c2 = new MyCustom(20);
        swap(c1, c2);
        System.out.println(c1);
        System.out.println(c2);
    }

    public static void swap(Integer x, Integer y) {
        Integer temp = x;
        x = y;
        y = temp;
    }

    public static void swap(MyCustom x, MyCustom y) {
        MyCustom temp = x;
        x = y;
        y = temp;
    }
}

class MyCustom {
    private Integer a;

    public MyCustom(Integer a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "MyCustom{" + "a=" + a + '}';
    }
}
