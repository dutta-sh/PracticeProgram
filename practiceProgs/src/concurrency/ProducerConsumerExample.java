package concurrency;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();

        PC pc = new PC();
        pool.submit(() -> pc.produce());
        pool.submit(() -> pc.consume());
        //t1.join();
        //t2.join();

        pool.shutdown();
    }
}

class PC {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    public void produce() {
        int value = 0;
        while (true) {
            synchronized (this) {
                try {
                    if (list.size() == capacity)
                        wait();

                    System.out.println("Producer produced-" + ++value);
                    list.add(value);
                    notify();
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (this) {
                try {
                    if (list.size() == 0)
                        wait();

                    System.out.println("Consumer consumed-" + list.removeFirst());
                    Thread.sleep(1000);
                    notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}