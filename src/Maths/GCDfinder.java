package Maths;

import java.util.Scanner;

public class GCDfinder {

    // 1. Brute Force (slowest, checks from max --> downwards)
    public static int gcdBruteForce(int a, int b) {
        int dec = Math.min(a, b);
        for (int i = dec; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i; // return as soon as we found
            }
        }
        return 1; // fallback, though GCD will always be >=1
    }

    // 2. Euclidean Algorithm ( the best method, O(log(min(a,b))))
    public static int gcdEuclidean(int a, int b) {
        if (b == 0) return a;
        return gcdEuclidean(b, a % b);
    }

    // Utility: GCD of an array (uses Euclid inside)
    public static int gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcdEuclidean(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---------- For two numbers ----------
        System.out.println();
        System.out.print("Enter first number (a): ");
        int a = sc.nextInt();

        System.out.print("Enter second number (b): ");
        int b = sc.nextInt();

        System.out.println("\n--- GCD of " + a + " and " + b + " ---");
        System.out.println("Brute Force      : " + gcdBruteForce(a, b));
        System.out.println("Euclidean Algo   : " + gcdEuclidean(a, b));

        // ---------- For an array ----------
        int[] arr = {2, 5, 6, 9, 10};
        System.out.println("\n--- GCD of Array ---");
        System.out.print("Array : ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println("\nGCD   : " + gcdOfArray(arr));
    }
}