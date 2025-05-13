package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternBuilding {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher("aa");
        boolean result = matcher.matches();
        System.out.println("Result : "+result);
    }
}
