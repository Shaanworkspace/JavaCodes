package Recursion;

public class factorial {
    public static long factorialRecursion(long n){
        //Base case
            if(n<=1){ //Not (n==1) because if value is 0 then StackOverflowError
                return 1;
            }
        //Sub-Problem
            long baakiPart = factorialRecursion(n-1);

        //Self work
        return n*baakiPart;
    }

    public static void main(String[] args) {
        System.out.println(factorialRecursion(0));
    }
}
