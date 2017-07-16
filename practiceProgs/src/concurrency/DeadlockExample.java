package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Shouvik on 7/2/2017.
 */
public class DeadlockExample {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        Lock a = new ReentrantLock();
        Lock b = new ReentrantLock();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        pool.submit(() -> {
            try {
                a.lock();
                System.out.println(Thread.currentThread().getId() + " Locked on A");
                Thread.sleep(1000);
                b.lock();
                System.out.println(Thread.currentThread().getId() + " Locked on B");
                b.unlock();
                a.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.submit(() -> {
            try {
                b.lock();
                System.out.println(Thread.currentThread().getId() + " Locked on B");
                Thread.sleep(1000);
                a.lock();
                System.out.println(Thread.currentThread().getId() + " Locked on A");
                a.unlock();
                b.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();
        System.out.println("Finished !!");
    }
}
