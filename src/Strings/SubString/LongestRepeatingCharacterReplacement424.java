package Strings.SubString;

public class LongestRepeatingCharacterReplacement424 {
    public static int characterReplacement(String s, int k) {
        int n=s.length(),result=0;
        for(int start = 0 ; start<n ;start++){
            int[] arr = new int[26];  // reset freq array for each window
            int max = 0;
            for(int end = start ;end<n;end++){
                arr[s.charAt(end)-'A']++;
                max=Math.max(max,arr[s.charAt(end)-'A']);
                int changeable = (end-start+1)-max;
                if(changeable<=k){
                    result=Math.max(result,end-start+1);
                }else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a = characterReplacement("AABABBA",1);
        System.out.println(a);
    }
}
