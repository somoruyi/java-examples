package com.demo.threads;
import java.lang.*;

public class ThreadP{

    public static void main(String[] args){

        Thread t1 = new Thread();
        t1.start();

    }
}
/**
 * ???
 */
class ExtendingThread extends Thread{

    /**
     * It is common practice to @Override the run method
     */
    @Override
    public void run(){
        System.out.println("-- run() --");
        System.out.println("Thread Name:\t" + Thread.currentThread().getName());
        System.out.println("Thread Priority:\t" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args){
        System.out.println("-- Extending Thread --");
        System.out.println("Thread Name:\t" + Thread.currentThread().getName());
        System.out.println("Thread Priority:\t" + Thread.currentThread().getPriority());
        ExtendingThread t1 = new ExtendingThread();
        ExtendingThread t2 = new ExtendingThread();
        t1.start();
        t2.start();
    }
}
