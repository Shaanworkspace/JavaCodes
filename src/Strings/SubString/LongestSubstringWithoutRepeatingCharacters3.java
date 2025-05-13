package Strings.SubString;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        int i =0,j=0;

        HashSet<Character> hashSet = new HashSet<>();
        while(j<s.length()){
            char ch = s.charAt(i);

            while(hashSet.contains(ch)){
                hashSet.remove(s.charAt(i));
                i++;
            }
            hashSet.add(ch);
            result = Math.max(result,j-i+1);
            j++;
        }
        return result;
    }
    public int lengthOfLongestSubstringOptimised(String s) {
        int result=0;
        int left = 0 , right = 0 ;
        while(right<s.length()){
            char ch = s.charAt(right);

            for(int i = left; i < right;i++){
                if(s.charAt(i)==ch){
                    left=i+1;
                    break;
                }
            }
            result = Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
}
