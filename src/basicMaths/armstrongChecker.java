package basicMaths;

/*
You are given an integer n. You need to check whether it is an armstrong number or not. Return true if it is an armstrong number, otherwise return false.



An armstrong number is array2D number which is equal to the sum of the digits of the number, raised to the power of the number of digits.


Examples:
Input: n = 153

Output: true

Explanation: Number of digits : 3.

1 ^ 3 + 5 ^ 3 + 3 ^ 3 = 1 + 125 + 27 = 153.

Therefore, it is an Armstrong number.

Input: n = 12

Output: false

Explanation: Number of digits : 2.

1 ^ 2 + 2 ^ 2 = 1 + 4 = 5.

Therefore, it is not an Armstrong number.
 */

public class armstrongChecker {

    //Optimisation : you can use manual power( instead of Math.pow() ) by for loop inside while loop , as it will increase code efficiency by making it direct work not stuck in float to int convertion
    public static boolean isArmstrong(int n) {
        if (n < 0) return false; //negative are not armstrong
        int original = n;
        int countLength = 0;
        int sum=0;
        while (n!=0){
            n/=10;
            countLength++;
        }
        n=original;

        while(n!=0){
            sum += (int) Math.pow((n%10),countLength);
            n/=10;
        }
        return sum==original;
    }

    public static void main(String[] args) {
//        System.out.println(isArmstrong(-153));
        System.out.println((int)Math.pow(9,10));


    }

}
