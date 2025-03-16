package com.demo.array;

import java.util.Arrays;

public class MatrixEsratSolution {

    public static String ArrayChallenge(String[] strArr) {
        // Extract the matrix dimensions
        int rows = strArr.length;
        int cols = strArr[0].length();

        // Find the position of the 1
        int row = -1, col = -1;
        for (int i = 0; i < rows; i++) {
            int index = strArr[i].indexOf('1');
            if (index != -1) {
                row = i;
                col = index;
                break;
            }
        }

        // If there is no 1 or there are no 2's, return 0
        if (row == -1 || strArr[row].indexOf('2') == -1) {
            return "0";
        }

        int minDistance = Integer.MAX_VALUE;

        // Iterate through the matrix to find the distance to the nearest 2
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (strArr[i].charAt(j) == '2') {
                    int distance = Math.min(Math.abs(row - i), rows - Math.abs(row - i))
                            + Math.min(Math.abs(col - j), cols - Math.abs(col - j));
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }

        return String.valueOf(minDistance);
    }


}
