package array.Two_Pointer;

import java.util.Arrays;

public class ReverseWordsInString151 {

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
    public static String reverseWords(String s) {
        String[]  srr = s.trim().split("\\s+");
        reverseArray(srr);
        return String.join(" ",srr);
    }
    static void reverse(char[] arr, int start , int end){
        while (start < end) {
            // swap arr[start] and arr[end]
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // move pointers
            start++;
            end--;
        }
    }
    public static String reversalWithArray(String sr){
            char[] arr = sr.toCharArray();
            int l=0;
            int r=0;
            int i=0;
            reverse(arr,l, arr.length-1);
            while(i<arr.length){
                if(arr[i] == ' '){
                    //reverse from l to r
                    reverse(arr,l,r-1);
                    arr[r] = ' ';
                    r++;
                    i++;
                    l=r;
                    while(i < arr.length && arr[i] == ' '){
                        i++;
                    }
                }else{
                    arr[r] = arr[i++];
                    r++;
                }
            }
        reverse(arr, l, r - 1);
        return new String(arr, 0, r);
    }

    public static void main(String[] args) {
        System.out.println(reversalWithArray("hello world here"));
        // Output: "here world hello"

        System.out.println(reversalWithArray("java is love"));
        // Output: "love is java"
    }
}
