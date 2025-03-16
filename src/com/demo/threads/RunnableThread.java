package com.demo.threads;

/**
 * Steps :
 * <ol>
 *      <li>Must implement {@code run()} method</li>
 *      <li>Must pass {@code Runnable} object to new Thread</li>
 *      <li>Then {@code thread.start()}</li>
 * </ol>
 * <blockquote><pre>{@code
 *      class RunnableThread implements Runnable {
 *          @Override
 *          public void run(){
 *              System.out.println("thread is running...");
 *          }
 *      }
 *
 *      public static void main(String[] args) throws InterruptedException {
 *          RunnableThread runnableThread = new RunnableThread();
 *          Thread thread = new Thread(runnableThread);
 *          thread.start();
 *      }
 * }</pre></blockquote>
 */
public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("-- run() --");
    }

    public static void main(String[] args){
        RunnableThread r1 = new RunnableThread();
        Thread t1 = new Thread(r1);
        t1.start();
    }
}
