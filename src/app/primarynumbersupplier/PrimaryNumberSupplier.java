package app.primarynumbersupplier;

import app.primarynumberworkers.Worker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ajoshi on 21-Nov-16.
 */
public class PrimaryNumberSupplier {
    private final static int THREAD_NUMBER = 4;

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(THREAD_NUMBER);
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUMBER);
        List<Future<BigInteger>> results = new ArrayList<>();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            results.add(pool.submit(new Worker(latch)));
        }
        try {
            latch.await();
            for (Future<BigInteger> result : results) {
                BigInteger bigInteger = result.get();
                System.out.println(bigInteger);
            }
            pool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
