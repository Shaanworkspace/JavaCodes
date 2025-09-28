package array.Bit_Manipulation.Basics.Subsets;

import java.util.ArrayList;
import java.util.List;

public class subsetByBitManipulation {
    public void printAllSubsets(int[] arr) {
        int n = arr.length;

        // Total subsets = 2^n, or we can find by 2^n as ((1<<n> == 2^n)
        int noOfSubsets = (1<<n);

        List<List<Integer>> subsets = new ArrayList<>();

        // let's find for all noOfSubsets, Iterate over all possible subsets
        for(int i=0; i<noOfSubsets; i++) {
            List<Integer> subset = new ArrayList<>();

            //now imagine the matrix of n bits (we can follow the trick to make it in copy
            // Build subset by checking each bit
            // For each bit, decide whether to include nums[i]
            for(int j=0; j<n; j++) {
                // If that bit is set, include nums[i]
                if((i & 1<<j) != 0){
                    subset.add(arr[j]);
                }
            }
            subsets.add(subset);
        }

        System.out.println("Subsets of " + java.util.Arrays.toString(arr) + " : " + subsets);
    }
    public static void main(String[] args) {
        subsetByBitManipulation sb = new subsetByBitManipulation();

        // Test Case 1: Smallest non-empty array
        int[] arr1 = {1, 2};
        sb.printAllSubsets(arr1);

        // Test Case 2: Basic three-element array
        int[] arr2 = {1, 2, 3};
        sb.printAllSubsets(arr2);

        // Test Case 3: Array with duplicates
        int[] arr3 = {1, 2, 2};
        sb.printAllSubsets(arr3);

        // Test Case 4: Empty array (edge case)
        int[] arr4 = {};
        sb.printAllSubsets(arr4);
    }
}
