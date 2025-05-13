package array.Searching;


public class firstOccurrenceBinarySearch {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return -1;
        int i = 0 , j=n;
        while(i<=j){ //this is must as < or = , as i forgot to implement equals to
            int mid = (i+j)/2;
            if(nums[mid] == target) {

                if(nums[mid] == nums[mid-1]){
                    while(nums[mid] == nums[mid-1]){
                        mid--;
                    }
                }
                return mid;
            }
            if(nums[mid] < target)
                i=mid+1;
            if(nums[mid] > target)
                j=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] num = {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,5,9,9,9,9,12};
        System.out.println(search(num,0));
    }
}
