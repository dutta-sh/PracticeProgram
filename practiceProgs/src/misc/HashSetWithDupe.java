package misc;

import java.util.HashSet;

public class HashSetWithDupe {

    public static void main(String[] args) {
        HashSet set = new HashSet<>();

        Object p1 = new Person("Moon");
        Object p2 = new Person("Moon");

        System.out.println("equals ==> " + p1.equals(p1));
        System.out.println("===========================");

        set.add(p1);
        set.add(p2);
        set.add(p1);

        for(Object p : set) {
            System.out.println(p);
        }
    }

    static class Person {
        private String name;

        private Person(String name) {
            this.name = name;
        }

        public int hashCode() {
            System.out.println(name.hashCode());
            return name.hashCode();
        }

        public boolean equals(Object o) {
            System.out.println("::::" + o);
            return false;
        }

        public String toString() {
            return name;
        }
    }
}
