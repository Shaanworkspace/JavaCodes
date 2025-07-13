package Recursion;

public class fibonacciSeriesRecursion {
    public static int fibonacci(int n){

        //base case
        if(n==0 || n==1) return n;
        //self work
        int sum = fibonacci(n-1) + fibonacci(n-2);
        //sub-problem
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
