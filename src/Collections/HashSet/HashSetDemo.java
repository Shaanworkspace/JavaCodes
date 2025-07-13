package Collections.HashSet;
import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Red");
        set.add("Blue");
        set.add("Green");
        set.add("Red"); // Duplicate

        System.out.println("HashSet: " + set);
    }
}
