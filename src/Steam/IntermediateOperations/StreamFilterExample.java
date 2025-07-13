package Steam.IntermediateOperations;

import java.util.List;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<String> names = List.of("John", "Bob", "Alice", "Jai");

        names.stream()
                .filter(name -> name.length() > 3)
                .forEach(n-> System.out.println(n));
                //.forEach(System.out::println);

        List<String> modi = names.stream()
                                    .filter(n->(n.length()>2))
                                    .toList();
        System.out.println(modi);
    }
}

