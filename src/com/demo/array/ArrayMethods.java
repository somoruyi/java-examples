package com.demo.array;

import java.util.Arrays;

public class ArrayMethods {

    /**
     * <h3>{@code Arrays}</h3>
     * {@code java.util.Arrays}
     * <ul>
     *     <li>Is a utility class ( <u>Note</u>: Utility classes typically only contain static methods )</li>
     *     <li>Used to manipulate, search, and sort through arrays</li>
     *     <li>Cannot instantiate the Arrays class because the constructor is private</li>
     *     <li>All methods are static</li>
     *     <li>Access Arrays by => {@code Arrays.sort(arr)}</li>
     * </ul>
     * @param args
     */

    public static void main(String[] args){
        int index = Arrays.binarySearch(new String[] {"Kyrie", "Lebron"} ,"Lebron");
        System.out.printf("index: %d", index); // print 1
    }
}
