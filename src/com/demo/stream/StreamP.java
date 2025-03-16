package com.demo.stream;

import java.util.*;
import java.util.stream.Collectors;


public class StreamP {
    /*  1. Use Method References for "map"
    */

    public static void main(String[] args) {
        //StreamP.streamMethod2();
        StreamP.streamMethod3();
    }
    public static void streamMethod() {
        // List
        List<Integer> player = List.of(18, 20, 100, 5, 6); // 18, 5, 6
        List<Integer> streamPlayerLessOrEqual18 = player.stream()
                .filter(p -> p <= 18) // condition
                .collect(Collectors.toList());

        List<Integer> streamPlayerFirstTwo = player.stream() // 18, 20
                .limit(2) // condition
                .collect(Collectors.toList());

        // Results
        System.out.println("results:\t" + streamPlayerLessOrEqual18);
        System.out.println("results:\t" + streamPlayerFirstTwo);

        // Map
        Map<String, String> map = Map.of(
                "Lebron", "Lakers",
                "Kyrie", "Mavs"
        );
        List<String> playerTeam = map.values().stream() // mavs
                .map(String::toLowerCase)
                .filter(team -> team.startsWith("m"))
                .collect(Collectors.toList());

        List<String> playerName = map.keySet().stream() // lebron
                .map(String::toLowerCase)
                .filter(name -> name.contains("lebron"))
                .collect(Collectors.toList());

        System.out.println("\nresults:\t" + playerTeam);
        System.out.println("results:\t" + playerName);
    }
    public static void streamMethod2(){

        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(11);

        Map<String, String> map = Map.of(
                "Lebron", "Dunking",
                "Kyrie", "Dribbling",
                "AD", "Blocking"
        );

        // sort = comparator = > <
        // map = function = transform
        // filter = predicate = condition
        list.stream()
                .filter(n -> n > 11)
                .limit(1)
                .forEach(System.out::println);

        map.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
    public static void streamMethod3(){
        int k =3;
        int[] nums = {1,3,-1,-3,5,3,6,7};

        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());


    }
}
