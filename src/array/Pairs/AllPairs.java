package array.Pairs;

public class AllPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        // Nested loops to generate all pairs
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }
}