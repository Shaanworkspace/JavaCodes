package Recursion.Basics;

public class printNNaturalNumber {

    public static void main(String[] args) {
        printByRecursion(20);
    }

    private static void printByRecursion(int i) {
        //base case
        if(i==0){
            return;
        }
        //work

        printByRecursion(i-1);
        System.out.println(i);

        return;
    }
}
