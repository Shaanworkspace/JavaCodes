package array.buyAndSellStock;

public class buyAndSellStock121 {
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
    public static int maxProfit1(int[] arr) {
        int n = arr.length,result=0;
        int buy = arr[0],sell=0;
        for(int i = 1;i<n;i++){
            if(arr[i] < buy ){
                buy = arr[i];
            }
            else if(arr[i] > sell){
                sell = arr[i];
            }
        }
        return Math.max(sell - buy, 0);
    }
    public static void main(String[] args) {
//        int[] arr = {2,1,2,1,0,1,2};
        int[] arr = {2,4,1};
        int result = maxProfit1(arr);
        System.out.println(result);
    }
}
