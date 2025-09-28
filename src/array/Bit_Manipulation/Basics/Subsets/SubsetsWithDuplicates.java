package array.Bit_Manipulation.Basics.Subsets;
import java.util.*;

public class SubsetsWithDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        int n = arr.length;
        int noOfSubsets = (1 << n); // equal to 2^n
        List<List<Integer>> subsets = new ArrayList<>();

        // Iterate over all possible subsets
        for (int i = 0; i < noOfSubsets; i++) {
            List<Integer> subset = new ArrayList<>();

            // Build subset by checking each bit
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            subsets.add(subset);
        }

        System.out.println("Subsets of " + java.util.Arrays.toString(arr) + " : " + subsets);


        return List.of();
    }

    public static void main(String[] args) {
        SubsetsWithDuplicates solver = new SubsetsWithDuplicates();

        // Test Case 1: Smallest non-empty array
        int[] arr1 = {1, 2};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + solver.subsetsWithDup(arr1));

        // Test Case 2: Basic three-element array
        int[] arr2 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + solver.subsetsWithDup(arr2));

        // Test Case 3: Array with duplicates
        int[] arr3 = {1, 2, 2};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + solver.subsetsWithDup(arr3));

        // Test Case 4: Empty array (edge case)
        int[] arr4 = {};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + solver.subsetsWithDup(arr4));
    }
}