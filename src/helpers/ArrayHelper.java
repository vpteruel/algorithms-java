package helpers;

import java.util.Random;

public class ArrayHelper {

    public static int[] generateRandomArray(int arraySize) {
        int[] unsortedArray = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            unsortedArray[i] = random.nextInt(9999999);
        }

        return unsortedArray;
    }
}