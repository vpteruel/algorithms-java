package sorters.comparison;

public class InsertionSort {

    /**
     * Sorts the data array using the insertion sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        int n = data.length; // Length of the array

        // Iterate through the array elements
        for (int i = 1; i < n; i++) {
            int key = data[i]; // Store the current element
            int j = i - 1; // Index of the previous element

            // Move elements of the sorted part of the array that are greater than the key
            // to one position ahead of their current position
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key; // Insert the key at its correct position
        }
    }
}
