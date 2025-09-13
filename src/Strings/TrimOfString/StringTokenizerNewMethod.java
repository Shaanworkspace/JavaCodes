package Strings.TrimOfString;


import java.util.Arrays;

public class StringTokenizerNewMethod {
    public static void reverseArray(String[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // swap arr[start] and arr[end]
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // move pointers
            start++;
            end--;
        }
    }
    public static String trim(String s){
        String[]  srr = s.trim().split("\\s+");
        reverseArray(srr);
        return String.join(" ",srr);
    }
    public static void main(String[] args) {
        String s = " the sky is        blue     ";
        System.out.println(trim(s));
    }
}
