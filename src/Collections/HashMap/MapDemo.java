package Collections.HashMap;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(2, "Second"); // Overwrites "Two"

        map.remove(1);

        System.out.println("Map: " + map);
    }
}

