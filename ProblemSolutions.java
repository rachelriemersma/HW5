/******************************************************************
 *
 *   Rachel Riemersma / 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        // Create HashSet for list1
        Set<Integer> set  = new HashSet<>();
        // Add numbers into HashSet
        for (int num : list1) {
            set.add(num);
        }
        // Assume that list2 is a subset of list1
        boolean isSubset = true;
        // Traverse through list2
        for (int num : list2) {
            // If any value from list2 is not in the set made from list1, it is not a subset
            if (!set.contains(num)) {
                isSubset = false;
            }
        }
        return isSubset;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        // Create a min heap to keep track of k largest elements (smallest at root)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Loop through numbers in the array
        for (int num : array) {
            // Adds the number to the heap
            minHeap.offer(num);
            // If there is more than k elements, remove the smallest one
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int result = -1;
        // Root of heap has k-th largest element
        if (!minHeap.isEmpty()) {
            result = minHeap.peek();
        }
        return result;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        // Create min heap to sort the elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Add elements from array1 to heap
        for (int num : array1) {
            minHeap.offer(num);
        }
        // Add elements from array2 to heap
        for (int num : array2) {
            minHeap.offer(num);
        }
        // Array with total number of elements from both arrays (size of heap)
        int[] result = new int[minHeap.size()];
        int i = 0;
        // Poll elements from the heap (removes smallest and adds it to result)
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll();
            i++;
        }
        return result;
    }
}
