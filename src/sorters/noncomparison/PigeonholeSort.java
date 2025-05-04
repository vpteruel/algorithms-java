package sorters.noncomparison;

public class PigeonholeSort {
    
    /**
     * Sorts the data array using the pigeonhole sort algorithm.
     *
     * @param data the array to sort
     */
    public static void sort(int[] data) {
        if (data == null || data.length == 0) {
            return; // If the array is null or empty, no need to sort
        }

        // Find the maximum and minimum values in the array
        int min = data[0];
        int max = data[0];
        for (int num : data) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        // Create an array to store the occurrences of each element
        int range = max - min + 1;
        int[] pigeonholes = new int[range];

        // Count the occurrences of each element in the array
        for (int num : data) {
            pigeonholes[num - min]++;
        }

        // Reconstruct the sorted array using the pigeonholes array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (pigeonholes[i] > 0) {
                data[index++] = i + min;
                pigeonholes[i]--;
            }
        }
    }
}
