package com.demo.io;

import java.util.Scanner;

import java.util.Arrays;

import java.io.FileWriter;
import java.io.IOException;



public class Josephus {
    public static void main(String[] args) {
        IOUtilities util = new IOUtilities("input.txt", "output.txt");
        System.out.println("util: " + util);
        boolean[] circle;
        String lines = util.readTextFile();
        System.out.println("lines: " + lines);
//        String[] input = util.processTextLine(lines);
//        circle = IOUtilities.processStringArray(input);
//        Scanner keyboard = new Scanner (System.in);
//        System.out.println(Arrays.toString(circle));
//        int startPosition = 3; // User must enter this value.
//        int numbLiving = circle.length;
//        int loopCounter = startPosition;
//
//        int target = 0;
//        int peopleInCircle = 9;
//
//        System.out.println("Enter the index number: 3");
//        startPosition = keyboard.nextInt();
//        while(startPosition !=3 ) {
//            System.out.println("Re-enter index number: 3");
//            startPosition = keyboard.nextInt();
//
//        }

//        System.out.println("What is the target: ");
//        target = keyboard.nextInt();
//
//        System.out.println("How many people are in the circle: ");
//        peopleInCircle = keyboard.nextInt();
//
//
//        keyboard.close();
//
//        int skipCount = 0;
//
//        while(numbLiving > 1) {
//            if(loopCounter == circle.length) {
//                loopCounter = 0;
//
//            }
//            if(circle [loopCounter] == true) {
//                skipCount++;
//                if(skipCount == target) {
//                    numbLiving--;
//                    skipCount=0;
//                    circle[loopCounter] = false;
//
//                    //writeFile(String fileName, String text, boolean append)
//                    writeFile("output.txt", Arrays.toString(circle), true);
//
//                }
//
//            }
//
//
//            loopCounter++;
//        }
    }

//    public static void writeFile(String fileName, String text, boolean append) {
//        try (FileWriter writer = new FileWriter(fileName, append)) {
//            writer.write(text);
//            writer.write(System.lineSeparator()); // To add a new line after the text
//            System.out.println("Text written to file successfully.");
//        } catch (IOException e) {
//            System.out.println("An error occurred while writing to the file: " + e.getMessage());
//        }
//    }

}

