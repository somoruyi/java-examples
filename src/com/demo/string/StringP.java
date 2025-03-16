package com.demo.string;

// 1. Reverse a string, but keep the order [ Revature ]

public class StringP {
    /* 1.   Split String by (space)
            String s = "hi my name is lebron";
            String[] strArraySplit = s.split(" ");

       2.   Split String by (characters)
            String s = "lebron";
            char letter = s.charAt(i);

       3.   Reverse a String
            - StringBuilder
            - StringBuffer
     */

    public static void main(String[] args){
        // expected : “ih ym eman si norbel”
        String s = "hi my name is lebron";

        System.out.println("\ns: " + s);

        // 1. Split string
        String[] strArraySplit = s.split(" ");
//
//        System.out.println("\nstrArray: " + List.of(strArray));
//        // Lets reverse 1 word
//        System.out.println("\nword:\t" + strArray[4]);
//
//        StringBuilder sb = new StringBuilder(strArray[4]);
//
//        System.out.println("\nword reversed:\t" + sb.reverse());

        String[] resultArray = new String[strArraySplit.length];

        // Create a stream ( Note : forEach returns a void)

//        int i = 0;
        String results = "";
        for(String item : strArraySplit){
            StringBuilder sb = new StringBuilder(item);
            results = results + sb.reverse() + " ";
//            i++;
        }
//        System.out.println("\nresultArray: " + List.of(resultArray));

//        String  results = resultArray.toString();
        System.out.println("\nresults: " + results);

        String str = "1";
        System.out.println("str: " + Integer.parseInt(str));

        if(Integer.parseInt(str) > 0){
            System.out.println("status: " + true);
        }

    }



}
