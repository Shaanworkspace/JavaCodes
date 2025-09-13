package array.Two_Pointer;

public class RemoveDuplicatesFromSortedArray26 {
    public static int removeDuplicates(int[] nums) {
        int i =0;
        int j = 0;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
                j++;
            }

        }
        return i+1;
    }
    public static void main (String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
