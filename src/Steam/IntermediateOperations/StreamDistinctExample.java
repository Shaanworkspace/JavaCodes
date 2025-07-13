package Steam.IntermediateOperations;

import java.util.List;

public class StreamDistinctExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4);

        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }
}

