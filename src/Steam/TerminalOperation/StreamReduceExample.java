package Steam.TerminalOperation;
import java.util.List;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 15);

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);
    }
}

