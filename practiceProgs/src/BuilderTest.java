/**
 * Created by Shouvik on 7/5/2017.
 */
public class BuilderTest {
    public static void main(String[] args) {
        MyVO myVO = MyVO.builder().name("Shouvik").age(10).build();
        System.out.println(myVO);
    }
}

class MyVO {
    private final String name;
    private final Integer age;

    private MyVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + "/" + age;
    }

    public static MyVOBuilder builder() {
        return new MyVOBuilder();
    }

    public static class MyVOBuilder {
        private String name;
        private Integer age;

        public MyVOBuilder name(String name){
            this.name = name;
            return this;
        }

        public MyVOBuilder age(Integer age){
            this.age = age;
            return this;
        }

        public  MyVO build() {
            return new MyVO(name, age);
        }
    }
}