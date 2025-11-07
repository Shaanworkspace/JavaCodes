package LinkedList;

import java.util.*;

public class ReverseLinkedList {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // ===========================================================
    // 🐢 Method 1: Brute‑Force (Using Stack)
    // Hint: Push all nodes to stack, pop to reverse
    // ===========================================================
    public ListNode reverseMethod1(ListNode head) {
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        temp = head;
        while (temp!=null){
            temp.val=st.pop();
            temp=temp.next;
        }
        return head;
    }

    // ===========================================================
    // ✍️ Method 2: TryYourSelf (Recursive approach)
    // Hint: Reverse rest of list, then fix pointers

    // ===========================================================
    public ListNode reverseMethod2(ListNode head) {
        /*
        initially : (head)1 --> 2  --> 3 --> 4 --> 5 --> 6 --> null
        newHead : (newHead)6 --> 5 -->  4  --> 3  --> 2 <-- 1(head)

        now reverse : (head)6 --> 5 -->  4  --> 3  --> 2 --> 1 --> null
         */
        if(head == null || head.next == null){
            return head;
        }

        ListNode nextHead = reverseMethod2(head.next);

        head.next.next = head;
        head.next = null;

        return nextHead;
    }

    // ===========================================================
    // ⚡ Method 3: Optimized (Iterative with 3 pointers)
    // Hint: prev, curr, next — flip pointers in one pass
    // ===========================================================
    public ListNode reverseMethod3(ListNode head) {
        if(head==null) return head;
        ListNode prevNode = null,tempNode=head,nextNode;

        while(tempNode!=null){
            nextNode = tempNode.next;
            tempNode.next = prevNode;
            prevNode=tempNode;
            tempNode = nextNode;
        }
        return prevNode;
    }

    // ===========================================================
    // Helper: Convert array to ListNode
    // ===========================================================
    private static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // ===========================================================
    // Helper: Convert ListNode to List for comparison
    // ===========================================================
    private static List<Integer> listToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // ===========================================================
    // Helper: Print list
    // ===========================================================
    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ===========================================================
    // 🧾 Test Runner — compares all methods and prints ✅ / ❌
    // ===========================================================
    private static void runTest(ReverseLinkedList solver,
                                int[] inputArr, int[] expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input    : " + Arrays.toString(inputArr));
        System.out.println("Expected : " + Arrays.toString(expected));

        ListNode head1 = arrayToList(inputArr);
        ListNode head2 = arrayToList(inputArr);
        ListNode head3 = arrayToList(inputArr);

        List<Integer> method1 = listToArray(solver.reverseMethod1(head1));
        List<Integer> method2 = listToArray(solver.reverseMethod2(head2));
        List<Integer> method3 = listToArray(solver.reverseMethod3(head3));

        List<Integer> exp = new ArrayList<>();
        for (int val : expected) exp.add(val);

        System.out.printf("Method 1 (Stack)     : %-30s %s%n", method1,
                method1.equals(exp) ? "✅" : "❌");
        System.out.printf("Method 2 (Recursive) : %-30s %s%n", method2,
                method2.equals(exp) ? "✅" : "❌");
        System.out.printf("Method 3 (Iterative) : %-30s %s%n", method3,
                method3.equals(exp) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();

        System.out.println("=================================================");
        System.out.println("🔗  Reverse Linked List — Three Methods");
        System.out.println("=================================================\n");

        runTest(solver,
                new int[]{1, 2, 3, 4, 5},
                new int[]{5, 4, 3, 2, 1},
                "Test 1");

        runTest(solver,
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{7, 6, 5, 4, 3, 2, 1},
                "Test 2");

        runTest(solver,
                new int[]{1, 2},
                new int[]{2, 1},
                "Test 3");

        runTest(solver,
                new int[]{1},
                new int[]{1},
                "Test 4 (single node)");

        runTest(solver,
                new int[]{},
                new int[]{},
                "Test 5 (empty list)");
    }
}