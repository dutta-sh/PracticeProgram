package threading;

import java.util.Date;

public class MyMain {

    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new ExtendThread();
//        t1.start();

        Thread t2 = new ExtendActualThread();
        t2.setName("moon");
        t2.start();
        Thread.sleep(1000);
        new Execute().doSomething();

        Thread t3 = new Thread(() -> {
            Execute ex = new Execute();
            try {
                ex.doSomething();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.setName("mampa");
        t3.start();

    }
}