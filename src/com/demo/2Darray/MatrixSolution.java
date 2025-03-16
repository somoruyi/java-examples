package com.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatrixSolution {

    //  Problem : Find Legal Moves
    /*  --------------------------
        A.  Your given a 2-dimensional array with 0s and -1s
            You are given a start point = vertex = coordinate (X,Y)
            Returns the N,W,S,E coordinates that == 0
        B. Edge Cases
        (1) Check if N, S, E, W is out of bounds
        (2) X = S,N
        (3) Y = E,W
        (4) Row length = board.length
        (5) Column length = board[0].length
        C. Check for invariance
     */
    public static void findLegalMoves5() { // Mastered!!!
        int[][] board = new int[][]{
                {0, 0, 2, 0, 0},
                {0, 8, 5, 4, 2},
                {0, 0, 6, -1, 7},
                {-1, 0, 0, 0, 4},
                {3, -1, 0, 0, 0},
                {8, 4, 0, 9, 0},
                {0, 0, 0, -1, 0}
        };

        int rowLength = board.length;
        int columnLength = board[0].length;

        int[] vertex = new int[2];
        int[][] moves = {
                {-1,0}, // N
                {1,0},  // S
                {0,-1}, // W
                {0,1}   // E
        };
        // Coordinate = (1,2)
        vertex[0] = 5;
        vertex[1] = 3;

        int x = vertex[0];
        int y = vertex[1];
        System.out.println("vertex: " + board[x][y]);

        int count = 0;
        for(int[] move : moves){
            if(
                    ((x+move[0]) < rowLength && (y+move[1]) < columnLength) &&
                    ((x+move[0]) >= 0 && (y+move[1]) >= 0)
            ){
                if(board[x+move[0]][y+move[1]] == 0){
                    System.out.println("Edge: " + board[x+move[0]][y+move[1]]);
                }
            }
        }

    }

    //  Problem : 1007. Minimum Domino Rotations For Equal Row
    /*  -----------------------
        In a row of dominoes tops[i] and bottoms[i] represent the top and bottom halves of the (ith) domino.
        (Note: A domino is a tile with two numbers from `1 to 6` - one on each half of the tile).
        We may rotate the (ith) domino, so that tops[i] and bottoms[i] swap values.
        Return the minimum number of rotations so that all the values in `tops` are the same, or all the
        values in `bottoms` are the same.
        If it cannot be done, return  `-1`.

        int[] tops =    [3,5,1,2,3]
        int[] bottoms = [3,6,3,3,4]
    */
    /*
        Identify the edge cases :
        - 1-6 has to appear (i) times
        - (2) arrays
            - boolean
            - int
         1. Check if a # appears at least 5 times
         2. check if that # appears in index 0-4 for top and bottom
         3. check whether top or bottom has the most trues and swap to the greater row

         Edge Cases / Invariances
         score can only be 1 - 6
         the value of top is going to stored in score
         Only max 2 numbers can appear 5 times
         only 5 slots to if top or bottom is > 2 it holds rank
         after checking if both values are present, check if both or equal if so either order can be swapped
        */
    public static void minDominoDriver(){
        int[] tops = {3,5,5,2,3};
        int[] bottoms = {5,3,3,5,5};
        MatrixSolution.minDominoRotation(tops, bottoms);
        // Results index = 5, max flips = 2

        tops = new int[]{1, 1, 1, 2, 1};
        bottoms = new int[]{5, 1, 3, 1, 5};
        MatrixSolution.minDominoRotation(tops, bottoms);
        // Results index = 1, max flips = 1

        tops = new int[]{1, 1, 1, 2, 1};
        bottoms = new int[]{5, 1, 3, 6, 5};
        MatrixSolution.minDominoRotation(tops, bottoms);
        // Results index = 1, max flips = -1

        tops = new int[]{1, 2, 1, 1, 1};
        bottoms = new int[]{2, 1, 2, 2, 2};
        MatrixSolution.minDominoRotation(tops, bottoms);
        // Results index = 2, max flips = 1
    }
    public static void minDominoRotation(int[] tops, int[] bottoms){
        System.out.println("\n1007. Minimum Domino Rotations For Equal Row");

        int swapIndex = 0;
        int[] score = new int[7];
        for(int i = 0; i<tops.length; i++){ // is this possible?
            score[tops[i]] += 1;
            score[bottoms[i]] += 1;

            if(score[tops[i]] >= tops.length){
                swapIndex = tops[i];
            }
            if(score[bottoms[i]] >= tops.length){
                swapIndex = bottoms[i];
            }
        }
        System.out.println("index:\t\t" + swapIndex);

        int topCount = 0;
        int bottomCount = 0;
        int len = tops.length;
        for(int i = 0; i<len; i++){
            if(tops[i] == swapIndex || bottoms[i] == swapIndex) {
                if (tops[i] == swapIndex) {
                    topCount++;
                }if (bottoms[i] == swapIndex) {
                    bottomCount++;
                }if (i == (len-1)) {
                    System.out.println("tCount:\t\t" + topCount);
                    System.out.println("bCount:\t\t" + bottomCount);
                    if(bottomCount > topCount){
                        System.out.println("move to bottom:\t" + (len-bottomCount));
                        swapDominos(bottoms,tops,swapIndex, "bottoms", "tops");
                    }else{
                        System.out.println("move to top:\t" + (len-topCount));
                        swapDominos(tops, bottoms, swapIndex, "tops", "bottoms");
                    }
                }
            }else{
                System.out.println("-1");
                break;
            }
        }
    }
    public static void swapDominos(int[] arr1, int[] arr2, int swapIndex, String name1, String name2){
        int[] swap = new int[arr1.length];
        for(int i = 0; i<arr1.length; i++){ // is this possible?
            if(arr1[i] != swapIndex){
                swap[i] = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = swap[i];
            }
        }
        System.out.println(name1 + ":\t" + Arrays.toString(arr1));
        System.out.println(name2 + ":\t" + Arrays.toString(arr2));
    }

    //  Problem : Hour Glass
    /*  --------------------
        - You are given a 2D array.
        - An hourglass in an array is a portion shaped like this:
         a b c
           d
         e f g
         For example the below matrix has the following hour glasses:
         2 2 2      2 2 4       2 4 4
           2          4           6
         2 2 2      2 2 4       2 4 6

         2, 2, 2, 4, 4, 4
         0, 2, 4, 6, 8, 0
         2, 2, 2, 4, 6, 6
         0, 0, 2, 4, 4, 0
         0, 0, 0, 2, 0, 0
         0, 0, 1, 2, 4, 0

         Solution : print the largest sum among all the hourglasses in the array.
     */
    public static int getLargestHourGlassSum(){
        System.out.println("Hour Glass");
        System.out.println("----------");
        //  Solution : print the largest sum among all the hourglasses in the array.
        /*
            Invariance :
                1. Can only have (4) hour glasses per column
                2. Can only have (4) hour glasses per row
                3. When calculating the sum we are adding indexs top([0][1][2]) + bottom([0][1][2]) + middle([2])
                4. Matrix is a 6x6 to maxLength = 6
         */

        List<Integer> sumArray = new ArrayList<>();
        List<List<Integer>> arrList = getIntegerList();
        for(int shift = 0; shift < 4 ; shift++){
            sumArray.add(processHourGlass(arrList, 0, 2, shift)); // shift right column by # max 4
            sumArray.add(processHourGlass(arrList, 1, 3, shift)); // shift right column by # max 4
            sumArray.add(processHourGlass(arrList, 2, 4, shift)); // shift right column by # max 4
            sumArray.add(processHourGlass(arrList, 3, 5, shift)); // shift right column by # max 4
        }
        return Collections.max(sumArray);
    }
    public static int processHourGlass(List<List<Integer>> arrList, int start, int end, int shiftColumnByNum){
        int count = 0;
        int sum = 0;
        for(List<Integer> arr : arrList){
            if(count >= start && count <= end){ // row that shifts
                if (count == start || count == end) {
                    sum = (sum + arr.get(0+shiftColumnByNum) + arr.get(1+shiftColumnByNum) + arr.get(2+shiftColumnByNum));
                } else {
                    sum = (sum + arr.get(1+shiftColumnByNum));
                }
            }
            count++;
        }
        return sum;
    }
    public static List<List<Integer>> getIntegerList(){
        List<List<Integer>> myList = List.of(
                Arrays.asList(2, 2, 2, 4, 4, 4),
                Arrays.asList(0, 2, 4, 6, 8, 0),
                Arrays.asList(2, 2, 2, 4, 6, 6),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)
        );
        System.out.println("myList: " + myList.get(0));
        System.out.println("myList: " + myList.get(1));
        System.out.println("myList: " + myList.get(2));
        System.out.println("myList: " + myList.get(3));
        System.out.println("myList: " + myList.get(4));
        System.out.println("myList: " + myList.get(5));
        return myList;
    }


}
