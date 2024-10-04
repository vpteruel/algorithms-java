package domain;

import java.util.Arrays;

public class Searcher {

    /**
     * Performs a linear search to find the index of the target element in the data array.
     * 
     * @param data         the array to search in
     * @param targetElement the element to search for
     * @return the index of the target element if found, otherwise -1
     */
    public int linearSearch(int[] data, int targetElement) {
        // Iterate through the array to find the target element
        for (int i = 0; i < data.length; i++) {
            if (data[i] == targetElement) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if the target element is not found
    }

    /**
     * Checks if there are two numbers in the data array that add up to a given sum.
     * 
     * @param data the array to search in
     * @param sum  the target sum to find
     * @return true if a pair exists, otherwise false
     */
    public boolean hasPairWithSum(int[] data, int sum) {
        int[] complements = new int[data.length]; // Array to store complements
        int i = 0; // Index for complements array

        // Iterate through each value in the data array
        for (int value : data) {
            // Check if the current value is a complement of a previous number
            if (Arrays.stream(complements).anyMatch(x -> x == value)) {
                return true; // Return true if a pair is found
            }
            // Store the complement needed to reach the target sum
            complements[i++] = sum - value;
        }
        return false; // Return false if no pairs found
    }

    /**
     * Sorts the data array using the bubble sort algorithm.
     * 
     * @param data the array to sort
     */
    public void bubbleSort(int[] data) {
        int n = data.length; // Length of the array
        boolean swapped; // Flag to check if a swap occurred

        do {
            swapped = false; // Reset the swap flag for the current pass

            // Iterate through the array elements
            for (int i = 1; i < n; i++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (data[i - 1] > data[i]) {
                    int temp = data[i - 1]; // Store the current element
                    data[i - 1] = data[i]; // Move the next element to the left
                    data[i] = temp; // Place the stored element to the right

                    swapped = true; // Set the flag to true indicating a swap occurred
                }
            }
            // Reduce the range for the next iteration as the last element is sorted
            n--;
        } while (swapped); // Continue until no swaps are needed
    }

    /**
     * Performs a binary search to find the index of the target element in the sorted data array.
     * 
     * @param data         the sorted array to search in
     * @param targetElement the element to search for
     * @return the index of the target element if found, otherwise -1
     */
    public int binarySearch(int[] data, int targetElement) {
        // Ensure the data is sorted before performing binary search
        bubbleSort(data); // Sort the array

        int left = 0; // Left index of the search range
        int right = data.length - 1; // Right index of the search range

        // Continue searching while the left index is less than or equal to the right index
        while (left <= right) {
            // Calculate the mid index
            int mid = left + (right - left) / 2;

            // Check if the targetElement is present at mid
            if (data[mid] == targetElement) {
                return mid; // Return the mid index if found
            }

            // If target is greater, ignore the left half
            if (data[mid] < targetElement) {
                left = mid + 1; // Move the left index to the right of mid
            } else {
                // If target is smaller, ignore the right half
                right = mid - 1; // Move the right index to the left of mid
            }
        }

        return -1; // Return -1 if the target element is not found
    }
}
