package array.Two_Pointer;

import java.util.Arrays;
import java.util.Set;

public class ReverseVowelOfString345 {
    static String reverseVowelsWithoutConvertingToArray(String s) {
        int i =0;
        int j = s.length()-1;
        Set<Character> vowels = Set.of('A','E','I','O','U','a','e','i','o','u');
        StringBuilder sb = new StringBuilder(s);

        while(i<j){
            if(vowels.contains(sb.charAt(i))){
                if(vowels.contains(sb.charAt(j))){
                    char temp = sb.charAt(i);
                    sb.setCharAt(i,sb.charAt(j));
                    sb.setCharAt(j,temp);
                    i++;
                    j--;
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return sb.toString();
    }
    static String reverseVowelsWithConvertingToArray(String s) {
        int i =0;
        int j = s.length()-1;
        Set<Character> vowels = Set.of('A','E','I','O','U','a','e','i','o','u');
        char[] sb = s.toCharArray();
        while(i<j){
            if(vowels.contains(sb[i])){
                if(vowels.contains(sb[j])){
                    char temp = sb[i];
                    sb[i]= sb[j];
                    sb[j]=temp;
                    i++;
                    j--;
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String ans =  reverseVowelsWithConvertingToArray(s);
        System.out.println(ans);
    }

}
