package array;

import java.util.Arrays;

public class prefixSum {
    static int[] preSumBruteForce(int[] arr){
        int[] ans = new int[arr.length];
        int sum = 0;
        for(int i = 0 ; i< arr.length ;i++){
            sum+=arr[i];
            ans[i]=sum;
        }
        return ans;
    }
    static int[] preSum(int[] arr){
        int[] pre = new int[arr.length];
        pre[0] =arr[0];
        for(int i = 1 ;i<arr.length;i++){
            pre[i] = pre[i-1]+arr[i];
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] ans = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(preSum(ans)));
    }
}
