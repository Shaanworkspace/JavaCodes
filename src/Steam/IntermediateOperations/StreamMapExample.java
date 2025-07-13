package Steam.IntermediateOperations;

import java.util.List;

public class StreamMapExample {
    public static void main(String[] args) {
        List<String> names = List.of("john", "alice", "mike");

        names.stream()
                .map(n->n.toUpperCase())
                .forEach(n-> System.out.println(n));
                //.map(String::toUpperCase)
                //.forEach(System.out::println);
        System.out.println(names);
    }
}
