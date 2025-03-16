package com.demo.algorithm.string;
import java.util.Scanner;

/**
 * Todo - Need instructions
 */
public class ParseStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input string:");
        while (true) {
            //System.out.print("Enter input string:");

            if (!scanner.hasNextLine()) {
//                System.out.println();
                break;
            }

            String input = scanner.nextLine().trim();
//            System.out.println(input);

            if (input.isEmpty()) {
                continue;
            }

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            if (!input.contains(",")) {
                System.out.println("Error: No comma in string");
                continue;
            }

            String[] parts = input.split(",");

            if (parts.length != 2) {
                System.out.println("Error: Invalid input format");
                System.out.println();
                continue;
            }

            String firstWord = parts[0].trim();
            String secondWord = parts[1].trim();

            if (secondWord.contains(",")) {
                System.out.println("Error: Invalid input format");
                // System.out.println();
            }

            // System.out.println("First word: " + firstWord);
            // System.out.println("Second word: " + secondWord);
            // System.out.println();
        }
        scanner.close();
    }
}
