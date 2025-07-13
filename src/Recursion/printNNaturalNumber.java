package Recursion;

public class printNNaturalNumber {
    public static void reversePrintNNumber(int n ){
        //base case
        if(n==1){
            System.out.println(n);
            return;
        }

        //self work
        System.out.println(n+" ");

        //recursive call
        reversePrintNNumber(n-1);
    }
    public static void printNNumber(int n ){
        //base case
        if(n==1){
            System.out.println(n);
            return;
        }

        //recursive call ( It will be up, because first we have to loop all the inputs )
        reversePrintNNumber(n-1);

        //self work
        System.out.println(n+" ");
    }
    public static void main(String[] args) {
        reversePrintNNumber(4);
    }
}
