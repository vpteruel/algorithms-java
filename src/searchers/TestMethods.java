package searchers;

import java.util.Arrays;

import sorters.comparison.QuickSort;

public class TestMethods {

    public void hasPairWithSum() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};
        int sum = 6;

        System.out.println("########### Has Pair With Sum ###########");

        boolean hasPair = HasPairWithSum.search(unsortedArray, sum);

        String msg1 = String.format("Sum: %d", sum);
        String msg2 = String.format("Has pair: %b", hasPair);

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void linearSearch() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};
        int targetElement = 3;

        System.out.println("########### Linear Search ###########");

        int foundTarget = LinearSearch.search(unsortedArray, targetElement);

        String msg1 = String.format("Numbers: %s.", Arrays.toString(unsortedArray));
        String msg2 = String.format("Target: %d", targetElement);
        String msg3 = String.format(foundTarget != -1 ? "Found" : "Not found");

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);
    }

    public void binarySearch() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};
        int targetElement = 3;

        System.out.println("########### Binary Search ###########");

        QuickSort.sort(unsortedArray);

        int index = BinarySearch.search(unsortedArray, targetElement, 0, unsortedArray.length - 1);

        System.out.println("Element found at index: " + index);
    }
}
