package Array.Sorting;
import java.util.*;

public class CountInversionsGFG {

	// Try yourself
	public int inversionCount(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	// Merge sort + count inversions
	private static int mergeSort(int[] arr, int left, int right) {
		int count =0;
		if(left<right){
			int mid = left + (right - left) / 2;
			// Left inversions
			count += mergeSort(arr, left, mid);

			// Right inversions
			count += mergeSort(arr, mid + 1, right);

			// Cross inversions
			count += merge(arr, left, mid, right);
		}

		return count;
	}
	private static int merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = arr[left + i];

		for (int j = 0; j < n2; j++)
			R[j] = arr[mid + 1 + j];

		int i = 0, j = 0, k = left;
		int inversions = 0;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k++] = L[i++];
			} else {
				arr[k++] = R[j++];
				inversions += (n1 - i);
			}
		}

		while (i < n1)
			arr[k++] = L[i++];

		while (j < n2)
			arr[k++] = R[j++];

		return inversions;
	}


	// O(n^2) -> It will not be accepted
	public long inversionCountBrute(int[] arr) {
		int n = arr.length,count=0;
		for(int i=0;i<n-1;i++){
			for(int j =i+1;j<n;j++){
				if(arr[i]>arr[j]){
					count++;
				}
			}
		}
		return count;
	}

	private static void runTest(CountInversionsGFG solver,
	                            int[] arr, long expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + expected);

		long result = solver.inversionCount(arr);

		System.out.printf("Result          : %-10d %s%n",
				result, result == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CountInversionsGFG solver = new CountInversionsGFG();

		System.out.println("=================================================");
		System.out.println("Count Inversions - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{2, 4, 1, 3, 5},
				3,
				"Test 1");

		runTest(solver,
				new int[]{2, 3, 4, 5, 6},
				0,
				"Test 2");

		runTest(solver,
				new int[]{10, 10, 10},
				0,
				"Test 3");
	}
}
