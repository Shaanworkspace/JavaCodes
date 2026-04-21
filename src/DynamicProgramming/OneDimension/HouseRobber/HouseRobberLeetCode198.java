package DynamicProgramming.OneDimension.HouseRobber;
import java.util.*;
public class HouseRobberLeetCode198 {

    public int robBrute(int[] nums) {
	    return 0;
    }


    public int robTryYourSelf(int[] nums) {
	    return 0;
    }

    public int rob(int[] nums) {

	    return 0;
    }

    private static void runTest(HouseRobberLeetCode198 solver,
                                int[] nums, int expected, String name) {
        System.out.println("🔹 " + name);
        System.out.println("Input: " + Arrays.toString(nums));

        int brute = solver.robBrute(nums);
        int your  = solver.robTryYourSelf(nums);
        int opt   = solver.rob(nums);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-4d%n", brute);
        System.out.printf("TryYourSelf      : %-4d%n", your);
        System.out.printf("Optimized (O(n)) : %-4d%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    public static void main(String[] args) {
        HouseRobberLeetCode198 solver = new HouseRobberLeetCode198();

        System.out.println("=================================================");
        System.out.println("💰  House Robber — Tests");
        System.out.println("=================================================\n");

        runTest(solver, new int[]{1,2,3,1}, 4,  "Test 1");
        runTest(solver, new int[]{2,7,9,3,1}, 12, "Test 2");
        runTest(solver, new int[]{0}, 0, "Test 3");
    }
}