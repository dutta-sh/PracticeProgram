package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Shouvik on 7/2/2017.
 */
public class ProducerConsumerExample2 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.submit(() -> {
            int i = 0;
            while(true) {
                try {
                    queue.put(++i);
                    System.out.println("Produced " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.submit(() -> {
            while(true) {
                try {
                    System.out.println("Consumed " + queue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}