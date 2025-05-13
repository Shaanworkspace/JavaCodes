package Strings.SubString;

public class findAllSubStrings {
    static void findAllSubstringsMethod(String string){
        int left = 0,right=string.length()-1;
        while (left<string.length()){
            for(int i =left;i<=right;i++){
                System.out.println(string.substring(i,right+1));
            }
            left++;
        }
    }
    static int longestSubstring(String string){
        //longest substring of same word
        int left = 0,right=0;
        int maximum=0;
        while(right<string.length()){
            if(string.charAt(right) != string.charAt(left)){
                left++;
            }
            maximum=Math.max(maximum,right-left+1);
            right++;
        }
        return maximum;
    }
    static void printAllSubstrings(String s) {
        int n = s.length();
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                System.out.println(s.substring(start, end));
            }
        }
    }

    public static void main(String[] args) {
        printAllSubstrings("shaan");
        //System.out.println(longestSubstring("qqqqqannnn"));
    }
}
