package Collections.LinkedList;

import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");

        list.addFirst("Start");
        list.addLast("End");
        list.remove("B");

        System.out.println("LinkedList: " + list);
    }
}