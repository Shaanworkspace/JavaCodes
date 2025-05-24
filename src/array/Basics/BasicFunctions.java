package array.Basics;

public class BasicFunctions {
    public void printArray(int[] arr){
        for(int n : arr){
            System.out.print(n+" ");
        }
    }
    public  void shiftLeft(int[] arr, int startIndex){
        for(int i = startIndex;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
    }
}
