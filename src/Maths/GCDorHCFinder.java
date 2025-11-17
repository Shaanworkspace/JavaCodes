package Maths;

import java.util.*;
public class GCDorHCFinder {

    // -----------------------------------------------------------
    //  1. BRUTE FORCE METHOD (Checks downward from smaller number)
    // -----------------------------------------------------------
    public static int gcdBruteForce(int a, int b) {
        int dec = Math.min(a, b)/2;
        for (int i = dec; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // -----------------------------------------------------------
    //  2. EUCLIDEAN ALGORITHM (O(log(min(a,b))) - the fastest)
    // -----------------------------------------------------------
    public static int gcdEuclidean(int a, int b) {
        if (b == 0) return a;
        return gcdEuclidean(b, a % b);
    }

    // -----------------------------------------------------------
    //  3. GCD of an ARRAY (Uses Euclidean method internally)
    // -----------------------------------------------------------
    public static int gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcdEuclidean(result, arr[i]);
        }
        return result;
    }

    // -----------------------------------------------------------
    //  4. GCD of a SINGLE LIST (Wrapper for list elements)
    // -----------------------------------------------------------
    public static int gcdOfList(List<Integer> list) {
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = gcdEuclidean(result, list.get(i));
        }
        return result;
    }

    // -----------------------------------------------------------
    //  5. GCD of TWO LISTS (Calculates combined GCD)
    // -----------------------------------------------------------
    public static int gcdOfTwoLists(List<Integer> list1, List<Integer> list2) {
        int gcd1 = gcdOfList(list1);
        int gcd2 = gcdOfList(list2);
        return gcdEuclidean(gcd1, gcd2);
    }

    // -----------------------------------------------------------
    //  MAIN METHOD — Interactive Demo
    // -----------------------------------------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("============================================================");
        System.out.println("          🔹 Welcome to the GCD / HCF Finder 🔹");
        System.out.println("============================================================");

        // ---------- Input Section ----------
        System.out.print("\nEnter first number (a): ");
        int a = sc.nextInt();

        System.out.print("Enter second number (b): ");
        int b = sc.nextInt();

        // ---------- GCD for Two Numbers ----------
        System.out.println("\n------------------------------------------------------------");
        System.out.println("🧮 GCD of " + a + " and " + b);
        System.out.println("------------------------------------------------------------");
        System.out.println(String.format("Brute Force Method  : %d", gcdBruteForce(a, b)));
        System.out.println(String.format("Euclidean Algorithm : %d", gcdEuclidean(a, b)));

        // ---------- GCD for an Array ----------
        int[] arr = { 2, 5, 6, 9, 10 };
        System.out.println("\n------------------------------------------------------------");
        System.out.println("🧮 GCD of Array");
        System.out.println("------------------------------------------------------------");
        System.out.print("Array Elements      : ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println("\nResulting GCD       : " + gcdOfArray(arr));

        // ---------- GCD for Lists ----------
        List<Integer> list1 = Arrays.asList(24, 36, 48);
        List<Integer> list2 = Arrays.asList(18, 30, 12);

        System.out.println("\n------------------------------------------------------------");
        System.out.println("🧮 GCD of Lists");
        System.out.println("------------------------------------------------------------");
        System.out.println("List 1              : " + list1);
        System.out.println("List 2              : " + list2);
        System.out.println("GCD(List1)          : " + gcdOfList(list1));
        System.out.println("GCD(List2)          : " + gcdOfList(list2));
        System.out.println("Combined GCD        : " + gcdOfTwoLists(list1, list2));

        // ---------- Friendly Exit ----------
        System.out.println("\n============================================================");

        sc.close();
    }
}