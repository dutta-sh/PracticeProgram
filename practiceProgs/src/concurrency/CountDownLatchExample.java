package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shouvik on 7/2/2017.
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(5);

        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getId() + "::: Initializing"));

        for(int i = 0; i < 10; i++) {
            int id = i;
            //pool.submit(t1);
            pool.submit(() -> {
                try {
                    System.out.println("Initializing service: " + id);
                    //Thread.sleep(1000);
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        latch.await(2000, TimeUnit.MILLISECONDS);
        System.out.println("All are ready !!!");
        pool.shutdown();

    }
}
