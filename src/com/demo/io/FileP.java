package com.demo.io;

import java.io.*;


/**
 * File ↘ When you need to check if a file exists, create directories, get file metadata, or manipulate file paths.
 */

public class FileP {
    private static String filename  = "lebron.txt";
    private String line = null;

    public static void main(String[] args)  {
        try{
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
                System.out.println("File path: " + file.getPath());
            }
        }catch(IOException ex){
            System.out.println("An error occurred while creating the file.");
            ex.printStackTrace();
        }
        FileReaderP frp = new FileReaderP();
        FileReader fr = frp.getFileReaderObject(filename);

        String line = null;

        // Try-with-resources to automatically close the BufferedReader
        try (BufferedReader br = new BufferedReader(fr)) {
            line = br.readLine();  // Reads the first line from the input file
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("line: " + line);

    }
}
