// https://www.youtube.com/watch?app=desktop&v=Fccje3W6oBk  (17:49)

package com.demo.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class StackP {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        StackInterface<Integer> abs = new ArrayBoundedStack();

        System.out.printf("size: %d", abs.size());


        System.out.printf("pushed: %d", abs);
        System.out.println("");
        abs.popSome(5);

//        System.out.printf("size: %d", abs.size());
    }
}
class ArrayBoundedStack<T> implements StackInterface<T> {
    protected final int DEFCAP = 10; // default capacity

    /**
     * Example:
     * <pre>
     *     {@code Integer[] elements = new Integer[10]}
     *     ...
     *     elements = [1,2,3,4,5,6,7,8,9,10]
     * </pre>
     */
    protected T[] elements;           // holds stack elements
    protected int topIndex = -1;      // index of top element in stack

    public ArrayBoundedStack() {
        elements = (T[]) new Object[DEFCAP]; // 100 elements
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= topIndex; i++) {
            sb.append(elements[i]);
            if (i < topIndex) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return elements.length;
    }

        @Override
    public void popSome(int count) throws StackUnderflowException{
//        T obj;
//        T[] e = this.elements;

        System.out.println(this);  // this = toString()

        int index = count;
        int len = size();
        topIndex = len - 1;  // remove count number of elements

//        elements[topIndex] = null;

        System.out.println(this);
        System.out.println(size());

        if(false){
            throw new StackUnderflowException("Stack is empty.");
        }
    }
}

interface StackInterface<T>{

    /**
     * This algorithm is essentially traversing through the elements of the data structure and building a string representation of those elements.
     * @return String
     */
    String toString();
    int size();
    void popSome(int count) throws StackUnderflowException;
}

class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String message) {
        super(message);
    }
}