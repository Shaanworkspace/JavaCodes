package array.HardLeetCode;

public class Median {

    public static  int medianFinder(int[] arr){
        if(arr.length == 0 ) return 0;

        if(arr.length % 2 == 0){
            return ( arr[arr.length/2] + arr[(arr.length/2)+1] )/2;
        }
        else {
            return arr[(int)Math.ceil((double) arr.length /2)];
        }
    }
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(medianFinder(arr));
    }
}
