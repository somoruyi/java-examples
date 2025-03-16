package com.demo.companies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 8. Find maximum possible number of processors k [ Amazon ]
// 9. Amazon is building a way to help customers search reviews quicker  [ Amazon ]
// 10. Amazon 2023

public class AmazonA {
    public static void main(String[] args) {
        // 8
//        List<Integer> bootingPower = Arrays.asList(11, 12, 19); // m
//        List<Integer> processingPower = Arrays.asList(10, 8, 7); // s
//        long powerMax = 6; // n
//        System.out.print("\n" + findMaximumSustainableClusterSize(processingPower, bootingPower, powerMax)); // k


//        AmazonA.findMaximumSustainableClusterSize(processingPower, bootingPower, powerMax);

        // 9
         List<String> repository = List.of("mobile", "mouse", "moneypot", "monitor", "mousepad", "pillow");
         String customerQuery = "mouse";
        System.out.println(AmazonA.searchSuggestions(repository, customerQuery));
         System.out.println(AmazonA.searchSuggestions2(repository, customerQuery));
    }

    /**
     * <h2>8. Find maximum possible number of processors k [ Amazon ]</h2>
     * <h3>Amazon Web Services (AWS) has several data centers which have multiple processors that perform computations.</h3>
     * {@link www.notion.so/yonderwire/Interview-Questions-Amazon-Microsoft-Google-4f52ac330658427ab5d6a9cb343e14ed Notion - Interview-Questions-Amazon-Microsoft-Google}
     * <ol>
     *     <li>In one such data center, these processors are placed in a sequence with their IDs denoted by {@code (1,2,...n)}.</li>
     *     <li>Each processor consumes a certain amount of power to (boot up), denoted by {@code bootingPower[i]}.</li>
     *     <li>After booting, a processor uses {@code processingPower[i]} of power to (run the processes).</li>
     *     <li>For maximum utilization, the data center wishes to group these processors into clusters.</li>
     *     <li><u>Note</u> : Clusters can only be formed of processors located adjacent to each other. <br><br>For example :
     * <pre>
     *
     *  {@code
     * - [ ]  processors `2, 3, 4, 5` can form a cluster
     * - [x]  processor `1, 3, 4` CANNOT
     * - The net power consumption(n) of a cluster of (k) processors
     *   (i, i+1, .., i+k-1) is defined as :
     *
     *   Syntax  : n = m + (s * k)
     *   Example : n = max(bootingPower[i], bootingPower[i+1],...,
     *             bootingPower[i+k-1])
     *
     *      m = maximum booting power (#) among the (k) processors
     *      s = sum of processing power of processors
     *      k = processors
     *      n = net power consumption
     *  }
     * </pre>
     *     </li>
     *     <li>A cluster of processors is said to be sustainable if its net power consumption does not exceed a given threshold value {@code powerMax(n)}</li>
     *     <li>Given the booting power consumption and the processing power consumption of {@code (n) processors} denoted by {@code bootingPower(m)} and {@code processingPower(s)} respectively, and the threshold value {@code powerMax(n)}</li>
     *     <li>Find the maximum possible {@code number of processors (k)} which can be grouped together to form a sustainable cluster.</li>
     *     <li>If no such clusters can be formed, {@code return k = 0}.
     *     <li><u>Notes</u> : It is not mandatory for all {@code clusters of size (k)} to be sustainable. Even one such cluster is sufficient.)\</li>
     *
     * </ol>
     */
    public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
        /**
        s = processingPower
        m = bootingPower
        n = powerMax
        (n) = (m)  + (s) * (k);
         */
        int dummyInt = 0;

        return -1;
    }

    /**
     * <h2>9. Amazon is building a way to help customers search reviews quicker  [ Amazon ]</h2>
     * <h3>Amazon is building a way to help customers search reviews quicker by providing real-time suggestions
     * to search terms when the customer starts typing. As the customer continues to type in the reviews <u>query
     * search</u> bar, the relevant <u>repo keyword</u> suggestions will update automatically.</h3>
     *<ol>
     * <li>When given a minimum of {@link 2} <u>query characters</u> into the search field</li>
     * <li>The system will suggest at most {@link 3} <u>repo keywords</u> from the review word repository.</li>
     * <li>Write an algorithm that will output a maximum of {@link 3} <u>repo keywords</u> suggestions after each <u>query</u> character is typed by the customer
     * in the search field.
     * <pre>
     *  {@code
     *   - min()
     *   - max()
     *   - limit(#)
     *  }
     * </pre>
     * </li>
     * <li>Only return <u>repo keyword</u> suggestions after the customer has entered {@link 2} <u>query characters</u>.</li>
     * <li>Both the {@code repository} and the {@code customerQuery} should be compared in a case-insensitive way:
     * <pre>
     *  {@code
     *   - Syntax   : map(type::method)
     *   - Examples :
     *      - map(String::toLowerCase())
     *      - map(str -> str.toLowerCase())
     *  }
     * </pre>
     * </li>
     * <li><u>repo keyword</u> suggestions must start with the <u>query characters</u> already typed
     * <pre>
     *  {@code
     *   - compare()
     *   - startsWith()
     *
     *   - Examples : filter(str1 -> str1.startsWith(str2))
     *                filter(str1 -> str1.compare(str2))
     *  }
     * </pre>
     * </li>
     * <li>If there are more than {@link 3} acceptable <u>repo keywords</u>, return the keywords that are first in alphabetical
     * order.
     * <pre>
     *  {@code
     *   - sorted()
     *   - count(#)
     *  }
     *  </pre>
     * </li>
     * <li>If an output is not possible, return an empty <u>repo</u>
     * <pre>
     *  {@code
     *   - []
     *  }
     *  </pre>
     * </li>
     * <li>If an output is possible, return</u>
     * <pre>
     *  {@code
     *   [
     *      [mouse, mousepad, ]
     *      [mouse, mousepad, ]
     *      [mouse, mousepad, ]
     *      [mouse, mousepad]
     *  ]
     *  }
     *  </pre>
     * </li>
     * </ol>

     {@link java.util.stream.Stream}
     */
    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {

        List<List<String>> isEmpty = List.of();
        List<List<String>> doubleList = new ArrayList<>();

        for(int i = 1 ; i < customerQuery.length() ; i++ ){
            String s = customerQuery.substring(0, i+1).toLowerCase();
            System.out.println("s:\t" + s);
            List<String> arr = repository.stream()
                    .map(String::toLowerCase)
                    .sorted()
                    .filter(repo -> repo.contains(s))
                    .limit(3)
                    .collect(Collectors.toList());

            doubleList.add(arr);
        }

//        System.out.print("\nresult:\t");
        return doubleList.isEmpty() ? isEmpty : doubleList;
    }

    public static List<List<String>> searchSuggestions2(List<String> repository, String customerQuery){
        // check first to character
        // then the each char after that

        List<List<String>> results = new ArrayList<>();
        String[] splitStr = customerQuery.split("");
        if(splitStr.length > 1){
            for(int i = 1; i < splitStr.length; i++){
//                System.out.println("i: " + i);
                String cq = customerQuery.substring(0, i+1);
//                System.out.println("cq: " + cq);
                List<String> resultsList = repository.stream()
                        .map(String::toLowerCase)
                        .filter(item -> item.startsWith(cq))
                        .sorted()
                        .limit(3)
                        .collect(Collectors.toList());

                results.add(resultsList);

            }
        }

        return results;
    }
}
