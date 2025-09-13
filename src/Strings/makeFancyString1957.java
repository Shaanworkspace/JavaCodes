package Strings;
public class makeFancyString1957 {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        if (s.length() < 3) return s;
        for(int i = 2;i<=s.length();i++){
            if(i==s.length()){
                str.append(s.charAt(i-2));
                str.append(s.charAt(i-1));
                break;
            }
            if(s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i)){
                continue;
            }
            str.append(s.charAt(i-2));
        }
        return str.toString();
    }

    public static void main(String[] args) {

    }
}
