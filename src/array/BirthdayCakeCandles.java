package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BirthdayCakeCandles {
    public static int birthdayCakeCandles(List<Integer> candles) {
        // Find the maximum candle height
        int maxHeight = Collections.max(candles);

        // Count how many candles have that max height
        int count = 0;
        for (int c : candles) {
            if (c == maxHeight) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> testCandles1 = Arrays.asList(3, 2, 1, 3);
        int result1 = birthdayCakeCandles(testCandles1);
        System.out.println("Test 1 Result: " + result1); // Expected: 2

        // Example 2
        List<Integer> testCandles2 = Arrays.asList(4, 4, 1, 2, 4);
        int result2 = birthdayCakeCandles(testCandles2);
        System.out.println("Test 2 Result: " + result2); // Expected: 3

        // Example 3
        List<Integer> testCandles3 = Arrays.asList(1, 2, 3, 4, 5);
        int result3 = birthdayCakeCandles(testCandles3);
        System.out.println("Test 3 Result: " + result3); // Expected: 1
    }
}
