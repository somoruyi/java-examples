package com.demo.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Practice2 {
    //  Problem 1 : Return the smallest positive integer
    /*  --------------------------
        A.  Given an array A of N integers, returns the smallest positive
            integer (greater than 0) that does not occur in A.
     */
    public static int solution(int[] A){ // 1, 2, 3
        int n = A.length;
        boolean[] seen = new boolean[n+1]; // initialize boolean array

        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n) { // only mark values that are within [1, n]
                /* If A[I] is in the range  A[i] = value  becomes seen[value]  */
                int value = A[i];
                seen[value] = true; // The value will be the index of seen
            }
        }

        for (int i = 1; i <= n; i++) { // find the first missing positive value
            if (!seen[i]) { // Finds any value that is still false
                return i;
            }
        }

        return n+1; // if all positive values are seen, the answer is n+1
    }
    public static int solutionD(int[] D){
        // D = 5, 3, 6, 4, 7, 8
        // Returns 2
        // Create an array to store values will set all to false and check 1-max_length values
//        int[] D = new int[]{1, 2, 3,4};
        boolean[] E = new boolean[D.length+1]; // by default all are false

        // Edge cases
        // Array values cannot be more than length of array D
        // If you check every value and all are there allocate for N+1 to be the answer
        // check if value is greater than 0
        // check if value is less than or equal to max length
        // return true in the index of that number
        // check for false, if none return max_length + 1

//        System.out.println("E: " + Arrays.toString(E));
//        System.out.println("D Length: " + D.length);
        for(int i = 0; i < D.length ; i++){
//            System.out.println("D[i]: " + D[i]);
            if(D[i] > 0 && D[i] <= D.length){
//                System.out.println("D: " + D[i]);
                E[D[i]] = true;
//                break;
            }
        }
        boolean value = true;
        int n = 1;
        for(int i = 1; i < E.length ; i++){
            if(E[i] == false){
//                System.out.println("i: " + i);
                n = i;
                value = E[i];
                break;
            }
        }
        if(value == true){
//            System.out.println("N+1: " + (D.length+1));
        }

//        System.out.println("E: " + Arrays.toString(E));
        return (value == true) ? (D.length+1) : n;
    }

    //  Problem 2 : create pairs, such that every pair consists of equal numbers
    /*  --------------------------
        Given an array of N integers. Your task is to create pairs of them,
        such that every pair consists of equal numbers.
        Each array element may belong to one pair only.
        Is it possible to use all of the integers?
        Write a function that, given an array[] A consisting of N integers,
        returns a Boolean if it is possible to split all integers into pairs.
     */
    /*  Invariances :
        1. the amount of elements will determine the number of pairs N/2 = num_of_pairs

     */
    public static boolean pairSolution(int[] A){
        int[] B = {1,2,3,4};
        // sort B
        Arrays.sort(B);
        Arrays.toString(B);
        List<Integer> list = Arrays.asList();


        return false;
    }
}
