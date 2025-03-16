package com.demo.concepts;


/**
 * Integer
 * 1. int num = Integer.parseInt(str)
 * 2. String str = Integer.toString(num);
 */

public class Converting {
    public static void main(String[] args){

    }

    /**
     * It's important to note that parseInt throws a NumberFormatException
     * if the string does not contain a valid integer representation.
     * Therefore, it's a good practice to handle this exception when
     * parseInt in case the string input is not guaranteed to be a valid integer.
     */

    public void info(){
        try {
            String nonNumericString = "abc";
            int number = Integer.parseInt(nonNumericString); // This will throw NumberFormatException
        } catch (NumberFormatException e) {
            // Handle the case when the string is not a valid integer
            System.out.println("The string is not a valid integer.");
        }

    }
}

