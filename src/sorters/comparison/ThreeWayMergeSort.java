package sorters.comparison;

public class ThreeWayMergeSort {
    
    /**
     * Sorts the array using the three-way merge sort algorithm.
     *
     * @param array the array to sort
     */
    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return; // If the array is null or has less than 2 elements, no need to sort
        }
        int[] temp = new int[array.length]; // Temporary array for merging
        threeWayMergeSort(array, temp, 0, array.length - 1); // Call the threeWayMergeSort method with the array, temporary array, and start and end indices
    }

    private static void threeWayMergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return; // Base case: if the subarray has one or zero elements, it's already sorted
        }

        int third = (right - left + 1) / 3; // Calculate the size of each third
        int mid1 = left + third; // Calculate the first midpoint
        int mid2 = left + 2 * third; // Calculate the second midpoint

        // Recursively sort the three subarrays
        threeWayMergeSort(array, temp, left, mid1);
        threeWayMergeSort(array, temp, mid1 + 1, mid2);
        threeWayMergeSort(array, temp, mid2 + 1, right);

        // Merge the three sorted subarrays
        merge(array, temp, left, mid1, mid2, right);
    }

    private static void merge(int[] array, int[] temp, int left, int mid1, int mid2, int right) {
        int i = left; // Initialize the pointer for the first subarray
        int j = mid1 + 1; // Initialize the pointer for the second subarray
        int k = mid2 + 1; // Initialize the pointer for the third subarray
        int l = left; // Initialize the pointer for the temporary array

        // Merge the three subarrays into the temporary array
        while (i <= mid1 && j <= mid2 && k <= right) {
            if (array[i] <= array[j] && array[i] <= array[k]) {
                temp[l++] = array[i++];
            } else if (array[j] <= array[i] && array[j] <= array[k]) {
                temp[l++] = array[j++];
            } else {
                temp[l++] = array[k++];
            }
        }

        // Merge the remaining elements of the first and second subarrays
        while (i <= mid1 && j <= mid2) {
            temp[l++] = (array[i] <= array[j]) ? array[i++] : array[j++];
        }

        // Merge the remaining elements of the second and third subarrays
        while (j <= mid2 && k <= right) {
            temp[l++] = (array[j] <= array[k]) ? array[j++] : array[k++];
        }

        // Merge the remaining elements of the first and third subarrays
        while (i <= mid1 && k <= right) {
            temp[l++] = (array[i] <= array[k]) ? array[i++] : array[k++];
        }

        // Copy the remaining elements of the first subarray
        while (i <= mid1) {
            temp[l++] = array[i++];
        }

        // Copy the remaining elements of the second subarray
        while (j <= mid2) {
            temp[l++] = array[j++];
        }

        // Copy the remaining elements of the third subarray
        while (k <= right) {
            temp[l++] = array[k++];
        }

        // Copy the merged elements back into the original array
        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }
}
