package LinkedList;


public class ArrayToLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Create the head node
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        // Create remaining nodes
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Example usage
    public static void main(String[] args) {
        // Your specific array
        int[] arr = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};

        System.out.println("Array: [7, 9, 6, 6, 7, 8, 3, 0, 9, 5]");

        ListNode head = arrayToLinkedList(arr);
        System.out.println("Linked List: " + head);

        // Print individual node values to verify
        System.out.println("\nNode values:");
        ListNode current = head;
        int position = 0;
        while (current != null) {
            System.out.println("Node " + position + ": " + current.val);
            current = current.next;
            position++;
        }
    }
}