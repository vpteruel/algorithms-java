package sorters.comparison;

public class CycleSort {
    
    /**
     * Sorts the array using the cycle sort algorithm.
     *
     * @param array the array to sort
     */
    public static void sort(int[] array) {
        int n = array.length; // Get the length of the array
        
        // Traverse the array to cycle through each element
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = array[cycleStart]; // Get the current item
            
            // Find the position where the item should be placed
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) {
                if (array[i] < item) {
                    pos++;
                }
            }
            
            // If the item is already in the correct position
            if (pos == cycleStart) {
                continue; // Skip to the next element
            }
            
            // Skip duplicates
            while (item == array[pos]) {
                pos++;
            }
            
            // Swap the item with the element at the correct position
            int temp = array[pos];
            array[pos] = item;
            item = temp;
            
            // Rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                
                // Find the position where the item should be placed
                for (int i = cycleStart + 1; i < n; i++) {
                    if (array[i] < item) {
                        pos++;
                    }
                }
                
                // Skip duplicates
                while (item == array[pos]) {
                    pos++;
                }
                
                // Swap the item with the element at the correct position
                temp = array[pos];
                array[pos] = item;
                item = temp;
            }
        }
    }
}
