package misc;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Threading {

    public static void main(String[] args) {

        PC pc = new PC();
        Executor ex = Executors.newFixedThreadPool(2);
        ex.execute(() -> pc.produce());
        ex.execute(() -> pc.consume());
    }
}

class PC {
    private LinkedList<Integer> queue = new LinkedList<>();
    private int i = 0;
    private int capacity = 5;

    public void produce() {
        synchronized (this) {
            while(true) {
                while(queue.size() == capacity) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println("Producing " + i);

                queue.add(i);
                notifyAll();;
            }

        }
    }

    public void consume() {
        synchronized (this) {
            while(true) {
                while(queue.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming: "  + queue.removeFirst());
                notifyAll();
            }
        }
    }
}
