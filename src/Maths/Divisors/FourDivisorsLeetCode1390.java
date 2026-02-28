package Maths.Divisors;

import java.util.*;

public class FourDivisorsLeetCode1390 {

	public int sumFourDivisorsBrute(int[] nums) {
		int result =0;
		for (int ch : nums) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 2; i * i <= ch; i++) {
				if (ch % i == 0) {
					arr.add(i);
					if (i != ch / i) {
						arr.add(ch / i);
					}
					if (arr.size() > 2) break;
				}
			}

			if (arr.size() == 2) {
				result += 1 + ch + arr.get(0) + arr.get(1);
			}
		}
		return result;
	}

	public int sumFourDivisorsTryYourSelf(int[] nums) {
		return 0;
	}

	public int sumFourDivisors(int[] nums) {
		return 0;
	}

	private static void runTest(FourDivisorsLeetCode1390 solver,
	                            int[] nums, int expected, String name) {
		System.out.println(name);
		System.out.println("Input: " + Arrays.toString(nums));

		int brute = solver.sumFourDivisorsBrute(nums);
		int your  = solver.sumFourDivisorsTryYourSelf(nums);
		int opt   = solver.sumFourDivisors(nums);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		FourDivisorsLeetCode1390 solver = new FourDivisorsLeetCode1390();

		runTest(solver, new int[]{21, 4, 7}, 32, "Test 1");
		runTest(solver, new int[]{7286,18704,70773,8224,91675}, 10932, "Test 2");
		runTest(solver, new int[]{1,2,3,4,5,6,7,8,9,10}, 45, "Test 3");
	}
}