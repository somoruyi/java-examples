package com.demo.companies;

// 7. Parse latest file for each day [Date & Time] [ Macquerie ]

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MacquerieA {

    // 7. Parse latest file for each day [Date & Time] [ Macquerie ]
    /*  ------------------------------
        - List the latest file for each day from a vender hosted server.
        - Vendor hosts files are published per day by a vendor in a format.
        - Multiple Rates files are published per day by a vendor in a format.
        - Write a function that takes list of files and process latest file
          from each day for last n days.
        Todo :
        1. The files should processed from oldest to newest.
        2. File name Format : Rates_yyy-mm-dd hh:mm:ss
        3. Sample file names at source: Rates_2018-01-11 6:08:30,
           Rates_2018-01-11 05:08:30 Rates_2018-01-10 03:08:30
        4. Note : if file name as the same date return only the latest one
    */
    public static List<String> processLatestFiles(List<String> filenames, int n){
        System.out.println("\n7. Parse latest file for each day [Date & Time] [ Macquerie ]");
        System.out.println("-------------------------------------------------------------\n");

        System.out.println("filenames:\t" + filenames);
        System.out.println("file count:\t" + n);

        System.out.println("");

        // 0. Variables
        // key = filename, value = parsed localdatetime
        Map<String, String> map = new HashMap<>();
        List<String> sortedFilenames = filenames.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());

        // 1. Formatter
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 2. For-loop
        for(String file : sortedFilenames){
            String datetime = file.replaceFirst("Rates_", "");
            // 2. LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.parse(datetime, dateTimeFormatter);
            String localDate = localDateTime.format(dateFormatter);


            // if the th date is not contained in the map add it as a key
            if (!map.containsKey(localDate)) {
                map.put(localDate, file);
                System.out.println("localDate:\t" + localDate);
            }

        }

        List<String> result = map.values().stream()
                .sorted()
                .limit(n)
                .collect(Collectors.toList());
        System.out.print("\nresult:\t");
        return result;
    }



}
