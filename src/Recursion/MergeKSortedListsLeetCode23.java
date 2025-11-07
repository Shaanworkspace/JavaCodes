package Recursion;
import java.util.*;

public class MergeKSortedListsLeetCode23 {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach (Merge lists one by one)
    // Time: O(k*N) where N is total nodes, Space: O(1)
    // ===========================================================
    public ListNode mergeKListsBrute(ListNode[] lists) {
        // TODO: Merge lists sequentially one by one
        // Hint: Use a helper method to merge two lists repeatedly
        return null; // dummy placeholder
    }

    // ===========================================================
    // ✍️ TryYourSelf (Divide & Conquer with debug hints)
    // Time: O(N log k), Space: O(log k) recursion
    // ===========================================================
    public ListNode mergeKListsTryYourSelf(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeRange(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;

        ListNode l1 = mergeRange(lists,left,mid);
        ListNode l2 = mergeRange(lists,mid+1,right);
        return mergeTwoLists(l1,l2);
    }

    // ===========================================================
    // ⚡ Optimized (Min-Heap / Priority Queue) — O(N log k)
    // ===========================================================
    public ListNode mergeKLists(ListNode[] lists) {
        // TODO: Use a PriorityQueue to always pick smallest node
        // Hint: Add all list heads to heap, poll smallest, add its next
        return null; // dummy placeholder
    }

    // ===========================================================
    // Helper: Convert array to ListNode
    // ===========================================================

    private static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode();
        ListNode newll = dummy;
        while(l1 != null && l2!=null){
            if(l1.val>l2.val){
                newll.next=l2;
                l2=l2.next;
            } else{
                newll.next=l1;
                l1=l1.next;
            }
            newll=newll.next;
        }
        newll.next = (l1!=null)?l1:l2;
        return dummy.next;
    }
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
    // Helper: Convert ListNode to array for comparison
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
    private static void runTest(MergeKSortedListsLeetCode23 solver,
                                int[][] listsData, int[] expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input Lists:");
        for (int[] data : listsData) {
            System.out.println("  " + Arrays.toString(data));
        }
        System.out.println("Expected : " + Arrays.toString(expected));

        // Create three separate copies for each method
        ListNode[] lists1 = new ListNode[listsData.length];
        ListNode[] lists2 = new ListNode[listsData.length];
        ListNode[] lists3 = new ListNode[listsData.length];

        for (int i = 0; i < listsData.length; i++) {
            lists1[i] = arrayToList(listsData[i]);
            lists2[i] = arrayToList(listsData[i]);
            lists3[i] = arrayToList(listsData[i]);
        }

        List<Integer> brute = listToArray(solver.mergeKListsBrute(lists1));
        List<Integer> your  = listToArray(solver.mergeKListsTryYourSelf(lists2));
        List<Integer> opt   = listToArray(solver.mergeKLists(lists3));

        List<Integer> exp = new ArrayList<>();
        for (int val : expected) exp.add(val);

        System.out.printf("Brute (Sequential)   : %-30s %s%n", brute,
                brute.equals(exp) ? "✅" : "❌");
        System.out.printf("TryYourSelf (D&C)    : %-30s %s%n", your,
                your.equals(exp) ? "✅" : "❌");
        System.out.printf("Optimized (Min-Heap) : %-30s %s%n", opt,
                opt.equals(exp) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        MergeKSortedListsLeetCode23 solver = new MergeKSortedListsLeetCode23();

        System.out.println("=================================================");
        System.out.println("🔗  Merge k Sorted Lists — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver,
                new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}},
                new int[]{1, 1, 2, 3, 4, 4, 5, 6},
                "Test 1");

        runTest(solver,
                new int[][]{},
                new int[]{},
                "Test 2 (empty)");

        runTest(solver,
                new int[][]{{}},
                new int[]{},
                "Test 3 (single empty list)");

        runTest(solver,
                new int[][]{{1}, {0}},
                new int[]{0, 1},
                "Test 4 (two single nodes)");
    }
}