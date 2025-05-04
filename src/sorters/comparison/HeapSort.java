package sorters.comparison;

public class HeapSort {

    /**
     * Sorts the array using the heap sort algorithm.
     *
     * @param array the array to sort
     */
    public static void sort(int[] array) {
        int n = array.length; // Get the length of the array
        
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i); // Heapify each subtree
        }
        
        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (largest element) to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }
    
    /**
     * Heapifies a subtree rooted with node i which is an index in array[].
     * n is the size of the heap.
     *
     * @param array the array representing the heap
     * @param n the size of the heap
     * @param i the index of the root node of the subtree
     */
    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index
        
        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        
        // If largest is not root
        if (largest != i) {
            // Swap the root with the largest element
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            
            // Recursively heapify the affected subtree
            heapify(array, n, largest);
        }
    }
}
