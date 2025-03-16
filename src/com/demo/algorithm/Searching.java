package com.demo.algorithm;

public class Searching {


    public static void main(String[] args) {
        // binary search
        int[] arr = {2, 4, 7, 9, 11, 13, 15};
        int target = 11;
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }

    /**
     * <h3>Binary Search</h3>
     * Starts from the mid and goes left or right
     * <pre>
     * low = 0
     * high = length-1
     * mid = (length-1)/2
     * </pre>
     * @param arr
     * @param target
     * @return index
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index; // Element not found
    }
}
