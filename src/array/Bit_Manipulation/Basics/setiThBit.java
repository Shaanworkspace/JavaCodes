package array.Bit_Manipulation.Basics;

import array.Bit_Manipulation.Basics.Convertions.DecimalToBinary;

import java.text.DecimalFormat;

public class setiThBit {

    // Method: set the ith bit of n, return binary string
    public static String setIthBit(int n, int i) {
        // Step 1: Make the mask
        int mask = 1 << i;

        // Step 2: Collections.Set the ith bit
        int newNum = n | mask;

        // Step 3: Return binary representation of the result
        return Integer.toBinaryString(newNum);
    }

    public static void main(String[] args) {
        // Test case 1
        int num1 = 5; // binary: 101
        System.out.println("Original: " + Integer.toBinaryString(num1));
        System.out.println("After setting 1st bit: " + setIthBit(num1, 1)); // expected: 111 (7)

        // Test case 2
        int num2 = 10; // binary: 1010
        System.out.println("Original: " + Integer.toBinaryString(num2));
        System.out.println("After setting 0th bit: " + setIthBit(num2, 0)); // expected: 1011 (11)

        // Test case 3
        int num3 = 0; // binary: 0
        System.out.println("Original: " + Integer.toBinaryString(num3));
        System.out.println("After setting 3rd bit: " + setIthBit(num3, 3)); // expected: 1000 (8)
    }
}