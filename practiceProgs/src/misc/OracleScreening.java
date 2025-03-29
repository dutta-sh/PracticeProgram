package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// # You need to design a lightweight task scheduler in Java that:
// # 	•	Runs multiple scheduled tasks at specified time intervals.
// # 	•	Allows tasks to be added dynamically.
// # 	•	Ensures thread safety while running tasks concurrently.
// # 	•	Prevents tasks from overlapping if they are already running.

// # TaskScheduler scheduler = new TaskScheduler();
// # scheduler.schedule("task1", () -> System.out.println("Running Task 1"), 5, TimeUnit.SECONDS);
// # scheduler.schedule("task2", () -> System.out.println("Running Task 2"), 10, TimeUnit.SECONDS);

// # // Later, remove task1
// # scheduler.cancel("task1");

// # Requirements
// # 	1.	Tasks must run asynchronously on multiple threads.
// # 	2.	If a task is already running, don’t start another instance of it.
// # 	3.	Tasks should be cancellable.
// # 	4.	Should not block the main thread while executing tasks.
// # 	5.	Should handle concurrency properly (i.e., no race conditions).

public class OracleScreening {
    private List<Taskable> taskList = new ArrayList<>();
    private final int MAX_POOL_COUNT = 10;
    //private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(MAX_POOL_COUNT);
    private ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(MAX_POOL_COUNT);

    public void triggerAllTasks() {
        taskList.forEach(t -> scheduler.schedule(t, 5, TimeUnit.SECONDS));
    }

    public void triggerTask(int listIndex) {
        scheduler.schedule(taskList.get(listIndex), 5, TimeUnit.SECONDS);
    }

    public void addTask(Taskable t) {
        taskList.add(t);
    }

    public void cancelTask(Taskable t) {
        scheduler.remove(t);
    }

    public void stopSechduler() {
        scheduler.shutdown();
    }

    public static void main(String[] args) {
        Taskable t1 = new Taskable("t1");
        Taskable t2 = new Taskable("t2");
        Taskable t3 = new Taskable("t3");

        OracleScreening myScheduler = new OracleScreening();
        // myScheduler.addTask(t1);
        // myScheduler.addTask(t2);
        // myScheduler.addTask(t2);
        myScheduler.addTask(t3);

        myScheduler.triggerAllTasks();

        myScheduler.cancelTask(t3);


        // myScheduler.addTask(new Task("t4"));
        // myScheduler.triggerTask(4);

        myScheduler.stopSechduler();
        System.out.println("finish main");
    }
}



class Taskable implements Runnable {
    private Object lock = new Object();
    private final String name;

    public Taskable(String name) {
        this.name  = name;
    }

    @Override
    public void run() {
        synchronized(lock) {
            System.out.println("running task: " + name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.out.println("interrupted running " + name);
                // e.printStackTrace();
            }
            System.out.println("finished running " + name);
        }
    }
}