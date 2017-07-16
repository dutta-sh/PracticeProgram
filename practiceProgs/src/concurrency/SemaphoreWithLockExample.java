package concurrency;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Shouvik on 7/2/2017.
 */
public class SemaphoreWithLockExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        MultiplePrinterQueue printerQueue = new MultiplePrinterQueue();
        for(int i = 0; i < 10; i++) {
            pool.submit(() -> {
                System.out.println(new Date() + " Going to print doc for: " + Thread.currentThread().getName());
                printerQueue.printJob();
            });
        }

        pool.shutdown();
    }
}

class MultiplePrinterQueue {
    private final Semaphore semaphore = new Semaphore(3);
    private final Lock printerLock = new ReentrantLock();
    private boolean freePrinters[] = new boolean[]{true, true, true};

    public void printJob() {
        try {
            semaphore.acquire();
            int assigned = getPrinter();
            System.out.println(new Date() + " Printing job started on " + assigned + " for " + Thread.currentThread().getName());
            Thread.sleep(2000);
            releasePrinter(assigned);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(new Date() + " Printing job completed for " + Thread.currentThread().getName());
            semaphore.release();
        }
    }

    private int getPrinter() {
        int foundPrinter = -1;
        try {
            printerLock.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    foundPrinter = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printerLock.unlock();
        }
        return foundPrinter;
    }

    private void releasePrinter(int i) {
        printerLock.lock();
        freePrinters[i] = true;
        printerLock.unlock();
    }
}