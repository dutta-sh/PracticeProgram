package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SafteyTest {

    ExecutorService e = Executors.newCachedThreadPool();

    SimpleClass sc = new SimpleClass();

    public void demo() {
        for(int j = 1; j <= 5; j++) {
            final int k = j;
            System.out.println(Thread.currentThread().getName() + ":::::" + k);
            e.submit(() -> sc.sampleMethod(k));

//            sc.sampleMethod(j);
        }

        //e.shutdown();
    }

    public static void main(String[] args) {
        SafteyTest st = new SafteyTest();
        st.demo();
    }
}

class SimpleClass {

    //private int j;

    public void sampleMethod(int k) {
        int j = 0;
        for(j = k; j < k+5; j++) {
            System.out.println(Thread.currentThread().getName() + ":::::" + j);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "===================================");
    }
}
