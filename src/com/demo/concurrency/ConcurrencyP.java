package com.demo.concurrency;

import com.demo.utils.Colors;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h3>Executor Framework</h3>
 * 1. Executors {@code (class)}
 * <p>
 * 2. Executor {@code (interface)}
 * <p>
 * 3. ExecutorService {@code (interface)}
 * <p>
 * <pre> {@link ExecutorService}{@code es = Executors.newFixedThreadPool(2)} </pre>
 * <ul>
 *     <li>pool-1-thread-1</li>
 *     <li>pool-1-thread-2</li>
 * </ul>
 * <pre> {@code
 *      ExecutorService es1 = Executors.newFixedThreadPool(1);
 *      ExecutorService es2 = Executors.newFixedThreadPool(1);
 * }</pre>
 * <ul>
 *     <li>pool-1-thread-1</li>
 *     <li>pool-2-thread-1</li>
 * </ul>
 *
 * {@code es.execute(Runnable r1)} – This method <u>does not return any result</u> or future object.
 * It is a void method, so you cannot obtain the result of the task or
 * check if the task completed successfully.
 * <p>
 *
 * {@code es.submit(Runnable r1)} – This method <u>returns a Future object</u>, which can be used to
 * check the status of the submitted task, cancel the task, or retrieve the
 * result when it's available.
 * <p>
 *
 * {@code es.shutdown()} – Attempting to submit a new task after shutdown will result in a
 * RejectedExecutionException. Place outside of loop.
 */
public class ConcurrencyP {
    public static int counter = 0;
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args){
        ExecutorService es1 = Executors.newFixedThreadPool(2);
        ExecutorService es2 = Executors.newFixedThreadPool(2);
        for(int i=0; i<6; i++) {
            es1.execute(
                    () -> {
                        method1();
                    }
            );
            es2.execute(
                    () -> {
                        try {
                            method2();
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }
        es1.shutdown();
        es2.shutdown();
    }

    public static void method1(){
        ExecutorService es1 = Executors.newFixedThreadPool(2);

        // thread-1 will not return anything
        es1.execute(() -> {
            System.out.println("es1: " + Thread.currentThread().getName());
            try {
                method3(Colors.ANSI_RED, Colors.ANSI_RESET);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Shutdown the executor service outside the loop
        es1.shutdown();
    }

    /**
     * This method2 uses :
     *     <ol>
     *        <li>{@code Callable<String>}</li>
     *        <li>{@code submit(c1)}</li>
     *        <li>{@code Future<String>}</li>
     *     </ol>
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void method2() throws ExecutionException, InterruptedException {
        ExecutorService es2 = Executors.newFixedThreadPool(4);

        // thread-2 will return a future
        Future<String> future = es2.submit(() -> {
            // This is a Callable<String> block of code
            System.out.println("es2: " + Thread.currentThread().getName());
            method3(Colors.ANSI_GREEN, Colors.ANSI_RESET);
            return "Task is complete";
        });

        String result = future.get(); // adds exception
        System.out.println(result + "\n");

        // Shutdown the executor service outside the loop
        es2.shutdown();
    }

    /**
     * Lock - The Lock interface provides an alternative to the synchronized keyword <p>
     * ReentractLock - The ReentractLock class implements ؘa Lock interface. <p>
     *     <ol>
     *         <li>obj.lock - Access is locked</li>
     *         <li>obj.unlock - The lock will be released</li>
     *     </ol>
     */
    public static void method3(String color, String reset) throws InterruptedException {
        // Creating a ReentrantLock
        System.out.println(color + "Lock Status: " + lock.tryLock() + reset);

        // Acquiring the lock
        lock.lock();

        try {
            // Your critical section (code that needs to be synchronized)
            System.out.println(color + "Inside the critical section: " + counter++ + reset);
            //Thread.sleep(200);
        } finally {
            // Releasing the lock in a finally block to ensure it's released even if an exception occurs
            lock.unlock();
        }
    }

}
