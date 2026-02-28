package Array.Sorting;
import java.util.*;

public class ReversePairsLeetCode493 {
	private static int Gcount = 0;
	// Method 1: Brute / conceptual (try yourself)
	public int reversePairsMethod1(int[] arr) {
		Gcount = 0;
		mergeSort(arr, 0, arr.length - 1);
		return Gcount;
	}
	static void mergeSort(int[] arr, int l, int r) {
		if (l >= r) return;
		int mid = l + (r - l) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);

		countReversePairs(arr, l, mid, r);

		mergeBothWithExtraArrays(arr, l, mid, r);
	}

	static void countReversePairs(int[] arr, int l, int mid, int r) {
		int count = 0;
		int j = mid + 1;

		for (int i = l; i <= mid; i++) {
			while (j <= r && (long) arr[i] > 2L * arr[j]) {
				j++;
			}
			count += (j - (mid + 1));
		}
		Gcount +=count;
	}

	private static void mergeBothWithExtraArrays(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];


		//copy from original array
		for (int i = 0; i < n1; i++) {
			L[i] = arr[i + l];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = arr[mid + i + 1];
		}


		int i = 0, j = 0, k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	// Method 2: Optimized approach (try yourself)
	public int reversePairsMethod2(int[] nums) {
		return 0;
	}

	private static void runTest(ReversePairsLeetCode493 solver,
	                            int[] nums, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		int r1 = solver.reversePairsMethod1(nums);
		int r2 = solver.reversePairsMethod2(nums);

		System.out.printf("Method 1        : %-5d %s%n",
				r1, r1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-5d %s%n",
				r2, r2 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		ReversePairsLeetCode493 solver =
				new ReversePairsLeetCode493();

		System.out.println("=================================================");
		System.out.println("Reverse Pairs - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,3,2,3,1},
				2,
				"Test 1");

		runTest(solver,
				new int[]{2,4,3,5,1},
				3,
				"Test 2");
	}
}