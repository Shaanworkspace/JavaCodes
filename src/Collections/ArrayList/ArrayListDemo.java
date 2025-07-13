package Collections.ArrayList;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");


        arrayList.remove(1); // removes "Banana"
        arrayList.set(1, "Grapes");

        System.out.println("ArrayList: " + arrayList);
    }
}
