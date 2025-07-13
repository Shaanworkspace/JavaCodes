package Collections.Queue;

import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");

        System.out.println("Head: " + queue.peek());
        System.out.println("Removed: " + queue.poll());
        System.out.println("Queue now: " + queue);
    }
}

