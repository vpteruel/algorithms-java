package sorters.comparison;

public class BubbleSort {
    
    /**
     * Sorts the data array using the bubble sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
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
}
