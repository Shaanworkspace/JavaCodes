package Recursion.Basics;

public class PrintAStringReverse {

    private static String stringReverse(String s ){
        //Base case :-> think of the smallest s value , to which answer you know ->
        if (s.length() <= 1) {
            return s;
        }

        // Recursive step
        return stringReverse(s.substring(1)) + s.charAt(0);
    }
    public static void main(String[] args) {
        String s = "sjhaan";
        System.out.println(stringReverse(s));
    }
}
