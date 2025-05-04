package helpers;

import java.util.concurrent.TimeUnit;

public class ExecutionTimeHelper {

    public static long measureTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        return duration;
    }

    public static String formatTime(long nanoSeconds) {
        long seconds = TimeUnit.NANOSECONDS.toSeconds(nanoSeconds);
        long milliseconds = TimeUnit.NANOSECONDS.toMillis(nanoSeconds) - TimeUnit.SECONDS.toMillis(seconds);
        long microseconds = TimeUnit.NANOSECONDS.toMicros(nanoSeconds) - TimeUnit.SECONDS.toMicros(seconds) - TimeUnit.MILLISECONDS.toMicros(milliseconds);
        return String.format("%02ds %03dms %04dµs", seconds, milliseconds, microseconds);
    }
}
