package Recursion.Basics;

public class printDecreasingIncreasing {

    public static void main(String[] args) {
        int n =5;
        printer(n);
    }

    private static void printer(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(n);
        printer(n-1);
        System.out.println(n);
    }

    private static void printerIncreasing(int n) {
        if (n == 0) return;

        printerIncreasing(n - 1);  // first, handle smaller problem
        System.out.println(n);     // then print current value
    }

    private static void printerDecreasing(int n) {
        if(n==0) return ;
        System.out.println(n);
        printerDecreasing(n-1);
    }
}
