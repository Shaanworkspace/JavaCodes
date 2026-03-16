package Contest.WeeklyContest492;

import java.util.*;

public class FindSmallestBalancedIndexLeetCode {

	public int smallestBalancedIndexMethod1(int[] nums) {
		int n = nums.length;

		long l = 0,rightP = 1,maxP = 0;
		for (int v : nums) {
			maxP += v;
		}

		long[] right = new long[n];
		for (int i = n - 2; i >= 0; i--) {

			if (rightP <= maxP) {
				rightP *= nums[i + 1];

				if (rightP > maxP) {
					rightP = maxP + 1;
				}
			}

			right[i] = rightP;
		}

		right[n - 1] = 1;

		for (int i = 0; i < n; i++) {
			if (l == right[i]) {
				return i;
			}
			l += nums[i];
		}

		return -1;
	}

	public int smallestBalancedIndexMethod2(int[] nums) {
		return -1;
	}

	public int smallestBalancedIndexMethod3(int[] nums) {
		return -1;
	}

	private static void runTest(FindSmallestBalancedIndexLeetCode solver,
	                            int[] nums, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums));
		System.out.println("Expected  : " + expected);

		int m1 = solver.smallestBalancedIndexMethod1(nums);
		int m2 = solver.smallestBalancedIndexMethod2(nums);
		int m3 = solver.smallestBalancedIndexMethod3(nums);

		System.out.printf("Method 1         : %-5d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-5d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-5d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		FindSmallestBalancedIndexLeetCode solver =
				new FindSmallestBalancedIndexLeetCode();

		System.out.println("=================================================");
		System.out.println("Find the Smallest Balanced Index - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{2, 1, 2},
				1,
				"Test 1");

		runTest(solver,
				new int[]{2, 8, 2, 2, 5},
				2,
				"Test 2");

		runTest(solver,
				new int[]{1},
				-1,
				"Test 3");
		runTest(solver,
				new int[]{999, 818, 984, 995, 841, 822, 984, 978, 960, 997, 896, 926, 759, 961, 1000, 562, 1, 1, 1, 87, 4, 1, 40},
				15,
				"Test 4");
		runTest(solver,
				new int[]{813, 974, 946, 966, 915, 924, 812, 1000, 891, 875, 989, 656, 991, 806, 818, 999, 971, 276, 923, 997, 992, 943, 983, 811, 909, 990, 924, 991, 726, 818, 969, 690, 996, 784, 992, 949, 915, 931, 932, 821, 699, 688, 712, 805, 849, 489, 406, 482, 777, 974, 479, 237, 963, 903, 957, 995, 814, 864, 832, 889, 936, 467, 831, 970, 757, 646, 962, 987, 885, 924, 918, 710, 763, 839, 860, 888, 971, 994, 339, 253, 564, 759, 68, 747, 797, 716, 939, 987, 68, 953, 1000, 298, 10, 1, 1, 1, 1, 1, 48, 1, 77, 2},
				91,
				"Test 5");
	}
}