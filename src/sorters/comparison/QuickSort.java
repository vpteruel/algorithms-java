package sorters.comparison;

public class QuickSort {
    
    /**
     * Sorts the data array using the quick sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        if (data == null || data.length < 2) {
            return; // If the array is null or has less than 2 elements, no need to sort
        }
        quickSort(data, 0, data.length - 1); // Call the quickSort method with the array, and the start and end indices
    }

    /**
     * Recursively sorts the array using the quick sort algorithm.
     *
     * @param data the array to sort
     * @param low the starting index of the subarray
     * @param high the ending index of the subarray
     */
    private static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(data, low, high); // Partition the array and get the pivot index
            quickSort(data, low, pivotIndex - 1); // Recursively sort the left subarray
            quickSort(data, pivotIndex + 1, high); // Recursively sort the right subarray
        }
    }

    /**
     * Partitions the array around a pivot element.
     *
     * @param data the array to partition
     * @param low the starting index of the subarray
     * @param high the ending index of the subarray
     * @return the index of the pivot element after partitioning
     */
    private static int partition(int[] data, int low, int high) {
        int pivot = data[high]; // Choose the last element as the pivot
        int i = low - 1; // Initialize the index of the smaller element
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                swap(data, i, j); // Swap elements if the current element is less than or equal to the pivot
            }
        }
        swap(data, i + 1, high); // Swap the pivot element with the element at i+1
        return i + 1; // Return the index of the pivot element
    }

    /**
     * Swaps two elements in the array.
     *
     * @param data the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
