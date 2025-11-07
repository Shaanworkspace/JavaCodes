package Recursion.Basics;

public class printSumOfNNaturalNumber {

    public static void main(String[] args) {
        System.out.println(printSumByRecursion(3));
    }

    private static int printSumByRecursion(int i) {
        //base case
        if(i==1){
            return 1;
        }
        int sum = printSumByRecursion(i-1)+i;
        return sum ;
    }
}
