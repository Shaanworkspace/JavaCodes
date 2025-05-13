package array;

public class CountSubarraysOfLengthThreeWithCondition3392 {
    public static int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if (2 * (a + c) == b) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,-1,4,5,1,1,-5,-4,-3,-3,5,1,2,-2,3,-3,-4,0,-1,2,4,2,1,-2,-4,-2,-5,-1,-3,4,-4,4,-1,2,1,4,-2,5,4,1,3,-2,4,5,1,-3,0,-1,5,-4,2,-3,4,2,0,-2,2,4,0,1,0,3,1,3,-4,4,-5,1,3,0,-2,-5,-5,-3,2,-4,-3,1,-3,-2,-4,-1,4,0,-3,-4,3,-1,3,5,-4,2,2,-4,0,5,5,2,5,-5};
        System.out.println(countSubarrays(arr ));
    }
}

// 2 for loops should be converted -> one while loop