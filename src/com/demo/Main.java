package com.demo;

import com.demo.companies.MacquerieA;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* --- Leidos --- */

        // 3. Find Legal Moves [Matrix] [ SLB ]
        char[][] board = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '+', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
        };
        int[][] board_1 = new int[][]{
                {0, 0, 2, 0, 0},
                {0, 8, 5, 4, 2},
                {0, 0, 6, -1, 7},
                {-1, 0, 0, 9, 4},
                {3, -1, 0, 0, 0},
                {8, 4, 0, 9, 0},
                {0, 0, 0, -1, 0}
        };


        // 4. microsoftOne
        // 5. microsoftTwo
        // 6. microsoftThree

        /* --- 7. Parse latest file for each day [Date & Time] [ Macquerie ] --- */
        List<String> fileName = List.of(
                "Rates_2018-01-13 06:08:30", "Rates_2018-01-11 04:08:30",
                "Rates_2018-01-11 06:08:30", "Rates_2018-01-30 05:08:30"
        );
        int n = 5;
        System.out.print(MacquerieA.processLatestFiles(fileName,n));

    }
}