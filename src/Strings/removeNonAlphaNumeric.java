package Strings;

public class removeNonAlphaNumeric {
    public static String removeNonAlpha(String s){
        s=s.toLowerCase();
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if ((c<48 || c>57) && (c<65 || c>90 ) && (c<97 || c>122)){
                s=s.substring(0,i)+s.substring(i+1);
                i--;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String sh = removeNonAlpha(s);
        System.out.println(sh);
    }
}
