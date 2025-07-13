package Steam.IntermediateOperations;

import java.util.List;

public class StreamLimitExample {
    public static void main(String[] args) {
        List<String> cities = List.of("Delhi", "Mumbai", "Chennai", "Kolkata");

        cities.stream()
                .limit(3)
                .forEach(System.out::println);
    }
}
