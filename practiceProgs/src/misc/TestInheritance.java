package misc;

public class TestInheritance {

    public static void main(String args[]) {
        ClassB b = new ClassB();
    }
}


class ClassA {

    public ClassA(int i) {
        System.out.println("in parent");
    }
}

class ClassB extends ClassA {

    public ClassB() {
        super(100);
        System.out.println("in child");
    }
}