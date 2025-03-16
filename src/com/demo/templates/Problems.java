package com.demo.templates;

import java.util.List;

// 1. 1007. Minimum Domino Rotations For Equal Row  [Array]
// 2. Hour Glass [Matrix]
// 3. Find Legal Moves [Matrix] [ SLB ]
// 4. Return the smallest positive integer [Codility] [ Microsoft ]
// 5. Create pairs of equal number [Array] [ Microsoft ]
// 6. Split this string into a minimal number of substrings [ Microsoft ]
// 7. Parse latest file for each day [Date & Time] [ Macquerie ]
// 8. Find maximum possible number of processors k [ Amazon ]


public class Problems {

    //  1. 1007 -- Minimum Domino Rotations For Equal Row  [Array] [ Google ]
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
    public static int minDominoDriver(int[] tops, int[] bottoms){ return -1; }


    //  2. Hour Glass [Matrix] [ Hackerank ]
    //  Link : https://file.notion.so/f/s/2e1a9904-2b92-415a-af63-22a27ff2747d/java-2d-array-English.pdf?id=8ea124d7-3861-4fb6-9780-35cd8ecc05cf&table=block&spaceId=af9efcfb-7758-43eb-8134-94868198e9c8&expirationTimestamp=1694563200000&signature=saAqnB1P1jMWXJ6QVpAbjplG7v5ywNqXcTri5fuYnjg&downloadName=java-2d-array-English.pdf
    /*  --------------------------
        You are given a 2D array. An hourglass in an array is a
        portion shaped like this:

        a b c
          d
        e f g

        For example, if we create an hourglass using the number
        1 within an array full of zeros, it may look like this:

        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0

        Actually, there are many hourglasses in the array above.
        The three leftmost hourglasses are the following:

        1 1 1  1 1 0  1 0 0
          1      0      0
        1 1 1  1 1 0  1 0 0

        Solution : print the largest sum among all the hourglasses in the array.
     */
    /*  Invariance :
            1. Can only have (4) hour glasses per column
            2. Can only have (4) hour glasses per row
            3. When calculating the sum we are adding indexs top([0][1][2]) + bottom([0][1][2]) + middle([2])
            4. Matrix is a 6x6 to maxLength = 6
     */
    public static int getLargestHourGlassSum(){ return -1; }


    // 3. Find Legal Moves [Matrix] [ SLB ]
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
    public static void findPassableLanes(char[][] board){}


    // 4. Return the smallest positive integer [Codility] [ Microsoft ]
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
    public static int microsoftOne(int[] A){
        return -1;
    }


    // 5. Create pairs of equal number [Array] [ Microsoft ]
    // Link : https://www.notion.so/yonderwire/Interview-Questions-Amazon-Microsoft-Google-4f52ac330658427ab5d6a9cb343e14ed
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
    public static boolean microsoftTwo(int[] A){ return false; };


    //  6. Split this string into a minimal number of substrings [ Microsoft ]
    /*  ---------------------------------------
        You are given a string consisting of lowercase letters of
        teh English alphabet. You must split this string into a min
        # of substrings in such a way to no letter occurs more than
        once in each substring.

        For example, here are the some correct splits of the string
        "abacdec":
        ('a', 'bac', 'dec'), ('a','bacd', 'ec') and ('ab','ac',dec')

        Given a string S of length N, returns the miniumum number
        of substrings into which the string has to be split.

        Examples:
        1.  Given 'world', your function should return 1. There is no
            need to split the string into substrings as all letters
            occur just once.
        2.  Given 'dddd', you function should return 4. The result can
            be achieved by splitting the string into four substrings
            ('d','d', 'd','d').
     */
    public int microsoftThree(String S){
        return -1;
    }


    // 7. Parse latest file for each day [Date & Time] [ Macquerie ]
    /*  ------------------------------
        - List the latest file for each day from a vender hosted server.
        - Vendor hosts files are published per day by a vendor in a format.
        - Multiple Rates files are published per day by a vendor in a format.
        - Write a function that takes list of files and process latest file
          from each day for last n days.
        Todo :
        1. The files should processed from oldest to newest.
        2. File name Format : Rates_yyy-mm-dd hh:mm:ss
        3. Sample file names at source: Rates_2018-01-11 6:08:30,
           Rates_2018-01-11 05:08:30 Rates_2018-01-10 03:08:30
        4. Note : if file name as the same date return only the latest one
    */
    public static List<String> processLatestFiles(List<String> fileNames, int n){
        return null;
    }


    // 8. Find maximum possible number of processors k [ Amazon ]
    // Link : https://www.notion.so/yonderwire/Interview-Questions-Amazon-Microsoft-Google-4f52ac330658427ab5d6a9cb343e14ed
    public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
        return -1;
    }
}
