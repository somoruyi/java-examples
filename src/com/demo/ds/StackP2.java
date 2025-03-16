package com.demo.ds;

/**
 * {@link https://www.youtube.com/watch?app=desktop&v=Fccje3W6oBk}
 */
public class StackP2 {
    private int[] stack;
    private int size; // index
    private static final int INITIAL_SIZE = 10;

    public StackP2(){
        stack = new int[INITIAL_SIZE];
        size  = 0;
    }

    /**
     * Pushes a new value on the top of the stack
     * @param value
     */
    public void push(int value){
        if(size == stack.length){ // size is index
            // full
            doubleCapacity();
        }
        stack[size] = value;
        size++;
    }

    public int pop(){
        // check if element is empty first
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int result = stack[size-1];
        stack[size-1] = 0; // blank out
        size--;

        return result;
    }


    /**
     * Creates a new array twice as big as the orig
     * access modifier is private because only this class will use it
     */
    private void doubleCapacity(){
        int newCapacity = 2*stack.length;
        int[] newStack = new int[newCapacity];
        for(int i=0; i<stack.length; i++){
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

}
