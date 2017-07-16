package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Shouvik on 7/2/2017.
 */
public class CyclicBarrierExample {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("All are ready !!!"));

        for(int i = 0; i < 10; i++) {
            int id = i;
            pool.submit(() -> {
                try {
                    System.out.println("Running service: " + id);
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                    System.out.println("Crossed barrier service: " + id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
    }
}
