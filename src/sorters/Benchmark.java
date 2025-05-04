package sorters;

import java.util.Hashtable;
import java.util.Map;

import helpers.ArrayHelper;
import helpers.ExecutionTimeHelper;
import helpers.PrinterBenchmarkHelper;
import sorters.comparison.BubbleSort;
import sorters.comparison.CycleSort;
import sorters.comparison.HeapSort;
import sorters.comparison.InsertionSort;
import sorters.comparison.MergeSort;
import sorters.comparison.QuickSort;
import sorters.comparison.SelectionSort;
import sorters.comparison.ThreeWayMergeSort;
import sorters.hybrid.IntroSort;
import sorters.noncomparison.BucketSort;
import sorters.noncomparison.CombSort;
import sorters.noncomparison.CountingSort;
import sorters.noncomparison.PigeonholeSort;
import sorters.noncomparison.RadixSort;
import sorters.noncomparison.TimSort;

public class Benchmark {

    private int arraySize;
    private Map<String, Long> results;

    public Benchmark() {
    }

    public Benchmark setup(int arraySize) {
        this.arraySize = arraySize;
        this.results = new Hashtable<>();
        return this;
    }

    public void executeSorters() {
        // comparison based
        results.put("Bubble sort", measureTime(() -> BubbleSort.sort(generateRandomArray())));
        results.put("Cycle sort", measureTime(() -> CycleSort.sort(generateRandomArray())));
        results.put("Heap sort", measureTime(() -> HeapSort.sort(generateRandomArray())));
        results.put("Insertion sort", measureTime(() -> InsertionSort.sort(generateRandomArray())));
        results.put("Merge sort", measureTime(() -> MergeSort.sort(generateRandomArray())));
        results.put("Quick sort", measureTime(() -> QuickSort.sort(generateRandomArray())));
        results.put("Selection sort", measureTime(() -> SelectionSort.sort(generateRandomArray())));
        results.put("Three-way merge sort", measureTime(() -> ThreeWayMergeSort.sort(generateRandomArray())));
        // non-comparison based
        results.put("Bucket sort", measureTime(() -> BucketSort.sort(generateRandomArray())));
        results.put("Comb sort", measureTime(() -> CombSort.sort(generateRandomArray())));
        results.put("Counting sort", measureTime(() -> CountingSort.sort(generateRandomArray())));
        results.put("Pigeonhole sort", measureTime(() -> PigeonholeSort.sort(generateRandomArray())));
        results.put("Radix sort", measureTime(() -> RadixSort.sort(generateRandomArray())));
        results.put("Tim sort", measureTime(() -> TimSort.sort(generateRandomArray())));
        // hybrid
        results.put("Intro sort", measureTime(() -> IntroSort.sort(generateRandomArray())));

        PrinterBenchmarkHelper.print(results);
    }

    private long measureTime(Runnable method) {
        return ExecutionTimeHelper.measureTime(method);
    }

    private int[] generateRandomArray() {
        return ArrayHelper.generateRandomArray(arraySize);
    }
}
