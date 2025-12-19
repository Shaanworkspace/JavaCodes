package Collections.Set.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSet1 {
    public static void main(String[] args) {
        Set<Integer> s = new LinkedHashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);

        System.out.println(s);
    }
}
