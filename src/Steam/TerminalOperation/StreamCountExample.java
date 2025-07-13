package Steam.TerminalOperation;

import java.util.List;

public class StreamCountExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        long count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("Even numbers count: " + count);
    }
}
