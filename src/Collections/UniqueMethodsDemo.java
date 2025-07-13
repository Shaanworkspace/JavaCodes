package Collections;
import java.util.*;

public class UniqueMethodsDemo {
    public static void main(String[] args) {

        // ArrayList: Specific methods
        System.out.println("=== ArrayList Unique Methods ===");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        // get(int index): Access element at specific index
        System.out.println("Get element at index 1: " + arrayList.get(1)); // Python
        // set(int index, E element): Replace element at index
        arrayList.set(1, "Ruby");
        System.out.println("After set(1, Ruby): " + arrayList); // [Java, Ruby, C++]
        // add(int index, E element): Insert at specific index
        arrayList.add(1, "Go");
        System.out.println("After add(1, Go): " + arrayList); // [Java, Go, Ruby, C++]
        // subList(int fromIndex, int toIndex): Get a sublist
        System.out.println("Sublist (1, 3): " + arrayList.subList(1, 3)); // [Go, Ruby]

        System.out.println("--------------------------------------------------------");


        // LinkedList: Specific methods (List and Deque interfaces)
        System.out.println("=== LinkedList Unique Methods ===");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Red");
        linkedList.add("Green");
        linkedList.add("Blue");
        // addFirst(E e): Add to the beginning
        linkedList.addFirst("Yellow");
        System.out.println("After addFirst(Yellow): " + linkedList); // [Yellow, Red, Green, Blue]
        // addLast(E e): Add to the end
        linkedList.addLast("Purple");
        System.out.println("After addLast(Purple): " + linkedList); // [Yellow, Red, Green, Blue, Purple]
        // getFirst(): Get first element
        System.out.println("First element: " + linkedList.getFirst()); // Yellow
        // getLast(): Get last element
        System.out.println("Last element: " + linkedList.getLast()); // Purple
        // removeFirst(): Remove and return first element
        System.out.println("Removed first: " + linkedList.removeFirst()); // Yellow
        System.out.println("After removeFirst: " + linkedList); // [Red, Green, Blue, Purple]

        System.out.println("--------------------------------------------------------");


        // HashSet: Specific methods (minimal, as Set interface is basic)
        System.out.println("=== HashSet Unique Methods ===");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        // Note: HashSet has no unique methods beyond Set interface, but we can highlight its behavior
        System.out.println("HashSet (no duplicates, unordered): " + hashSet);
        // add returns false if element already exists
        boolean added = hashSet.add("Apple");
        System.out.println("Add duplicate 'Apple' (returns false): " + added); // false

        System.out.println("--------------------------------------------------------");


        // TreeSet: Specific methods
        System.out.println("=== TreeSet Unique Methods ===");
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Zebra");
        treeSet.add("Apple");
        treeSet.add("Mango");
        System.out.println(treeSet);
        // first(): Get lowest element
        System.out.println("First element: " + treeSet.first()); // Apple
        // last(): Get highest element
        System.out.println("Last element: " + treeSet.last()); // Zebra
        // higher(E e): Get smallest element strictly greater than e
        System.out.println("Higher than 'Apple': " + treeSet.higher("Apple")); // Mango
        // lower(E e): Get largest element strictly less than e
        System.out.println("Lower than 'Mango': " + treeSet.lower("Mango")); // Apple
        // subSet(E from, E to): Get sorted subset
        System.out.println("Subset ('Apple', 'Zebra'): " + treeSet.subSet("Apple", "Zebra")); // [Apple, Mango]

        System.out.println("--------------------------------------------------------");


        // Queue (via LinkedList): Specific methods
        System.out.println("=== Queue (LinkedList) Unique Methods ===");
        Queue<String> queue = new LinkedList<>();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        // offer(E e): Add element (returns false if fails)
        System.out.println("Offer 'Four': " + queue.offer("Four")); // true
        System.out.println("Queue after offer: " + queue); // [One, Two, Three, Four]
        // peek(): Retrieve but don’t remove head
        System.out.println("Peek head: " + queue.peek()); // One
        // poll(): Retrieve and remove head
        System.out.println("Poll head: " + queue.poll()); // One
        System.out.println("Queue after poll: " + queue); // [Two, Three, Four]

        System.out.println("--------------------------------------------------------");


        // Stack: Specific methods
        System.out.println("=== Stack Unique Methods ===");
        Stack<String> stack = new Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        // push(E item): Add to top
        System.out.println("After push(Three): " + stack); // [One, Two, Three]
        // pop(): Remove and return top element
        System.out.println("Pop: " + stack.pop()); // Three
        System.out.println("After pop: " + stack); // [One, Two]
        // peek(): View top element without removing
        System.out.println("Peek: " + stack.peek()); // Two
        // search(Object o): Return 1-based position from top
        System.out.println("Search 'One' (1-based position): " + stack.search("One")); // 2

        System.out.println("--------------------------------------------------------");


        // Vector: Specific methods
        System.out.println("=== Vector Unique Methods ===");
        Vector<String> vector = new Vector<>();
        vector.add("Red");
        vector.add("Green");
        vector.add("Blue");
        // addElement(E obj): Add to end (legacy)
        vector.addElement("Yellow");
        System.out.println("After addElement(Yellow): " + vector); // [Red, Green, Blue, Yellow]
        // elementAt(int index): Get element at index (legacy)
        System.out.println("Element at index 1: " + vector.elementAt(1)); // Green
        // setElementAt(E obj, int index): Set element at index (legacy)
        vector.setElementAt("Purple", 1);
        System.out.println("After setElementAt(Purple, 1): " + vector); // [Red, Purple, Blue, Yellow]
        // capacity(): Get current capacity
        System.out.println("Capacity: " + vector.capacity()); // 10 (default)

        System.out.println("--------------------------------------------------------");


        // PriorityQueue: Specific methods
        System.out.println("=== PriorityQueue Unique Methods ===");
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Orange");
        pq.add("Banana");
        pq.add("Apple");
        // peek(): View head (smallest element)
        System.out.println("Peek: " + pq.peek()); // Apple
        // poll(): Remove and return head
        System.out.println("Poll: " + pq.poll()); // Apple
        System.out.println("After poll: " + pq); // [Banana, Orange]
        // offer(E e): Add element (same as add but explicit)
        pq.offer("Mango");
        System.out.println("After offer(Mango): " + pq); // [Banana, Orange, Mango]
        // comparator(): Get comparator (null for natural ordering)
        System.out.println("Comparator: " + pq.comparator()); // null
    }
}