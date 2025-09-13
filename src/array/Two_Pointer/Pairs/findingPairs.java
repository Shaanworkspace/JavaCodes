package array.Two_Pointer.Pairs;

public class findingPairs {
    static void randomPair(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                System.out.print("[ ");
                System.out.print(arr[i]+" "+arr[j]);
                System.out.print(" ]");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 3};
        randomPair(nums);
    }
}
