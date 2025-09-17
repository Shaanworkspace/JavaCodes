package Maths;

import java.util.List;

public class LCMFinder {

    // Euclidean Algorithm for GCD
    public static int gcdEuclidean(int a, int b) {
        if (b == 0) return a;
        return gcdEuclidean(b, a % b);
    }

    // Optimised LCM using gcd
    public static int lcm(int a, int b) {
        return (a * b) / gcdEuclidean(a, b);
    }

    // LCM of an array
    public static int lcmOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }
    public static int lcmBruteForce(int a, int b) {
        int max = Math.max(a, b);
        while (true) {
            if (max % a == 0 && max % b == 0) {
                return max;
            }
            max++;
        }
    }
    //NEW: LCM of a List
    public static int lcmOfList(List<Integer> list) {
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = lcm(result, list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 4, b = 6;
        System.out.println("LCM Brute Force: " + lcmBruteForce(a, b));
        System.out.println("LCM Optimised  : " + lcm(a, b));

        int[] arr = {4, 6, 8};
        System.out.println("LCM of Array   : " + lcmOfArray(arr));

        // Demo for List version
        List<Integer> list = java.util.Arrays.asList(4, 6, 8);
        System.out.println("LCM of List    : " + lcmOfList(list));
    }


}