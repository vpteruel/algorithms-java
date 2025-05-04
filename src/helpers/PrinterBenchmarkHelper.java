package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PrinterBenchmarkHelper {

    public static void print(Map<String, Long> results) {
        List<Map.Entry<String, Long>> sortedResults = new ArrayList<>(results.entrySet());
        // sortedResults.sort(Map.Entry.comparingByValue());

        // Determine the minimum and maximum execution times
        // long minTime = sortedResults.get(0).getValue();
        // long maxTime = sortedResults.get(sortedResults.size() - 1).getValue();
        // Determine the minimum and maximum execution times using streams
        long minTime = results.values().stream().min(Long::compare).orElseThrow(NoSuchElementException::new);
        long maxTime = results.values().stream().max(Long::compare).orElseThrow(NoSuchElementException::new);
        double media = results.values().stream().mapToLong(Long::longValue).average().orElse(0.0);
        long median = results.values().stream().sorted().skip(results.size() / 2).findFirst()
                .orElseThrow(NoSuchElementException::new);

        // ANSI escape codes for colors
        String reset = "\u001B[0m";
        String green = "\u001B[32m";
        String red = "\u001B[31m";
        String yellow = "\u001B[33m";
        String orange = "\u001B[38;5;208m";

        System.out.println("+----------------------+----------------+------------------+");
        System.out.println("| Method               | Execution Time | Formated Time    |");
        System.out.println("+----------------------+----------------+------------------+");
        for (Map.Entry<String, Long> entry : sortedResults) {
            String key = entry.getKey();
            long value = entry.getValue();
            String formattedTime = ExecutionTimeHelper.formatTime(value);

            String color = reset;
            if (value == minTime) {
                color = green;
            } else if (value == maxTime) {
                color = red;
            } else if (value == median) {
                color = orange;
            }

            System.out.printf("|" + color + " %-20s " + reset + "|" + color + " %-14s " + reset + "|" + color
                    + " %-16s " + reset + "|\n", key, value, formattedTime);
        }
        System.out.println("+----------------------+----------------+------------------+");

        // Print media (mean) with colors
        System.out.printf(yellow + "Media (Mean) Execution Time: %s\n" + reset,
                ExecutionTimeHelper.formatTime((long) media));
    }
}
