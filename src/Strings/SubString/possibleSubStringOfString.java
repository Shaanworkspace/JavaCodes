package Strings.SubString;

public class possibleSubStringOfString {
    public static void main(String[] args) {
        String s  = "shaanyadav";
        System.out.println(s.length());
        for(int i = 0 ; i< s.length() ;i++){
            for(int j = 0 ;j<s.length();j++){
                System.out.println(s.substring(i,j));
            }
        }
    }
}
