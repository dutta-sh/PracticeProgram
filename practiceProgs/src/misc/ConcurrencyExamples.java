package misc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrencyExamples {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        CountDownLatch latch = new CountDownLatch(3);
        Task t1 = new Task("t1", Arrays.asList(10, 20, 30, 40), latch);
        Task t2 = new Task("t2", Arrays.asList(50, 60, 70), latch);
        Task t3 = new Task("t3", Arrays.asList(80, 90, 100), latch);
        List<Task> tasks = Arrays.asList(t1, t2, t3);

        List<Future<Integer>> futures = executor.invokeAll(tasks);
        futures.get(1).cancel(true);
        int grandSum = 0;
        latch.await();
        System.out.println(Thread.currentThread().getName() + ": all threads finished");
        for(Future<Integer> f : futures) {
//            if(!f.isDone()) {
//                f.cancel(true);
//            }
           // if(f.isDone()) {
                grandSum += f.get(200, TimeUnit.MILLISECONDS);
            //}
        }

        System.out.println(Thread.currentThread().getName() + ": Final sum: " + grandSum);

        executor.shutdown();
    }
}

class Task implements Callable<Integer> {
    private final Object lock = new Object();
    private final String name;
    private final List<Integer> list;
    private final CountDownLatch latch;

    public Task(String name, List<Integer> list, CountDownLatch latch) {
        this.name  = name;
        this.list = list;
        this.latch = latch;
    }

    @Override
    public Integer call() {
        System.out.println(name + ": running task");
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            System.out.println(name + ": interrupted running");
            e.printStackTrace();
        }
        int sum;
        synchronized(lock) {
            sum = list.stream().mapToInt(Integer::intValue).sum();
            System.out.println(name + ": sum of " + list + " is " + sum);
            latch.countDown();
            System.out.println(name + ": remaining latch count: " + latch.getCount());
            System.out.println(name + ": finished running");
        }
        return sum;
    }
}
