package array.Subsequence;

public class SubsequenceGeneration {

    public static void subsequenceBruteForce(int[] arr){
        for(int j=0;j<arr.length;j++){
            for(int k=j;k<arr.length;k++){
                System.out.print("[");
                for(int l = j;l<=k;l++){
                    System.out.print(arr[l]+", ");
                }
                System.out.print("]   ");
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        subsequenceBruteForce(nums);
    }
}
