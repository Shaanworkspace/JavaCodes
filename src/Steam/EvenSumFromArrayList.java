package Steam;
import java.util.ArrayList;
import java.util.List;

public class EvenSumFromArrayList {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList with integers from 1 to 10
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        int sumOfEven = numbers.stream()
                .filter(n -> {
                    System.out.println(n);
                    return n%2==0;
                })   // filter even numbers
                .reduce(0, (a, b) -> a + b); // sum them using reduce

        // Step 2: Use Stream API to filter even numbers and sum them

        // Step 3: Print the result
        System.out.println("Sum of even numbers from 1 to 10 is: " + sumOfEven);
    }
}
