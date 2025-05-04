package searchers;

public class BinarySearch {
    
    /**
     * Performs a binary search to find the index of the target element in the sorted data array (recursive approach).
     *
     * @param data         the sorted array to search in
     * @param targetElement the element to search for
     * @param left         the left index of the search range
     * @param right        the right index of the search range
     * @return the index of the target element if found, otherwise -1
     */
    public static int search(int[] data, int targetElement, int left, int right) {
        if (left > right) {
            return -1; // Base case: element not found
        }

        int mid = left + (right - left) / 2;

        if (data[mid] == targetElement) {
            return mid; // Target element found
        } else if (data[mid] < targetElement) {
            return search(data, targetElement, mid + 1, right); // Search in the right half
        } else {
            return search(data, targetElement, left, mid - 1); // Search in the left half
        }
    }
}
