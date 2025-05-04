# algorithms-java

This project contains implementations of various algorithms in Java, including searching and sorting algorithms. The project is structured to demonstrate the functionality and performance of these algorithms.

## Project Structure

```bash
.
├── algorithms-java.iml
├── README.md
└── src
    ├── domain
    │   ├── helpers
    │   │   ├── ArrayHelper.java
    │   │   └── ExecutionTimeHelper.java
    │   ├── Searcher.java
    │   └── Sorter.java
    └── Main.java

```

## Algorithms

### Searching Algorithms

- **Linear Search**: A simple search algorithm that checks each element in the array sequentially.
  - Method: [`Searcher.linearSearch`](src/domain/Searcher.java)
  - Example Usage: [`Main.linearSearch`](src/Main.java)

- **Binary Search**: A more efficient search algorithm that works on sorted arrays by repeatedly dividing the search interval in half.
  - Method: [`Searcher.binarySearch`](src/domain/Searcher.java)
  - Example Usage: [`Main.binarySearch`](src/Main.java)

- **Pair with Sum**: Checks if there are two numbers in the array that add up to a given sum.
  - Method: [`Searcher.hasPairWithSum`](src/domain/Searcher.java)
  - Example Usage: [`Main.hasPairWithSum`](src/Main.java)

### Sorting Algorithms

- **Bubble Sort**: A simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
  - Method: [`Sorter.bubbleSort`](src/domain/Sorter.java)
  - Example Usage: [`Main.bubbleSort`](src/Main.java)

## Performance Measurement

The project includes methods to measure the performance of the algorithms:

- **Linear Search Performance**: [`Main.linearSearchCalcTime`](src/Main.java)
- **Binary Search Performance**: [`Main.binarySearchCalcTime`](src/Main.java)
- **Bubble Sort Performance**: [`Main.bubbleSortCalcTime`](src/Main.java)

## Utility Methods

- **Array Generator**: Generates an array of random integers.
  - Method: [`ArrayHelper.generateRandomArray`](src/domain/helpers/ArrayHelper.java)

- **Time Formatter**: Measures the performance for an operation.
  - Method: [`ExecutionTimeHelper.measureExecutionTime`](src/domain/helpers/ExecutionTimeHelper.java)

- **Time Formatter**: Formats the time taken for an operation.
  - Method: [`ExecutionTimeHelper.formatTime`](src/domain/helpers/ExecutionTimeHelper.java)

## How to Run

To run the project, execute the `main` method in the [`Main`](src/Main.java) class. This will run the performance measurements for the implemented algorithms.

```sh
javac src/Main.java
java src/Main
```

## License

This project is licensed under the MIT License.