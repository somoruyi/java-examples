package com.demo.concurrency;


import java.util.concurrent.*;
/**
 * <ul>
 *     <li>corePoolSize</li>
 *     <li>maxPoolSize</li>
 *     <li>keepAliveTime</li>
 *     <li>TimeUnit.Seconds</li>
 *     <li>new {@link ArrayBlockingQueue}<>(128)</li>
 * </ul>
 *
 * ScheduleExecutorService extends ExecutorService - allows you to schedule takes for the future
 */

public class ConcurrencyAdvanced {

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(1,2,1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(128));
    }
}
