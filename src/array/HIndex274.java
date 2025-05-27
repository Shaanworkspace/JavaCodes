package array;

public class HIndex274 {
    public static int hIndex(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n+1];
        int a = nums.length;
        for(int i =0;i<n;i++){
            if(arr[i] > a-1){
                nums[a-1]++;;
            }else
                nums[arr[i]]++;
        }
        int count=0;
        for(int j=a-1 ;j>=0;j--){
            count+=nums[j];
            if(count>=j){
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,6,1,5};
        int e = hIndex(arr);
        System.out.println(e);
    }
}
