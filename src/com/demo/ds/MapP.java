package com.demo.ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@link Map}{@code <K,V>}
 *
 * <pre>{@code
 * public static void main(String[] args){
 *      //
 * }
 * }</pre>
 * <strong>Methods ( Access )</strong>
 * <ul>
 *     <li>{@code Collection<V> values()}</li>
 *     <li>{@code Set<K> keySet()}</li>
 *     <li>{@code Set<Map.Entry<K, V>> entrySet()}</li>
 * </ul>
 *
 * <pre>{@code
 * public static void main(String[] args){
 *      //
 * }
 * }</pre>
 *<strong>Methods ( Manipulation )</strong>
 * <ul>
 *     <li>{@code V getOrDefault(Object key, V defaultValue)}</li>
 * </ul>
 * @see TreeMap
 * @see Hashtable
 */
public class MapP {
    public static void main(String[] args){
        List<String> players = List.of("lebron", "kyrie", "durant", "lebron", "lebron", "kyrie");
        MapP.method1(players);
    }

    public static void method1(List<String> players){
        Map<String, Integer> map = new HashMap<>();

        players.stream()
                .filter(p -> p.contains("lebron"))
                // This line counts the number of lebron
                .map(player -> map.put(player,map.getOrDefault(player, 0) + 1))
                .collect(Collectors.toList());

        System.out.println("map:\t" + map);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }
}
