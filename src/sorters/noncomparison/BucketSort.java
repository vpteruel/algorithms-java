package sorters.noncomparison;

public class BucketSort {
    
    /**
     * Sorts the data array using the bucket sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        if (data == null || data.length == 0) {
            return; // If the array is null or empty, no need to sort
        }

        // Find the maximum value in the array to determine the range of the count array
        int max = data[0];
        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }

        // Initialize the count array with a size of max + 1
        int[] count = new int[max + 1];

        // Count the occurrences of each element in the array
        for (int num : data) {
            count[num]++;
        }

        // Reconstruct the sorted array using the count array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                data[index++] = i;
                count[i]--;
            }
        }
    }
}
