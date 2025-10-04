package array;

public class CountNumberOfNiceSubarraysLeetCode1248 {

    // Optimized approach (prefix sum or sliding window + hashmap)
    public int numberOfSubarrays(int[] nums, int k) {
        // TODO: Implement optimized solution
        // Hint idea:
        // 1. Each odd number can be treated like "1", evens like "0".
        // 2. Reduce the problem to: count subarrays with sum = k.
        // 3. This is a classic subarray-sum-equals-k problem -> use prefix sums + hashmap.
        return 0; // placeholder
    }

    // Brute force approach (good for small arrays to build intuition)
    public int numberOfSubarraysBrute(int[] nums, int k) {
        int n = nums.length,count = 0,result=0;
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                count=0;
                for(int k1=i;k1<=j;k1++){
                    if(nums[k1] %2 != 0){
                        count++;
                    }
                }
                if (count == k) {
                    result++;
                }
            }
        }
        return result; // placeholder
    }

    // Simple test runner
    public static void main(String[] args) {
        CountNumberOfNiceSubarraysLeetCode1248 solution = new CountNumberOfNiceSubarraysLeetCode1248();

        int[] test1 = {1,1,2,1,1};
        int k1 = 3;
        System.out.println("Test1 Expected: 2, Got: " + solution.numberOfSubarraysBrute(test1, k1));

        int[] test2 = {2,4,6};
        int k2 = 1;
        System.out.println("Test2 Expected: 0, Got: " + solution.numberOfSubarraysBrute(test2, k2));

        int[] test3 = {2,2,2,1,2,2,1,2,2,2};
        int k3 = 2;
        System.out.println("Test3 Expected: 16, Got: " + solution.numberOfSubarraysBrute(test3, k3));
    }
}