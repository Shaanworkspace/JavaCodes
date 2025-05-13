package array;

public class LongestConsecutiveSequence128 {
    static boolean isNextPresent(int[] arrr,int num){
        for(int i : arrr){
            if(num==i) {
                return true;
            }
        }
        return false;
    }
    public int longestConsecutiveBruteForce(int[] arr) {
        int maximumLength = 0 ;

        for(int n : arr){
            int currElement = n ;
            int currentLength = 1 ;
            while(isNextPresent(arr,currElement+1)){
                currElement++;
                currentLength++;
            }
            maximumLength = Math.max(currentLength,maximumLength);
        }
        return maximumLength;
    }

    public static void main(String[] args) {

    }
}
