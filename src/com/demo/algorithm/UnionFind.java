package com.demo.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UnionFind implements UF{
    /**File file*/
    public static void main(String[] args){

        UF uf = new UnionFind();

        File createdFile = uf.createFileIfNotExist("file.txt");
        Map<String, Integer> map = uf.GetFileData(createdFile);

        // Display the contents of the map
        System.out.println("map: " + map);
    }

    @Override
    public Map<String,Integer> GetFileData(File file){
        Map<String, Integer> map = new HashMap<>();

        try {
            // Create a Scanner object with the File as input source
            Scanner scanner = new Scanner(file);

            // Read the number of entries (N)
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                String key = scanner.next();
                int value = scanner.nextInt();
                map.put(key, value);
            }

            // Close the Scanner
            scanner.close();

        } catch (Exception e) {
            // Handle the case where the file is not found
            System.err.println("Exception: " + e);
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<Integer, Object> GetFileData2(File file){

        Map<Integer, Object> map = new HashMap<>();

        try {
            // Create a Scanner object with the File as input source
            Scanner scanner = new Scanner(file);

            // Read the number of entries (N)
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                Integer index = scanner.nextInt();  // Read the integer
                String restOfLine = scanner.nextLine().trim();  // Read the rest of the line

                map.put(index, restOfLine);
            }

            // Close the Scanner
            scanner.close();

        } catch (Exception e) {
            // Handle the case where the file is not found
            System.err.println("Exception: " + e);
            e.printStackTrace();
        }
        return map;
    }


    @Override
    public File createFileIfNotExist(String name){
        String filePath = name;
        // Create a File object
        File file = new File(filePath);
        // Check if the file exists
        if (!file.exists()) {
            // If not, create the file
            try {
                file.createNewFile();
                System.out.println("File created: " + filePath);
            } catch (IOException e) {
                // Handle the case where file creation fails
                System.err.println("Error creating file: " + filePath);
                e.printStackTrace();
            }
        }
        return file;
    }
}

