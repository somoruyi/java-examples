package com.demo.ds;

import java.util.*;

public class SetP {
    // shotcuts = sout <tab> or <enter>
    // https://github.com/janbodnar/Java-Advanced/tree/master

    /**
     * {@link Set}{@code <T>}  Interface <p>
     *  <strong>Characteristics</strong>
     *  <ol>
     *      <li>Unordered</li>
     *      <li>Cannot be accessed via index</li>
     *      <li>Unique</li>
     *  </ol>
     *  <strong>Classes</strong>
     *  <ol>
     *      <li>TreeSet : No nulls</li>
     *      <li>HashSet :</li>
     *      <li>LinkedHashSet :</li>
     *  </ol>
     */
    public static void main(String[] args){
        treeSet1();
    }
    public static void treeSet1(){
        System.out.println("--- treeSet1() ---");

        Set<String> mySet1 = new TreeSet<>();
        mySet1.add("Lebron");
        mySet1.add("Kyrie");
        System.out.println("mySet1: " + mySet1);

        mySet1.remove("Lebron");

        System.out.println("mySet1: " + mySet1);


        Set<String> mySet2 = Set.of("Lebron", "Kyrie", "Kobe");

        // create the iterator outside the loop to prevent infinite loop
        Iterator iterator = mySet2.iterator();

        while(iterator.hasNext()){
            System.out.println("set: " + iterator.next());
            if(iterator.next().equals("Kyrie")){
                break;
            }
        };



    }

}
