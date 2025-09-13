package array.Two_Pointer;

public class CountNumberGoodPartitions {
    public static int numberOfGoodPartitions(int[] nums) {
        int sum=0,i=0,j=nums.length-1;
        while(i<nums.length){
            while(i<j){
                int lastIndex=0;
                while(j<nums.length){
                    if(nums[i]==nums[j]){
                        lastIndex=j;
                    }
                    j++;
                }
                i++;
            }
            sum+=1;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(numberOfGoodPartitions(arr));
    }
}
