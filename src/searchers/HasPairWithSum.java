package searchers;

import java.util.Arrays;

public class HasPairWithSum {

    /**
     * Checks if there are two numbers in the data array that add up to a given sum.
     * 
     * @param data the array to search in
     * @param sum  the target sum to find
     * @return true if a pair exists, otherwise false
     */
    public static boolean search(int[] data, int sum) {
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
}
