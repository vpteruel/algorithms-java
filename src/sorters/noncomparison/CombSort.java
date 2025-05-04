package sorters.noncomparison;

public class CombSort {
    
    /**
     * Sorts the data array using the comb sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        if (data == null || data.length == 0) {
            return; // If the array is null or empty, no need to sort
        }

        int gap = data.length; // Initialize the gap size to the length of the array
        double shrink = 1.3; // Shrink factor to reduce the gap size
        boolean sorted = false; // Flag to indicate if the array is sorted

        while (!sorted) {
            gap = (int) (gap / shrink); // Reduce the gap size
            if (gap > 1) {
                sorted = false; // If the gap is greater than 1, the array is not yet sorted
            } else {
                gap = 1; // If the gap is 1, set it to 1 and assume the array is sorted
                sorted = true;
            }

            int i = 0;
            while (i + gap < data.length) {
                if (data[i] > data[i + gap]) {
                    // Swap elements if they are in the wrong order
                    int temp = data[i];
                    data[i] = data[i + gap];
                    data[i + gap] = temp;
                    sorted = false; // Set sorted to false as a swap was made
                }
                i++;
            }
        }
    }
}
