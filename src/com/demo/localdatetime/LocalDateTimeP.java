package com.demo.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocalDateTimeP {
    /*
        1. Setup LocalDateTime
        2. Extract Date
        3. Extract Time

        1. Setup Stream (Maps, List)
        2. sort, reverse sort, filter, limits

        1. Set Maps
        2. Transverse through a map
        3. Value-Keys
        4. Keys
        5. Value
     */

    public static void practiceMaps(){
        Map<String, String> map = new HashMap<>();
        map.put("playerKey", "playerValue");
        /*
            May.Entry<String, String> entrySet : map.entrySet()
            String keySet : map.keySet()
            String value : map.values()

         */
        for(Map.Entry<String, String> entrySet : map.entrySet()){
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            System.out.println("\tentrySet: " + entrySet + "\tkey: " + key + "\tvalue: " + value);
        }

        System.out.println("");
        for(String key : map.keySet()){
            System.out.println("\tkey: " + key);
        }

        System.out.println("");
        for(String value : map.values()){
            System.out.println("\tvalue: " + value);
        }
    }

    public static void practiceDateTime(){
        // Formatter


        // 2. LocalDateTime
        // 2.1 Format Pattern
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
        // 2.2 Parse LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse("2012-01-01 13:00:05", dateTimeFormatter);
        System.out.println("localDateTime:\t" + localDateTime);

        // 3 LocalDate
        // 3.1 Format Pattern
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        // 3.2 Parse LocalDate
        LocalDate localDate  = LocalDate.parse("2012-01-01", dateformatter);
        System.out.println("localDate:\t\t" + localDate);

        // 4 LocalTime
        // 4.1 Format Pattern
        DateTimeFormatter localFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // 4.2 Parse LocalTime
        LocalTime localTime  = LocalTime.parse("12:00:05", localFormatter);
        System.out.println("localTime:\t\t" + localTime);
    }

    public static void practiceStreams(List<String> player, Map<String, List<Object>> players){
        // List
        System.out.println("players:\t" + player);

        List<String> stream = player.stream()
                .map(p -> p.toLowerCase())
                .sorted(Comparator.reverseOrder())
                .filter(p -> p.startsWith("k"))
                .distinct()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("\nstream:\t" + stream);

        // Map
        System.out.println("\nsingers:\t" + players.entrySet());

    }
}
