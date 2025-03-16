package com.demo.companies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// Macquerie
public class Macquerie {
/**
List the latest file for each day from a vender hosted server
Vendor hosts files are published per day by a vendor in a specific format
Multiple Rates files are published per day by a vendor in a specific format.
Write a function that takes list of files and process latest file from each day for last n days

The files should processed from oldest to newest.

File name Format : Rates_yyy-mm-dd hh:mm:ss
Sample file names at source: Rates_2018-01-11 6:08:30, Rates_2018-01-11 05:08:30 Rates_2018-01-10 03:08:30
Note : if file name as the same date return only the latest one

List<String> fileName = List.of("Rates_2018-01-11 06:08:30", "Rates_2018-01-11 05:08:30");
 */

    // Solution is brillant
    public static List<String> processLatestFiles(List<String> fileNames, int n) {
        // 1. Create a date format to parse file names
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 2. Create a map to store the latest file for each day
        Map<String, String> latestFiles = new HashMap<>();

        // 3. Sort the file names in reverse order (from newest to oldest)
        List<String> sortedFileNames = fileNames.stream()
                .sorted(Comparator.reverseOrder()) // this is the key to success
                .collect(Collectors.toList());

        // Process files from newest to oldest
        System.out.println("Sorted: ");
        for (String fileName : sortedFileNames) {

            String dateString = fileName.replaceFirst("Rates_","");;
            LocalDateTime localDateTime = LocalDateTime.parse(dateString, dateTimeFormatter);
//            System.out.println("localDateTime: " + localDateTime + "\n");

            System.out.println("\tfileName: " + fileName);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String localDateKey = localDateTime.format(dateFormatter);
//            System.out.println("localDateKey: " + localDateKey + "\n");

            // Check if we already have a file for this day
            // The latest date and time will be first anyways so put in the map with key
            if (!latestFiles.containsKey(localDateKey)) {
                latestFiles.put(localDateKey, fileName);
            }

        }

        // Extract the latest files for the last n days in ascending order
        List<String> result = latestFiles.values().stream()
                .sorted() // this is the key to success
                .limit(n)
                .collect(Collectors.toList());

        return result;
    }


}
