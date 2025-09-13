package Maths;

public class DigitCounter {
    public static int count(int n) {
        // Handle the case when n = 0 (since log10(0) is undefined)
        if (n == 0) {
            return 1;
        }
        int cnt = (int)(Math.log10(n) + 1);
        return cnt;
    }

    public static void main(String[] args) {
        int num = 0;
        System.out.println("Number of digits: " + count(num));
    }
}