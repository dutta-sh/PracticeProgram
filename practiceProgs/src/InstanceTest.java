import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shouvik on 7/30/2017.
 */
public class InstanceTest {

    public static void main(String[] args) {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("shouvik"));
//        checkInstance(employees);

        List<String> abcd = new ArrayList();
        abcd.add("moon");
        checkInstance(abcd);

    }

    private static void checkInstance(Object o) {
        if(o instanceof List) {
            System.out.println("Type is list");
            List oList = (List)o;
            if(!oList.isEmpty() && oList.get(0) instanceof Employee)
                System.out.println("Type is employee");
        }

        List<Integer> e = (List<Integer>) o;
        System.out.println(e);
        System.out.println(e.get(0).toString());
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}