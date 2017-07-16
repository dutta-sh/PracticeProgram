package concurrency;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Shouvik on 7/2/2017.
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        PrinterQueue printerQueue = new PrinterQueue();
        for(int i = 0; i < 10; i++) {
            pool.submit(() -> {
                //System.out.println(new Date() + " Going to print doc for: " + Thread.currentThread().getName());
                printerQueue.printJob();
            });
        }

        pool.shutdown();
    }
}

class PrinterQueue {
    private final Semaphore semaphore = new Semaphore(3);

    public void printJob() {
        try {
            semaphore.acquire();
            System.out.println(new Date() + " Printing job started for " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(new Date() + " Printing job completed for " + Thread.currentThread().getName());
            semaphore.release();
        }
    }
}