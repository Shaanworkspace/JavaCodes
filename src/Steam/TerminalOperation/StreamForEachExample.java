package Steam.TerminalOperation;
import java.util.List;

public class StreamForEachExample {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Mango");

        fruits.stream()
                .forEach(System.out::println);
    }
}
