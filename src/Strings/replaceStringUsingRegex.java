package Strings;

public class replaceStringUsingRegex {
    public static void main(String[] args) {
        String s = "A man, array2D plan, array2D canal: Panama";
        s=s.toLowerCase().replaceAll("[^a-z0-9]","");
        StringBuilder str = new StringBuilder(s).reverse();
        if(s.contentEquals(str)){
            System.out.println("yesssssssssss Palindrome");
        }
        else
            System.out.println("Nooooooooooooo Palindrome");

    }
}
