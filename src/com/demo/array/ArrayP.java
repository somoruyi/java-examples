package com.demo.array;

public class ArrayP {



    public static void method1(){
        // Create a matrix
//        int rows = 2;
//        int columns = 3;
    /*
        0 0 5
        0 0 0
     */
        // create a matrix
//        int[][] matrix = new int[rows][columns];
        // add a value to a vertex
        int[][] matrix = {{0 ,0, 7},{0,0,0}};
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] vertex = {0,2};
        int x = vertex[0];
        int y = vertex[1];

        System.out.println("point:\t\t" + matrix[x][y]);
        System.out.println("expected:\t7");
        System.out.println("rows: " + rows + "\tcolumns: " + columns);

        for(int[] matrixRow : matrix){
            for(int value : matrixRow){
                System.out.print(value + " ");
            }
            System.out.println("");
        }

    }
    public static void method2(){
        // Create a matrix
//        int rows = 2;
//        int columns = 3;
    /*
        0 0 5
        0 0 0
     */
        // create a matrix
//        int[][] matrix = new int[rows][columns];
        // add a value to a vertex
        int[][] matrix = {{0 ,0, 7},{0,0,0}};
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] vertex = {0,2};
        int x = vertex[0];
        int y = vertex[1];

        System.out.println("point:\t\t" + matrix[x][y]);
        System.out.println("expected:\t7");
        System.out.println("rows: " + rows + "\tcolumns: " + columns);

        for(int[] matrixRow : matrix){
            for(int value : matrixRow){
                System.out.print(value + " ");
            }
            System.out.println("");
        }

    }

}
