package array;



import java.util.HashMap;

public class RemoveDuplicatesFromSortedArrayII80 {
    public  static  void shiftLeft(int[] arr, int startIndex){
        for(int i = startIndex;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
    }
    public static int removeDuplicatesBruteForce(int[] arr) {
        int result  =0 ,n=arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i]) == 3){
                shiftLeft(arr,i);
                result++;
                i--;
            }
        }
        return n-result;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        int j =removeDuplicatesBruteForce(arr);
       System.out.println(j);
    }
}
