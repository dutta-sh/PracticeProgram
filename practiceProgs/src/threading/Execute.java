package threading;

import java.util.Date;

public class Execute {

    public void doSomething() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": doing something" + new Date());
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ": done something" + new Date());

    }
}
