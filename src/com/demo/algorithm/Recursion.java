package com.demo.algorithm;

public class Recursion {
    public static void main(String[] args){
        System.out.println("recursion1: " + recursion1(10));

        System.out.print("recursion2: ");
        recursion2(10);

    }
    public static int recursion1(int x){

        if(x >= 5){
            x = x - 1;
            return recursion1(x);
        }
        return x;
    }
    public static void recursion2(int x) {
        if (x >= 5) {
            x = x - 1;
            System.out.printf("%d ", x);
            recursion2(x);
        }
    }
}
