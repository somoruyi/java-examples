package com.demo.ds;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * {@link Queue}{@code <T>} : FIFO, Similar to music in queue readyd to be played <p>
 * Classes
 * <ul>
 *     <li>{@link LinkedList}      : Standard Queue</li>
 *     <li>{@link PriorityQueue}   : Priority-based Queue</li>
 *     <li>{@link ArrayDeque}      : Limited-capacity Queue</li>
 *     </ul>
 * Methods
 * <ul>
 *     <li>{@code pop()}           : functions like a Stack (FILO)</li>
 *     <li>{@code push()}          : adds to the front of the ArrayDeque</li>
 *     <li>{@code peekFirst()}     : returns 1st element but doesn't remove it</li>
 *     <li>{@code peekLast()}      : returns but does not remove the last element</li>
 *     <li>{@code pollFirst()}     : returns 1st element & removes from the deque</li>
 *     <li>{@code pollLast()}      : returns last element & removes from the deque</li>
 *     <li>{@code addFirst()}      : adds element to the front of the ArrayDeque</li>
 *     <li>{@code addLast()}       : adds element to the back of the ArrayDeque</li>
 * </ul>
 * Additional
 * <ul>
 *     <li>{@link ArrayBlockingQueue}: class</li>
 *     <li>{@link BlockingQueue}: interface</li>
 * </ul>
 */

public class QueueP {

    public static Queue<List<String>> addData(){
        Queue<List<String>> myQueue = new LinkedList<>();
        myQueue.add(List.of("Lebron", "Kyrie"));
        myQueue.add(List.of("Lakers", "Mavs"));
        return myQueue;
    }

    public static void queueMethod1(){
        Queue<List<String>> myQueue = addData();
        System.out.println("queue: " + myQueue);

        /*---  remove() : If empty returns exception ---*/
        myQueue.remove();  // Removes Lebron & Kyrie
        myQueue.remove();  // Removes Lakers & Mavs
        System.out.println("remove(): " + myQueue);

        System.out.println("");
        myQueue = addData();
        System.out.println("queue: " + myQueue);

        /*---  poll() : If empty returns null ---*/
        myQueue.poll();
        System.out.println("poll(): " + myQueue);

        Queue<String> q = new LinkedList<>();

        List<String> l = new LinkedList<>();
    }
}
