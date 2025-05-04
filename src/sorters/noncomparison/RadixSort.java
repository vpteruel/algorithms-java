package sorters.noncomparison;

public class RadixSort {

    /**
     * Sorts the data array using the radix sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        if (data == null || data.length == 0) {
            return; // If the array is null or empty, no need to sort
        }
        int max = getMax(data); // Find the maximum number to determine the number of digits
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(data, exp); // Perform counting sort on each digit
        }
    }

    /**
     * Finds the maximum value in the array.
     *
     * @param data the array to search
     * @return the maximum value in the array
     */
    private static int getMax(int[] data) {
        int max = data[0];
        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Performs counting sort on the array based on the digit represented by exp.
     *
     * @param data the array to sort
     * @param exp the exponent representing the digit to sort by (1 for units, 10 for tens, etc.)
     */
    private static void countingSortByDigit(int[] data, int exp) {
        int n = data.length;
        int[] output = new int[n]; // Output array to store sorted numbers
        int[] count = new int[10]; // Count array to store the count of occurrences of each digit

        // Count the occurrences of each digit in the array
        for (int i = 0; i < n; i++) {
            count[(data[i] / exp) % 10]++;
        }

        // Update the count array to contain the actual positions of the digits in the output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array by placing the elements in their correct positions
        for (int i = n - 1; i >= 0; i--) {
            output[count[(data[i] / exp) % 10] - 1] = data[i];
            count[(data[i] / exp) % 10]--;
        }

        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, data, 0, n);
    }
}
