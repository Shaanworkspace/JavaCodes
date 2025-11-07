package array.Subsequence;

public class NumberSubsequencesThatSatisfyGivenSumCondition1498 {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;


            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static int numSubseq(int[] nums, int target) {
        insertionSort(nums);
        int i=0,sum=0,j=nums.length-1;
        while(i<=j){
            if(nums[i]+nums[j] <=target){
                sum+= (int) Math.pow(2,j-i);
                i++;
            }
            else {
                j--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,4,6,7};
        int target = 12;
        System.out.println(numSubseq(nums, target));
    }
}
