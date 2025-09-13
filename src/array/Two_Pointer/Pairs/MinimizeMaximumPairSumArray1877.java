package array.Two_Pointer.Pairs;

import java.util.Arrays;

public class MinimizeMaximumPairSumArray1877 {

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=0,i =0,j = nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum > max){
                max=sum;
            }
            i++;
            j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,5};
        System.out.println(minPairSum(arr));
    }
}
