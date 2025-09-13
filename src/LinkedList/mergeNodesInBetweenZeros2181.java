package LinkedList;

import java.util.List;

public class mergeNodesInBetweenZeros2181 {
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

    public static void print(ListNode head){
        int len=0;
        ListNode temp = head;
        System.out.print("[ ");
        while(temp != null){
            System.out.print(temp.val+" ");
            len++;
            temp=temp.next;
        }
        System.out.print(" ]");

        System.out.println("Length of List :"+len);
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int sum=0;

        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                // Insert the sum as new node
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0; // reset for next block
            } else {
                sum += head.val;
            }
            head = head.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        int[] arr = {0,24,14,0};
        ListNode head = arrayToLinkedList(arr);
        print(head);
        mergeNodesInBetweenZeros2181 n = new mergeNodesInBetweenZeros2181();
        ListNode result = n.mergeNodes(head);
        print(result);
    }
}
