package array.Searching;

public class firstAndLastOccurrence {
    public static int[] search(int[] nums, int target) {
        int n = nums.length;
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        if(n==0) return arr;
        if(n==1){
            arr[0] = arr[1] = 0;
            return arr;
        }
        int i = 0 , j = n;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid] == target) {
                int actual = mid;
                if(nums[mid] == nums[mid-1]){
                    while(nums[mid] == nums[mid-1]){
                        mid--;
                    }

                }
                if(nums[actual] == nums[actual+1]){
                    while(nums[actual] == nums[actual+1]){
                        actual++;
                    }
                }
                arr[0]=mid;
                arr[1] = actual;
                return arr;
            }
            if(nums[mid] < target)
                i=mid+1;
            if(nums[mid] > target)
                j=mid-1;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] num = {1};
        for(int n : search(num,1)){
            System.out.println(n);
        }
    }
}
