package com.demo.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Practice {

    /**
     *
     *
     * Problem 1 [Array] : Return the smallest positive integer ( Codility )<p>
     * -------------------------------------------------------------------- <p>
     * A.  Given an array A of N integers, returns the smallest positive <p>
     * integer (greater than 0) that does not occur in A.<p>
     * <blockquote><pre>
     *     Example :
     *              - Given array = [1,2,3] return 4
     *              - Given array = [-1, -2, -3] return 1
     *              - Solution : <a href=https://www.notion.so/yonderwire/Interview-Questions-Amazon-Microsoft-Google-4f52ac330658427ab5d6a9cb343e14ed?pvs=4>Notion</a>
     * </pre></blockquote>
     * <p>
     * Invariance : <p>
     *  1. Cannot return 0 <p>
     *  2. Can return values of 1-7 <p>
     *  3. If array[1-6] == true then return 7  <p>
     *  4. If array[1-6] == false then return array[arr] <p>
     * @author  SE Omoruyi
     * @see <strong>Big-O Notation</strong>
     *
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

//  Problem 2 [Array]: create pairs, such that every pair consists of equal numbers
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
            int keyCount = 0;

            // Count the frequency of each integer
            for (int key : array) {
                // Grab the key and place the key count
                frequencyMap.put(key, frequencyMap.getOrDefault(key, keyCount) + 1);
                System.out.println(" key : " + key + " getOrDefault(key, keyCount): " + frequencyMap.getOrDefault(key, keyCount));
            }

            System.out.println("\n values" + frequencyMap.values() + " key" + frequencyMap.keySet() + "\n");

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
    public static boolean pairSolution2(String[] players){
        int playersLen = players.length;
        // Condition 1 : Making sure the # of indexes are even
        boolean isEven = playersLen % 2 == 0 ? true : false;

        System.out.print("The array length isEven: " + isEven + "\n");

        // Condition 2

        if(isEven){
            // player, playerCount
            // a key cannot be stored twice with different values
            // if you attempt to put a key that already exists in
            // the map, it will simply update the value associated with that key rather than creating a duplicate entry.
            Map<String, Integer> playerMap = new HashMap<>();
            int playerCount = 0;

            // This is the array I'm passing
            for (String player : players) {
                // Grab the key and place the key count
                // Everytime the player is 'found' it returns
                // (player, playerCount) + 1 = ("Kyrie", 0) + 1 =  0 + 1 = (1)
                // (player, playerCount) + 1 = ("Lebron", 0) + 1 =  0 + 1 = (1)
                // (player, playerCount) + 1 = ("Lebron", 1) + 1 =  1 + 1 = (2)
                // Gets the key then searches for the value it match overwrite old with new value
                playerMap.put(player, playerMap.getOrDefault(player, playerCount) + 1);
                System.out.println("entrySet(): " + playerMap.entrySet());
            }

//            System.out.println("\n values" + playerMap.values() + " key" + playerMap.keySet() + "\n");

            // Check if all frequencies are divisible by 2
            for (int playerMatches : playerMap.values()) {
                if (playerMatches % 2 != 0) {
                    isEven = false;
                }
            }


        }

        System.out.print("\nReturn: ");
        return isEven;
    }


    // Problem 3 [2-Dimensional Array] : Find Legal Moves
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
    public static void findLegalMoves() {
        int[][] board = new int[][]{
                {0, 0, 2, 0, 0},
                {0, 8, 5, 4, 2},
                {0, 0, 6, -1, 7},
                {-1, 0, 0, 9, 4},
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
        // Coordinate = (x,y) = vertex/point
        // Setting the vertex coordinates
        vertex[0] = 0;
        vertex[1] = 2;

        // Assign the vertex coordinates to ints for the matrix
        int x = vertex[0];
        int y = vertex[1];

        System.out.println("");
        System.out.println("row:\t" + rowLength);
        System.out.println("column:\t" + columnLength);
        System.out.println("vertex:\t" + board[x][y]);
        System.out.println("");

//        System.out.println("expected = 4, 9 , 6, 7");
        for(int[] move : moves){
//            System.out.println("move: (" + move[0] + "," + move[1]+ ")");

            if(((x + move[0]) < rowLength && (x + move[0]) >= 0)  && ((y + move[1]) < columnLength && (y + move[1]) >= 0)){
                System.out.print(board[x + move[0]][y + move[1]] + " ");
            }

        }

        System.out.println("");
        // Logic

    }


    //  Problem : 1007. Minimum Domino Rotations For Equal Row
    /*  -----------------------
        In a row of dominoes tops[i] and bottoms[i] represent the top and bottom halves of the (ith) domino.
        (Note: A domino is a tile with two numbers from `1 to 6` - one on each half of the tile).
        We may rotate the (ith) domino, so that tops[i] and bottoms[i] swap values.
        Return the minimum number of rotations so that all the values in `tops` are the same, or all the
        values in `bottoms` are the same.
        If it cannot be done, return  `-1`.

        int[] tops =    [5,1,3,3,3,3]
        int[] bottoms = [3,3,3,2,2,2]
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
    /*  Invariances
        1. domino value 1-6
        2. domino value occurance cannot be less than 5
        3. map can get top and bottom and add them (complicated)
        4. number of dominos can be ith places
        5. if on flip doesnt match return -1 (look for all scenerios where -1)
        6. check which row has the most occurences of the value and use that row for flips
        7. if flip does not == value return -1
        8. condition 1 : count must equal top length.
        9. create an array to hold values 1-6
    */
    public static int minDominoDriver(int[] tops, int[] bottoms){
        int minNumOfRotations = -1;

        int[] array = new int[7]; // stores the number of times 1-6 occurs must occur 5 or more times
        boolean isTop = false;
        int threshold = (tops.length/2);
        System.out.println("threshold:\t" + threshold);
        int value = -1;

        System.out.print("\ntops:\t\t");
        for(int top : tops) {
            System.out.print(top + " ");
        }
        System.out.print("\nbottoms:\t");
        for(int bottom : bottoms) {
            System.out.print(bottom + " ");
        }
        System.out.println("");

        // added each value of tops[]  to array[]
        for(int i=0; i < tops.length; i++){
            array[tops[i]] = array[tops[i]] + 1;

            // once the tops[] count met the threshold set isTop to true
                // set value
            if(array[tops[i]] > threshold){
                value = tops[i];
                isTop = true;
            }
        }

        // added each value of bottoms[]  to array[]
        for(int i=0; i < bottoms.length; i++){
            array[bottoms[i]] = array[bottoms[i]] + 1;
            // if isTop == false and bottoms[] met the threshold
                // set value
            if (!isTop && array[bottoms[i]] >= threshold) {
                value = tops[i];
            }
        }
        System.out.println("\nvalue:\t" + value);

        if(array[value] >= tops.length){
            minNumOfRotations = flipDominoes(value, tops, bottoms);
            return minNumOfRotations;
        }else{
            for(int i=1; i < array.length; i++){
                if(array[i] >= bottoms.length){
                    minNumOfRotations = flipDominoes(i, bottoms, tops);
                    break;
                }
            }
        }


        return minNumOfRotations;
    }

    public static int flipDominoes(int value, int[] tops, int[] bottoms){
        int results = 0;
        int[] temp = new int[1];
        for (int i=0; i< tops.length; i++){
            if(tops[i] == value){
            }
            else if(tops[i] != value && bottoms[i] == value){
                temp[0] = tops[i];
                tops[i] = bottoms[i];
                bottoms[i] = temp[0];
                results++;
            }else{
                results = -1;
                return results;
            }
        }
        System.out.print("\n\ntops:\t\t");
        for(int top : tops) {
            System.out.print(top + " ");
        }
        System.out.print("\nbottoms:\t");
        for(int bottom : bottoms) {
            System.out.print(bottom + " ");
        }
        System.out.println("");

        return results;

    }

}
