package Strings.TrimOfString;

import java.util.StringTokenizer;

public class StringTokenizerLegacyMethod {
    public static void trimByLegacy(String s){
        StringTokenizer st =  new StringTokenizer(s);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
    public static void main(String[] args) {
        String s = " the sky is        blue     ";
        trimByLegacy(s);
    }
}
