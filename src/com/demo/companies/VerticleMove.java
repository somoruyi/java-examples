package com.demo.companies;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <h3>Best Practices</h3>
 * {@code scanner.hasNext()} - Waits until input becomes available
 */

public class VerticleMove {
    private static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("-- VerticalMove --");

        String str = correct();
        System.out.println("str: " + str);
        char[] ch = str.toCharArray();
        Set<String> uniqueChar = new HashSet<>();

        Set<String> uChar = solveProblem(ch, 0, uniqueChar);
        for(String u : uChar){
            System.out.println("u: " + u);
        }
        scanner.close();
    }

    public static String correct(){
        System.out.println("-- correct --");

        System.out.print("Enter a word: ");

        // the if condition will exit the program immediately
        return (scanner.hasNext()) ?  scanner.next() : correct();

    }

    public static void incorrect(){
        System.out.println("-- incorrect --");

        System.out.print("Enter word: ");
        while(scanner.hasNext()){ // thw while condition will not exit the program
            String input = scanner.next();
            System.out.println("\ninput: " + input);
            System.out.print("Enter word: ");
        }

    }
    public static Set<String> solveProblem(char[] ch, int index, Set<String> uniqueChar){
//        System.out.println("-- solveProblem --");

//        System.out.println("index: " + index);

        if(index == ch.length){
//            System.out.println("done");
            return uniqueChar;
        }

        for(int i = index; i < ch.length; i++){
            char temp = ch[0];
            ch[0] = ch[index];
            ch[index] = temp;
//            System.out.println("ch: " + String.valueOf(ch));
            uniqueChar.add(String.valueOf(ch));
            return solveProblem(ch, index+1, uniqueChar);
        }

        return uniqueChar;

    }

}
