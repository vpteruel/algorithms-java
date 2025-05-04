package sorters;

import java.util.Arrays;

import sorters.comparison.BubbleSort;
import sorters.comparison.InsertionSort;
import sorters.comparison.MergeSort;
import sorters.comparison.QuickSort;
import sorters.comparison.SelectionSort;
import sorters.noncomparison.BucketSort;
import sorters.noncomparison.CountingSort;
import sorters.noncomparison.RadixSort;

public class TestMethods {

    public void testAll() {
        // comparison based
        bubbleSort();
        insertionSort();
        mergeSort();
        quickSort();
        selectionSort();
        // non-comparison based
        countingSort();
        radixSort();
        bucketSort();
    }
    
    public void bubbleSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Bubble Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        BubbleSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void insertionSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Insertion Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        InsertionSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void mergeSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Merge Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        MergeSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void quickSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Quick Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        QuickSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void selectionSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Selection Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        SelectionSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void countingSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Counting Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        CountingSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void radixSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Radix Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        RadixSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public void bucketSort() {
        int[] unsortedArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};

        System.out.println("########### Bucket Sort ###########");

        String msg1 = String.format("Unsorted array: %s", Arrays.toString(unsortedArray));

        BucketSort.sort(unsortedArray);

        String msg2 = String.format("Sorted array: %s", Arrays.toString(unsortedArray));

        System.out.println(msg1);
        System.out.println(msg2);
    }
}
