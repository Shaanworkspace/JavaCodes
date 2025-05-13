package array;

public class subarraySum560 {
    static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len==0) return 0;
        int sum=0;
        int ans = 0;
        for(int i = 0 ; i<len ; i++){
            for(int j = i ;j<len ;j++){
                sum+=nums[j];
                if(sum==k){
                    sum=0;
                    ans++;
                    break;
                }
                if(sum>k || sum<0){
                    sum=0;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={-1,-1,1};
        int s = subarraySum(nums,0);
        System.out.println(s);
    }
}
