package searchers;

import java.util.Hashtable;
import java.util.Map;

import helpers.ArrayHelper;
import helpers.ExecutionTimeHelper;
import helpers.PrinterBenchmarkHelper;
import sorters.comparison.QuickSort;

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

    public void executeSearchers() {
        results.put("Has pair with sum", hasPairWithSumCalcTime());
        results.put("Linear search", linearSearchCalcTime());
        results.put("Binary search", binarySearchCalcTime());

        PrinterBenchmarkHelper.print(results);
    }

    public long hasPairWithSumCalcTime() {
        int[] unsortedArray = ArrayHelper.generateRandomArray(this.arraySize);
        int sum = 6;

        return ExecutionTimeHelper
                .measureTime(() -> HasPairWithSum.search(unsortedArray, sum));
    }

    public long linearSearchCalcTime() {
        int[] unsortedArray = ArrayHelper.generateRandomArray(this.arraySize);
        int targetElementFirst = unsortedArray[0];
        int targetElementLast = unsortedArray[unsortedArray.length - 1];

        return ExecutionTimeHelper
                .measureTime(() -> LinearSearch.search(unsortedArray, targetElementLast));
    }

    public long binarySearchCalcTime() {
        int[] unsortedArray = ArrayHelper.generateRandomArray(this.arraySize);
        int targetElementFirst = unsortedArray[0];
        int targetElementLast = unsortedArray[unsortedArray.length - 1];

        QuickSort.sort(unsortedArray);

        return ExecutionTimeHelper
                .measureTime(() -> BinarySearch.search(unsortedArray, targetElementLast, 0, unsortedArray.length - 1));
    }
}
