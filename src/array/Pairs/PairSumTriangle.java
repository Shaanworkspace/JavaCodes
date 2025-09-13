package array.Pairs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairSumTriangle {

    // Optimized method using sorting + binary search
    public static int pairs(int k, List<Integer> arr) {
        // Sort the list first
        Collections.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            int target = arr.get(i) + k;
            // If target exists in list, binarySearch returns index >= 0
            if (Collections.binarySearch(arr, target) >= 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 2};
        int k = 5;

        // Brute force check only as a sanity test
        int bruteCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { // start from i+1
                int diff = arr[i] - arr[j];
                if (diff == k || diff == -k) {
                    bruteCount++;
                }
            }
        }

        int optimizedCount = pairs(k, Arrays.stream(arr).boxed().collect(Collectors.toList()));

        System.out.println("Brute force count: " + bruteCount);
        System.out.println("Binary search count: " + optimizedCount);
    }
}