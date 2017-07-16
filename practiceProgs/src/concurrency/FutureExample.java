package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Shouvik on 7/2/2017.
 */
public class FutureExample {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<String>> names = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            names.add(pool.submit(() -> {
                System.out.println("Running in: "  + Thread.currentThread().getName());
                Thread.sleep(1000);
                return Thread.currentThread().getName();
            }));
        }

        System.out.println("all threads spawned");
        for(Future name : names) {
            System.out.print(name.isDone());
            System.out.println(":" + name.get());
        }

        pool.shutdown();
    }
}


