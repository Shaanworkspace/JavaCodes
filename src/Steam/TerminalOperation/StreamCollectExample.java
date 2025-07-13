package Steam.TerminalOperation;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {
    public static void main(String[] args) {
        List<String> names = List.of("Ram", "Ravi", "Raj");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("R"))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
