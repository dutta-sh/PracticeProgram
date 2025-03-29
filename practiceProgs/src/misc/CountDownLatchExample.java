package misc;

import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final int id;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal, int id) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.id = id;
    }

    public void run() {
        try {
            startSignal.await(); // Wait for the signal to start
            doWork();
            doneSignal.countDown(); // Signal that task is done
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    void doWork() {
        System.out.println("Worker " + id + " is working");
        // Simulate work
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Worker " + id + " is done");
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numWorkers = 3;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numWorkers);

        for (int i = 1; i <= numWorkers; i++) {
            new Thread(new Worker(startSignal, doneSignal, i)).start();
        }

        System.out.println("Starting workers");
        startSignal.countDown(); // Signal all workers to start

        doneSignal.await(); // Wait for all workers to finish
        System.out.println("All workers finished");
    }
}