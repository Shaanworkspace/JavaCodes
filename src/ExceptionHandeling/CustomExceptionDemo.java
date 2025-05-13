package ExceptionHandeling;

import java.util.Scanner;


class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the index (0-4): ");
        int idx = sc.nextInt();

        try {
            if (idx < 0 || idx >= arr.length) {
                throw new MyException("Invalid index! Please enter a value between 0 and 4.");
            }
            System.out.println("Value at index " + idx + ": " + arr[idx]);

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}


