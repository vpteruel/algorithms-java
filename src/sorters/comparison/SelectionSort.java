package sorters.comparison;

public class SelectionSort {
    
    /**
     * Sorts the data array using the selection sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        int n = data.length; // Length of the array

        // Iterate through the array elements
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Index of the minimum element

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first element of the unsorted part
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }
}
