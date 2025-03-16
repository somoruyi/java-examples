package com.demo.io;

import java.io.*;

/**
 * Utility class for handling input/output operations, such as reading from text files,
 * processing text data, displaying content, and writing to text files.
 */
public class IOUtilities {

    private String inputPath;   // Path to the input file
    private String outputPath;  // Path to the output file
    private String inputData;   // Data read from the input file

    /**
     * Constructs an IOUtilities instance with specified input and output file paths.
     *
     * @param inputPath  the path to the input file
     * @param outputPath the path to the output file
     */
    public IOUtilities(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    /**
     * Reads the first line from the input text file.
     *
     * @return the first line of the file, or {@code null} if an error occurs
     */
    public String readTextFile() {
        String line = null;

        // Try-with-resources to automatically close the BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader( "input.txt"))) {
            line = br.readLine();  // Reads the first line from the input file
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public static boolean[] processStringArray(String[]arr){
        boolean[] out = new boolean[arr.length];
        int i = 0;
        for(String s: arr){
            out[i] = Boolean.parseBoolean(s.trim());
            i++;
        }
        return out;
    }

    /**
     * Processes a line of text by splitting it into an array of strings.
     * The line is assumed to contain comma-separated values (e.g., words or phrases).
     *
     * @param line the text line to process
     * @return an array of strings, where each element is a value from the text line;
     *         an empty array if the input line is {@code null}
     */
    public String[] processTextLine(String line) {
        if (line != null) {
            return line.split(",");  // Splits the line by commas
        }
        return new String[0];  // Returns an empty array if line is null
    }

    /**
     * Displays the items in the given array. If the array is empty, displays a message
     * indicating that no items were found.
     *
     * @param items the array of items to display
     */
    public void displayItems(String[] items) {
        if (items.length > 0) {
            System.out.println("Items in the array:");
            for (String item : items) {
                System.out.println(item.trim());  // Prints each item, trimming spaces
            }
        } else {
            System.out.println("No items found.");
        }
    }

    /**
     * Writes the given array of items to the output text file as a comma-separated list.
     *
     * @param items the array of items to write to the file
     */
    public void writeItemsToTextFile(String[] items, String details) {
        // Try-with-resources to automatically close the BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath, true))) {
            for (int i = 0; i < items.length; i++) {
                bw.write(items[i].trim());  // Writes each item, trimming spaces

                // Appends a comma after each item except the last one
                if (i < items.length - 1) {
                    bw.write(",");
                }
            }
            bw.newLine();
            bw.write(details);
            bw.newLine();

            System.out.println("Items successfully written to " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the input data that has been read.
     *
     * @return the input data as a string
     */
    public String getInputData() {
        return inputData;
    }

    /**
     * Sets the input data for later processing.
     *
     * @param inputData the input data to set
     */
    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    /**
     * Returns the path to the input file.
     *
     * @return the input file path
     */
    public String getInputPath() {
        return inputPath;
    }

    /**
     * Sets the path to the input file.
     *
     * @param inputPath the input file path to set
     */
    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * Returns the path to the output file.
     *
     * @return the output file path
     */
    public String getOutputPath() {
        return outputPath;
    }

    /**
     * Sets the path to the output file.
     *
     * @param outputPath the output file path to set
     */
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
