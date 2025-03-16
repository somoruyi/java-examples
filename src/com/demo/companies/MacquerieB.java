package com.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MacquerieB {

    //  Problem 1 : Return the smallest positive integer
    /*  --------------------------
        A.  Given an array A of N integers, returns the smallest positive
            integer (greater than 0) that does not occur in A.
            Example :
                - Given array = [1,2,3] return 4
                - Given array = [-1, -2, -3] return 1
            https://www.notion.so/yonderwire/Interview-Questions-Amazon-Microsoft-Google-4f52ac330658427ab5d6a9cb343e14ed?pvs=4
            [ref => Codility]
     */
    /*
        Invariance :
        1. Cannot return 0
        2. Can return values of 1-7
        3. If array[1-6] == true then return 7
        4. If array[1-6] == false then return array[arr]
     */
    /*
        Big-O Notation :
        1.
     */
    public static int solution1(int[] array){
        // D = 5, 3, 6, 4, 7, 8
        boolean[] indexedArrays = new boolean[array.length + 1];

        System.out.print("indexedArrays: ");

        for(int arr : array){
            if (arr > 0 && arr < 7) {
                indexedArrays[arr] = true;
            }
            System.out.print(arr + " ");
        }

        System.out.println("\n");

        System.out.print("i: ");
        for(int i = 1; i < indexedArrays.length; i++){
            if(indexedArrays[i] == false){
                System.out.print("\nresult: ");
                return i;
            }
            System.out.print(indexedArrays[i] + " ");
        }
        System.out.println("\n");
        System.out.print("result: ");

        return indexedArrays.length;
    }

//  Problem 2 : create pairs, such that every pair consists of equal numbers
    /*  --------------------------
        - You are given an array of integers.
        - Your task is to create pairs of them, such that every pair consists of equal numbers.
        - Each array element may belong to one pair only.
        - Is it possible to use all of the integers?
        - Write a function that, given an array A consisting of N integers, return whether it
          is possible to split all integers into pairs.

        - Examples :
            - Given array = [1,2,2,1] return True.
            - Given array = [7,7,7] return False.
            - Given array = [1,2,2,3] return False.
            - Given array = [-6,-6,7,7] return True.

        https://www.notion.so/yonderwire/Interview-Questions-Amazon-Microsoft-Google-4f52ac330658427ab5d6a9cb343e14ed?pvs=4
        [ref => Microsoft]
       .
     */
    /*  - Invariances :
            1. the amount of elements will determine the number of pairs N/2 = num_of_pairs
            2. Can there be duplicate pairs?
            3. Condition 1 : if array.length is an odd number return False
            4. Constraint 1 - 100,000
            5. Can have negatives
            6. Steps
                a. sort
                b. grab the first arr
                c. Create a 2-dimenional array


    */
    public static boolean pairSolution(int[] array){
        int arrayLen = array.length;
        // Condition 1 : Making sure the # of indexes are even
        boolean isEven = arrayLen % 2 == 0 ? true : false;

        System.out.print("isFalse: " + isEven + "\n");

        // Condition 2

        if(isEven){
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            int dfNum = 0;

            // Count the frequency of each integer
            for (int num : array) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, dfNum) + 1);
                System.out.println(" num : " + num + " default_num: " + dfNum);
            }

            System.out.println("\n");

            // Check if all frequencies are divisible by 2
            for (int frequency : frequencyMap.values()) {
                System.out.println(" frequency : " + frequency + " frequencyMap.values(): " + frequencyMap.values());
                if (frequency % 2 != 0) {
                    isEven = false;
//                    return false; // Cannot form pairs for all integers
                }
            }


        }
        System.out.print("\narray : ");




        System.out.print("\nReturn: ");
        return isEven;
    }

}
