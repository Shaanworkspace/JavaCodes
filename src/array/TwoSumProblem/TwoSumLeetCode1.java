package array.TwoSumProblem;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSumLeetCode1 {

    //Method 1 : Brute Force
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

    /*

    Tumhare twoSumByHashMap me ek possible bug hai: agar same element is needed (like [3,3], target = 6),
    tumhare loop put karke overwrite kar dega aur galat answer return kar sakta hai. Safer logic ye hoti hai:

    public static int[] twoSumByHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
        }
        return new int[] {};
    }

     */

    //Method 2 : Hashmap Approach with correct way (removing [3,3] same index error)
    public static int[] twoSumByHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }


    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target =6;
        System.out.println("By Two Sum Brute Force");
        System.out.println(Arrays.toString(twoSumBruteForce(arr,target)));
        System.out.println("By Two Sum By HashMap");
        System.out.println(Arrays.toString(twoSumByHashMap(arr,target)));
        System.out.println("By Two Sum By BinarySearch");
//        System.out.println(Arrays.toString(twoSumByBinarySearch(arr,target)));

    }


}
