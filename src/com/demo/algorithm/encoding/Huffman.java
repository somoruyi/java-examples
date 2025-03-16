package com.demo.algorithm.encoding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


/**
 *
 * @author Amin Mohamed
 *
 */
public class Huffman<T> implements TreeNode<T> {

    private Map<Character, String> encodingMap;
    private TreeNode<Character> decodingTree;
    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;



    // uses factory method for instance creation
    private Huffman(TreeNode<T> leftChild, TreeNode<T> rightChild) {
    }
    private Huffman() {
    }


    @Override
    public TreeNode<T> getLeftChild() {
        return this.leftChild;
    }
    @Override
    public TreeNode<T> getRightChild() {
        return this.rightChild;
    }
    @Override
    public T getValue() {
        return this.value;
    }


    public static Huffman build(String filePath) {


        try(BufferedReader fileInput = new BufferedReader(new FileReader(filePath))){

            // 

            HashMap<Character,Integer> frequencies = new HashMap<>(); // creates a frequency map to store character frequencies 

            int charCode;
            // read through the file
            while ((charCode = fileInput.read()) != -1) {
                char character = (char) charCode;
                frequencies.put((char) charCode, frequencies.getOrDefault(character, 0) + 1);// get frequency then add 1
            }
            // Sort into the priority queue with smallest value at the head of the queue by frequencies
            PriorityQueue<Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Entry::getValue));
            priorityQueue.addAll(frequencies.entrySet());

            int queueSize = priorityQueue.size();
            for(int i = 0; i < queueSize - 1; i++) {
                Entry<Character, Integer> leftNode = priorityQueue.poll();
                Entry<Character, Integer> rightNode= priorityQueue.poll();
                int sumFrequency = leftNode.getValue() + rightNode.getValue();

                Huffman<Character> leftChildNode = new Huffman<>();
                Huffman<Character> rightChildNode = new Huffman<>();
                Huffman<Character> parentNode = new Huffman<>(leftChildNode, rightChildNode);

                priorityQueue.offer((Entry<Character, Integer>) parentNode);
            }

            // make the encoding map
            Huffman<Character> rootNode = new Huffman<>();



            fileInput.close();
        } catch (IOException ioException) {
            throw new RuntimeException("Cant build the Huffman Tree", ioException);
        }


        return null;

    }
    public String encode(String text) {
        return null;
    }
    public String Decode(String code) {
        return null;

    }
    public Map <Character, String> getEncodingMap(){
        return encodingMap;

    }
    public TreeNode<Character> getDecodingTree(){
        return decodingTree;

    }
}