package ExceptionHandeling;


/*
Question 1: Write a program to divide two numbers entered by the user.
    ● Handle the case where the user enters 0 as the divisor using
        ArithmeticException.
    ● Print a message like: "Division by zero is not allowed."
 */
import java.util.Scanner;

public class ArithmeticException extends Throwable {
    static void divider(int a , int b ) throws ArithmeticException{
        if(b==0){
            throw new java.lang.ArithmeticException("This is not a valid divisor Written by shaan");
        }else {
            System.out.println("This is dividable as the ans is : "+a/b);
        }
    }
    public static void main(String[] args) throws ArithmeticException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a : ");
        int a = sc.nextInt();
        System.out.print("Enter b : ");
        int b = sc.nextInt();
        divider(a,b);
    }
}
