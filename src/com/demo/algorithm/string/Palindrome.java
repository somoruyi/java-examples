package com.demo.algorithm.string;

import java.util.Arrays;

public class Palindrome {

    public static void main(String[] word){
        System.out.println(" --main() --");
        Palindrome pal = new Palindrome();

//        System.out.println(pal.reverseWord("sasa"));
//        System.out.println(pal.reverseWord("edde"));
        System.out.println(pal.reverseWord2("edede"));
    }

    /**
     * This method, reverseWord, seems to aim at checking whether the input string is a palindrome (a word, phrase, or sequence that reads the same backward as forward).
     * <br>
     * {@code String[] word = str.split(regex)}
     * <br>
     * {@code String str = Arrays.toString(Object[])}
     *
     *
     */
    public Boolean reverseWord(String str){
        System.out.println(" -- reverseWord() --");
        String[] word = str.split("");

        Boolean result = true;

        System.out.println("word: " + Arrays.toString(word) + "\nlen: " + word.length);
        int i = 0;
        int j = word.length-1;
        while(i < word.length){
            System.out.print(word[i] + " ");
            i++;
            j--;
        }
        System.out.println("");
        i = 0;
        j = word.length-1; // important to start j here or it will be out of bounds
        while(i <= j){ // more efficient to compare i<j because the word was flipped
                       // also the <= makes it so you are comparing the middle of an odd length
            /*
                 0 < 3
                 1 <= 2 will only go through 3 iterations because this word has been reversed. Also if these word is odd we dont even need to check.
                 2 < 1
                 3 < 0

                 0 < 4
                 1 < 3
                 2 < 2 will only go through 3 iterations because this word has been reversed. Also if these word is odd we dont even need to check.
                 3 < 1
                 4 < 0
             */
            if(word[i].equals(word[j])) { // important when comparing two strings == will not work
                System.out.print(word[j] + " ");
                System.out.println("equal");
                System.out.println("hash " + word[i].hashCode() + " = " + word[j].hashCode());

            }else{
                System.out.println("i index " + i + " & " + word[i] + " no match");
                System.out.println("j index " + j + " & " + word[j] + " no match");
                result = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println("");
        return result;
    }
    public Boolean reverseWord2(String str){
        System.out.println(" -- reverseWord2() --");
        String[] word = str.split("");
        String[] reversedWord = new String[word.length];


        int j = reversedWord.length-1;
        for(String w: word){
            reversedWord[j] = w;

            j--;
        }
        System.out.println(Arrays.toString(word));
        System.out.println(Arrays.toString(reversedWord));
        // array1.equals(array2): Checks if both array references point to the same object in memory.
        if (Arrays.equals(word, reversedWord)){ // Compares the contents of the arrays element by element.
            System.out.println("hash " + Arrays.hashCode(word) + " = " + Arrays.hashCode(reversedWord));
            return true;
        }
        return false;
    }

    public String reverse(String phrase) {

        String[] str = phrase.split("");

        String reversedString = "";

        for(int i = str.length-1; i>-1; i--){
            reversedString += str[i];
        }

        return reversedString;

    }

}
