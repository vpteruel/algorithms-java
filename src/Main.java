import domain.Searcher;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Searcher searcher = new Searcher();

        int[] unsortedArray = { 5, 2, 8, 1, 9, 4, 7, 3, 6 };
        int targetElement = 5;

        // #######################
        System.out.println("########### Linear Search ###########");

        int foundTarget = searcher.linearSearch(unsortedArray, targetElement);

        String msg1 = String.format("Numbers: %s.", Arrays.toString(unsortedArray));
        String msg2 = String.format("Target: %d", targetElement);
        String msg3 = String.format(foundTarget != -1 ? "Found" : "Not found");

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);

        // #######################
        System.out.println("########### Has Pair With Sum ###########");

        int sum = 6;

        boolean hasPair = searcher.hasPairWithSum(unsortedArray, sum);

        String msg4 = String.format("Sum: %d", sum);
        String msg5 = String.format("Has pair: %b", hasPair);

        System.out.println(msg4);
        System.out.println(msg5);

        // #######################
        System.out.println("########### Bubble Sort ###########");

        String msg6 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        searcher.bubbleSort(unsortedArray);

        String msg7 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg6);
        System.out.println(msg7);

        // #######################
        System.out.println("########### Binary Search ###########");

        int index = searcher.binarySearch(unsortedArray, targetElement);

        System.out.println("Element found at index: " + index);
    }
}