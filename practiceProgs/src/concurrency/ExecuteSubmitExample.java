package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Shouvik on 7/4/2017.
 */
public class ExecuteSubmitExample {
    public static void main(String[] args) {
        System.out.println("creating service");
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(() -> divideByZero());
        service.execute(() -> divideByZero());

        service.shutdown();


    }

    private static void divideByZero() {
        int a=4, b = 0;
        System.out.println("a and b="+a+":"+b);
        System.out.println("a/b:"+(a/b));
        System.out.println("Thread Name in Runnable after divide by zero:"+Thread.currentThread().getName());
    }
}
