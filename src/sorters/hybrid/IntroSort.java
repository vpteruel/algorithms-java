package sorters.hybrid;

public class IntroSort {

    private static final int SIZE_THRESHOLD = 16; // Threshold for switching to InsertionSort

    /**
     * Sorts the array using the intro sort algorithm.
     *
     * @param array the array to sort
     */
    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return; // If the array is null or has less than 2 elements, no need to sort
        }
        int maxDepth = (int) (2 * Math.floor(Math.log(array.length) / Math.log(2))); // Calculate the maximum depth for recursion
        introSort(array, 0, array.length - 1, maxDepth); // Call the introSort method with the array, start and end indices, and maximum depth
    }

    private static void introSort(int[] array, int start, int end, int maxDepth) {
        int size = end - start + 1;
        if (size < SIZE_THRESHOLD) {
            insertionSort(array, start, end); // Switch to InsertionSort for small subarrays
        } else if (maxDepth == 0) {
            heapSort(array, start, end); // Switch to HeapSort if the maximum depth is reached
        } else {
            int pivot = partition(array, start, end); // Partition the array and get the pivot index
            introSort(array, start, pivot - 1, maxDepth - 1); // Recursively sort the left subarray
            introSort(array, pivot + 1, end, maxDepth - 1); // Recursively sort the right subarray
        }
    }

    private static void insertionSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= start && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void heapSort(int[] array, int start, int end) {
        int n = end - start + 1;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, start);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = array[start];
            array[start] = array[start + i];
            array[start + i] = temp;
            heapify(array, i, 0, start);
        }
    }

    private static void heapify(int[] array, int n, int i, int start) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[start + left] > array[start + largest]) {
            largest = left;
        }
        if (right < n && array[start + right] > array[start + largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = array[start + i];
            array[start + i] = array[start + largest];
            array[start + largest] = swap;
            heapify(array, n, largest, start);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
