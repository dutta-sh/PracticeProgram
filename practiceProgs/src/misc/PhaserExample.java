package misc;

import java.util.concurrent.Phaser;

class Task2 implements Runnable {
    private final Phaser phaser;
    private final String name;

    public Task2(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println(name + " started phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // Wait for all threads to reach this phase

        System.out.println(name + " completed phase " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Register the main thread

        Thread task1 = new Thread(new Task2(phaser, "Task 1"));
        Thread task2 = new Thread(new Task2(phaser, "Task 2"));
        Thread task3 = new Thread(new Task2(phaser, "Task 3"));

        task1.start();
        task2.start();
        task3.start();

        phaser.arriveAndAwaitAdvance(); // Wait for all tasks to complete phase 0
        System.out.println("All tasks completed phase 0");

        phaser.arriveAndDeregister();
    }
}
