package array.Searching;

//Target first occurrence
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return -1;
        int i = 0 , j=n;
        while(i<=j){ //this is must as < or = , as i forgot to implement equals to
            int mid = (i+j)/2;
            if(nums[mid] == target) return i;
            if(nums[mid] < target)
                i=mid+1;
            if(nums[mid] > target)
                j=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {-1,0,3,5,9,12};

        System.out.println(search(num,9));
    }

}
