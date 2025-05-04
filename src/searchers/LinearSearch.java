package searchers;

public class LinearSearch {

    /**
     * Performs a linear search to find the index of the target element in the data array.
     * 
     * @param data         the array to search in
     * @param targetElement the element to search for
     * @return the index of the target element if found, otherwise -1
     */
    public static int search(int[] data, int targetElement) {
        // Iterate through the array to find the target element
        for (int i = 0; i < data.length; i++) {
            if (data[i] == targetElement) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if the target element is not found
    }
}
