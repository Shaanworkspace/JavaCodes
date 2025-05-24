package array.buyAndSellStock;

public class buyAndSellStock1 {
    public static int maxProfit(int[] arr) {
        int n = arr.length,result=0;
        for(int i =0 ;i<n-1;i++){
            int max=arr[i];
            for(int j = i+1 ;j<n;j++){
                if(max<arr[j]){
                    max = arr[j];
                }
            }
            result = Math.max(max-arr[i],result);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        int result = maxProfit(arr);
        System.out.println(result);
    }
}
