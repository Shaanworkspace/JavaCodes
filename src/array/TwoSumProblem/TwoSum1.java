package array.TwoSumProblem;

public class TwoSum1 {
    public static  int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // If no valid pair is found, return an empty array instead of null
        return new int[] {};
    }
    public static  int[] twoSumOptimised(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // If no valid pair is found, return an empty array instead of null
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int[] result=twoSumBruteForce(arr,6);
        for(int c : result){
            System.out.println(c);
        }
    }
}
