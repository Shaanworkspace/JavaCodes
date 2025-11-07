package Recursion;
import java.util.*;

public class ReverseNodesInKGroupLeetCode25 {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach
    // Hint: Use stack to reverse k nodes at a time
    // ===========================================================
    public ListNode reverseKGroupBrute(ListNode head, int k) {
        // TODO: Use a stack to collect k nodes, pop to reverse
        return null; // dummy placeholder
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug prints)
    // Hint: Count nodes, then reverse in-place groups of k
    // ===========================================================
    public ListNode reverseKGroupTryYourSelf(ListNode head, int k) {
        if (head == null) return null;

        // Step 1: Check if at least k nodes are present
        ListNode kth = stepMover(head, k);
        if (kth == null) {
            return head; // not enough nodes, return as-is
        }

        // Step 2: Save reference to the node right after this group
        ListNode nextGroupHead = kth.next;

        // Step 3: Temporarily break the link — isolate current k-group
        kth.next = null;

        // Step 4: Reverse this isolated part using your reverseMethod2
        ListNode newHead = reverseMethod2(head);

        // Step 5: Connect the tail of this reversed group (original head)
        // to the recursively processed remainder
        head.next = reverseKGroupTryYourSelf(nextGroupHead, k);

        // Step 6: Return the head of the reversed section
        return newHead;
    }

    private ListNode reverseMethod2(ListNode head) {
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

    private static ListNode stepMover(ListNode head , int steps){
        ListNode temp = head;

        for(int i =0;i<steps-1;i++){
            if(temp != null){
                temp=temp.next;
            } else{
                return null;
            }
        }
        return temp;
    }

    private static ListNode reverseGroups(ListNode head,int k ){
        ListNode temp =  stepMover(head,k);
        if(temp==null){
            return head;
        }
        ListNode reversed = reverseGroups(temp.next,k);

        head.next = reversed;

        return temp;

    }


    // ===========================================================
    // ⚡ Optimized (In-place reversal) — O(n) time, O(1) space
    // ===========================================================
    public ListNode reverseKGroup(ListNode head, int k) {
        // TODO: Use dummy node, check if k nodes exist, reverse segment
        // Hint: helper method to reverse a segment between two nodes
        return null; // dummy placeholder
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
    // 🧾 Test Runner — compares all versions and prints ✅ / ❌
    // ===========================================================
    private static void runTest(ReverseNodesInKGroupLeetCode25 solver,
                                int[] inputArr, int k, int[] expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input  : " + Arrays.toString(inputArr));
        System.out.println("k      : " + k);
        System.out.println("Expected: " + Arrays.toString(expected));

        ListNode head1 = arrayToList(inputArr);
        ListNode head2 = arrayToList(inputArr);
        ListNode head3 = arrayToList(inputArr);

        List<Integer> brute = listToArray(solver.reverseKGroupBrute(head1, k));
        List<Integer> your  = listToArray(solver.reverseKGroupTryYourSelf(head2, k));
        List<Integer> opt   = listToArray(solver.reverseKGroup(head3, k));

        List<Integer> exp = new ArrayList<>();
        for (int val : expected) exp.add(val);

        System.out.printf("Brute (Stack)        : %-30s %s%n", brute,
                brute.equals(exp) ? "✅" : "❌");
        System.out.printf("TryYourSelf (Iter)   : %-30s %s%n", your,
                your.equals(exp) ? "✅" : "❌");
        System.out.printf("Optimized (In-place) : %-30s %s%n", opt,
                opt.equals(exp) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        ReverseNodesInKGroupLeetCode25 solver = new ReverseNodesInKGroupLeetCode25();

        System.out.println("=================================================");
        System.out.println("🔗  Reverse Nodes in k-Group — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver,
                new int[]{1, 2, 3, 4, 5}, 2,
                new int[]{2, 1, 4, 3, 5},
                "Test 1");

        runTest(solver,
                new int[]{1, 2, 3, 4, 5}, 3,
                new int[]{3, 2, 1, 4, 5},
                "Test 2");

        runTest(solver,
                new int[]{1, 2, 3, 4, 5}, 1,
                new int[]{1, 2, 3, 4, 5},
                "Test 3 (k=1, no change)");

        runTest(solver,
                new int[]{1}, 1,
                new int[]{1},
                "Test 4 (single node)");
    }
}