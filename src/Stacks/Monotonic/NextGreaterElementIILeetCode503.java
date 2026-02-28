package Stacks.Monotonic;
import java.util.*;

public class NextGreaterElementIILeetCode503 {

	// Method 1: Brute force idea (try yourself)
	public int[] nextGreaterElementsMethod1(int[] nums) {
		int n = nums.length,ele=nums[0];
		boolean updated = false;
		int[] ans = new int[n];
		for(int i =0;i<n;i++){
			ele = nums[i];
			int j = 1;
			while(j<n){
				int k = (j+i)%n;
				if(nums[k]>ele){
					ans[i] = nums[k];
					updated = true;
					break;
				}
				j++;
			}
			if(!updated) ans[i]= -1;
			updated = false;
		}
		return ans;
	}

	// Method 2: Better approach (try yourself)
	public int[] nextGreaterElementsMethod2(int[] nums) {
		return new int[nums.length];
	}

	// Method 3: Optimized using stack (try yourself)
	public int[] nextGreaterElementsMethod3(int[] nums) {
		return new int[nums.length];
	}

	private static void runTest(NextGreaterElementIILeetCode503 solver,
	                            int[] nums, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(nums));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] r1 = solver.nextGreaterElementsMethod1(nums);
		int[] r2 = solver.nextGreaterElementsMethod2(nums);
		int[] r3 = solver.nextGreaterElementsMethod3(nums);

		System.out.printf("Method 1        : %-20s %s%n",
				Arrays.toString(r1), Arrays.equals(r1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-20s %s%n",
				Arrays.toString(r2), Arrays.equals(r2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-20s %s%n",
				Arrays.toString(r3), Arrays.equals(r3, expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		NextGreaterElementIILeetCode503 solver =
				new NextGreaterElementIILeetCode503();

		System.out.println("=================================================");
		System.out.println("Next Greater Element II - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,2,1},
				new int[]{2,-1,2},
				"Test 1");


		runTest(solver,
				new int[]{5,4,3,2,1},
				new int[]{-1,5,5,5,5},
				"Test 3");
	}
}