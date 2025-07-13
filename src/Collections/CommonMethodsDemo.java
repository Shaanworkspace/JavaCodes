package Collections;
import java.util.*;

public class CommonMethodsDemo {
    public static void main(String[] args) {

        // Using ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        System.out.println("ArrayList: " + arrayList); // [Java, Python, C++]

        arrayList.remove("Python");
        System.out.println("After removal: " + arrayList); // [Java, C++]

        System.out.println("Contains 'Java'? " + arrayList.contains("Java")); // true
        System.out.println("Size: " + arrayList.size());
        System.out.println("IsEmpty: " + arrayList.isEmpty());
        Object[] arrayArrayList = arrayList.toArray();
        System.out.println("ArrayList to array: " + Arrays.toString(arrayArrayList));

        Iterator<String> arrayListItr = arrayList.iterator();
        System.out.print("ArrayList Iteration: ");
        while (arrayListItr.hasNext()) {
            System.out.print(arrayListItr.next() + " ");
        }
        arrayList.clear();
        System.out.println("\nAfter clear, IsEmpty: " + arrayList.isEmpty());

        System.out.println("--------------------------------------------------------");

        // Using LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Red");
        linkedList.add("Green");
        linkedList.add("Blue");
        linkedList.add("Red");
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove("Red");

        System.out.println("Contains 'Green'? " + linkedList.contains("Green"));
        System.out.println("Size: " + linkedList.size());
        System.out.println("IsEmpty: " + linkedList.isEmpty());
        Object[] arrayLinkedList = linkedList.toArray();
        System.out.println("LinkedList to array: " + Arrays.toString(arrayLinkedList));

        Iterator<String> linkedListItr = linkedList.iterator();
        System.out.print("LinkedList Iteration: ");
        while (linkedListItr.hasNext()) {
            System.out.print(linkedListItr.next() + " ");
        }
        linkedList.clear();
        System.out.println("\nAfter clear, IsEmpty: " + linkedList.isEmpty());

        System.out.println("--------------------------------------------------------");

        // Using HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Apple");
        System.out.println("HashSet: " + hashSet);

        hashSet.remove("Banana");
        System.out.println("Contains 'Apple'? " + hashSet.contains("Apple"));
        System.out.println("Size: " + hashSet.size());
        System.out.println("IsEmpty: " + hashSet.isEmpty());
        Object[] arrayHashSet = hashSet.toArray();
        System.out.println("HashSet to array: " + Arrays.toString(arrayHashSet));

        Iterator<String> hashSetItr = hashSet.iterator();
        System.out.print("HashSet Iteration: ");
        while (hashSetItr.hasNext()) {
            System.out.print(hashSetItr.next() + " ");
        }
        hashSet.clear();
        System.out.println("\nAfter clear, IsEmpty: " + hashSet.isEmpty());

        System.out.println("--------------------------------------------------------");

        // Using Queue
        Queue<String> queue = new LinkedList<>();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        System.out.println("Queue: " + queue);

        queue.remove("Two");
        System.out.println("Contains 'Three'? " + queue.contains("Three"));
        System.out.println("Size: " + queue.size());
        System.out.println("IsEmpty: " + queue.isEmpty());
        Object[] arrayQueue = queue.toArray();
        System.out.println("Queue to array: " + Arrays.toString(arrayQueue));

        Iterator<String> queueItr = queue.iterator();
        System.out.print("Queue Iteration: ");
        while (queueItr.hasNext()) {
            System.out.print(queueItr.next() + " ");
        }
        queue.clear();
        System.out.println("\nAfter clear, IsEmpty: " + queue.isEmpty());



        // TreeSet
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Zebra");
        treeSet.add("Apple");
        treeSet.add("Mango");
        System.out.println("TreeSet: " + treeSet); // Sorted order

        treeSet.remove("Apple");
        System.out.println("Contains 'Mango'? " + treeSet.contains("Mango"));
        System.out.println("Size: " + treeSet.size());
        System.out.println("IsEmpty: " + treeSet.isEmpty());
        System.out.println("TreeSet to array: " + Arrays.toString(treeSet.toArray()));

        Iterator<String> treeSetItr = treeSet.iterator();
        System.out.print("TreeSet Iteration: ");
        while (treeSetItr.hasNext()) {
            System.out.print(treeSetItr.next() + " ");
        }
        treeSet.clear();
        System.out.println("\nAfter clear, IsEmpty: " + treeSet.isEmpty());

        System.out.println("--------------------------------------------------------");

        // Stack (extends Vector)
        Stack<String> stack = new Stack<>();
        stack.add("One");
        stack.add("Two");
        stack.add("Three");
        System.out.println("Stack: " + stack);

        stack.remove("Two");
        System.out.println("Contains 'One'? " + stack.contains("One"));
        System.out.println("Size: " + stack.size());
        System.out.println("IsEmpty: " + stack.isEmpty());
        System.out.println("Stack to array: " + Arrays.toString(stack.toArray()));

        Iterator<String> stackItr = stack.iterator();
        System.out.print("Stack Iteration: ");
        while (stackItr.hasNext()) {
            System.out.print(stackItr.next() + " ");
        }
        stack.clear();
        System.out.println("\nAfter clear, IsEmpty: " + stack.isEmpty());

        System.out.println("--------------------------------------------------------");

        // Vector
        Vector<String> vector = new Vector<>();
        vector.add("Red");
        vector.add("Green");
        vector.add("Blue");
        System.out.println("Vector: " + vector);

        vector.remove("Green");
        System.out.println("Contains 'Red'? " + vector.contains("Red"));
        System.out.println("Size: " + vector.size());
        System.out.println("IsEmpty: " + vector.isEmpty());
        System.out.println("Vector to array: " + Arrays.toString(vector.toArray()));

        Iterator<String> vectorItr = vector.iterator();
        System.out.print("Vector Iteration: ");
        while (vectorItr.hasNext()) {
            System.out.print(vectorItr.next() + " ");
        }
        vector.clear();
        System.out.println("\nAfter clear, IsEmpty: " + vector.isEmpty());

        System.out.println("--------------------------------------------------------");

        // PriorityQueue
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Orange");
        pq.add("Banana");
        pq.add("Apple");
        System.out.println("PriorityQueue: " + pq); // Natural ordering (min-heap logic)

        pq.remove("Banana");
        System.out.println("Contains 'Apple'? " + pq.contains("Apple"));
        System.out.println("Size: " + pq.size());
        System.out.println("IsEmpty: " + pq.isEmpty());
        System.out.println("PriorityQueue to array: " + Arrays.toString(pq.toArray()));

        Iterator<String> pqItr = pq.iterator();
        System.out.print("PriorityQueue Iteration: ");
        while (pqItr.hasNext()) {
            System.out.print(pqItr.next() + " ");
        }
        pq.clear();
        System.out.println("\nAfter clear, IsEmpty: " + pq.isEmpty());
    }
}
