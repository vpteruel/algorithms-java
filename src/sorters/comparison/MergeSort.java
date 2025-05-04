package sorters.comparison;

public class MergeSort {
    
    /**
     * Sorts the data array using the merge sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        if (data == null || data.length < 2) {
            return; // If the array is null or has less than 2 elements, no need to sort
        }
        mergeSort(data, new int[data.length], 0, data.length - 1); // Call the mergeSort method with the array, a temporary array, and the start and end indices
    }

    /**
     * Recursively divides the array into halves and sorts each half.
     *
     * @param data the array to sort
     * @param temp a temporary array used for merging
     * @param leftStart the starting index of the left subarray
     * @param rightEnd the ending index of the right subarray
     */
    private static void mergeSort(int[] data, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return; // Base case: if the subarray has one or zero elements, it's already sorted
        }
        int middle = (leftStart + rightEnd) / 2; // Find the middle point to divide the array into two halves
        mergeSort(data, temp, leftStart, middle); // Recursively sort the left half
        mergeSort(data, temp, middle + 1, rightEnd); // Recursively sort the right half
        mergeHalves(data, temp, leftStart, rightEnd); // Merge the two sorted halves
    }

    /**
     * Merges two sorted halves of the array.
     *
     * @param data the array to sort
     * @param temp a temporary array used for merging
     * @param leftStart the starting index of the left subarray
     * @param rightEnd the ending index of the right subarray
     */
    private static void mergeHalves(int[] data, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2; // Find the end index of the left subarray
        int rightStart = leftEnd + 1; // Find the start index of the right subarray
        int size = rightEnd - leftStart + 1; // Calculate the total number of elements to be merged

        int left = leftStart; // Initialize the left pointer
        int right = rightStart; // Initialize the right pointer
        int index = leftStart; // Initialize the index for the temporary array

        // Merge the two halves into the temporary array
        while (left <= leftEnd && right <= rightEnd) {
            if (data[left] <= data[right]) {
                temp[index] = data[left];
                left++;
            } else {
                temp[index] = data[right];
                right++;
            }
            index++;
        }

        // Copy any remaining elements from the left subarray
        System.arraycopy(data, left, temp, index, leftEnd - left + 1);
        // Copy any remaining elements from the right subarray
        System.arraycopy(data, right, temp, index, rightEnd - right + 1);
        // Copy the merged elements back into the original array
        System.arraycopy(temp, leftStart, data, leftStart, size);
    }
}
