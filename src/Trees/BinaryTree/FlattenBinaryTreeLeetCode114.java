package Trees.BinaryTree;

import java.util.*;

/**
 * ===========================================================
 * 🌴 LeetCode 114 — Flatten Binary Tree to Linked List
 *
 * https://youtu.be/ThQ7dGtBdAE?t=25177
 * ===========================================================
 *
 * Given the root of a binary tree, flatten the tree into a
 * "linked list" *in‑place*.
 *
 * The linked list must use the same TreeNode class where:
 *   • right child → next node in the list
 *   • left child  → always null
 *   • list order  → preorder traversal of the tree
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * Example  2:
 * Input : root = []
 * Output: []
 *
 * Example  3:
 * Input : root = [0]
 * Output: [0]
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0  ≤  #nodes  ≤  2000
 *  • −100  ≤  Node.val  ≤  100
 * -----------------------------------------------------------
 * Follow  up:
 *  Can you flatten the tree *in‑place* using O(1) extra space?
 */

public class FlattenBinaryTreeLeetCode114 {

    // ===========================================================
    // 🧱 TreeNode Definition
    // ===========================================================
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() { return String.valueOf(val); }
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach (collect preorder, rebuild)
    // ===========================================================
    public void flattenBrute(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode current = list.get(i);
            TreeNode next = list.get(i + 1);
            current.left = null;
            current.right = next;
        }

    }

    private void preorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug tracing)
    // ===========================================================
    public void flattenTryYourSelf(TreeNode root) {
        // TODO: implement traced recursion for educational purposes
    }

    // ===========================================================
    // ⚡ Optimized In‑Place Approach — O(n) / O(1) extra space
    // ===========================================================
    public void flatten(TreeNode root) {
        // TODO: implement in‑place flatten (Morris / reverse preorder)
    }

    // ===========================================================
    // 🧾 Helper — print flattened list (via right pointers)
    // ===========================================================
    private static void printFlattened(TreeNode root) {
        TreeNode curr = root;
        List<Integer> vals = new ArrayList<>();
        while (curr != null) {
            vals.add(curr.val);
            curr = curr.right;
        }
        System.out.println(vals);
    }

    // ===========================================================
    // 🧾 Test Runner — compares all approaches
    // ===========================================================
    private static void runTest(FlattenBinaryTreeLeetCode114 solver,
                                TreeNode root, String name) {
        System.out.println("🔹 " + name);

        TreeNode c1 = copyTree(root);
        TreeNode c2 = copyTree(root);
        TreeNode c3 = copyTree(root);

        solver.flattenBrute(c1);
        solver.flattenTryYourSelf(c2);
        solver.flatten(c3);

        System.out.print("Brute Force      : "); printFlattened(c1);
        System.out.print("TryYourSelf      : "); printFlattened(c2);
        System.out.print("Optimized (O(1)) : "); printFlattened(c3);
        System.out.println("--------------------------------------------\n");
    }

    // clone helper to reuse test roots
    private static TreeNode copyTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = copyTree(root.left);
        node.right = copyTree(root.right);
        return node;
    }

    // ===========================================================
    // 🚀 PSVM — Test Dashboard
    // ===========================================================
    public static void main(String[] args) {
        FlattenBinaryTreeLeetCode114 solver = new FlattenBinaryTreeLeetCode114();

        System.out.println("=================================================");
        System.out.println("🌴  Flatten Binary Tree to Linked List — Tests");
        System.out.println("=================================================\n");

        // Example  1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6))
        );

        // Example  2
        TreeNode root2 = null;

        // Example  3
        TreeNode root3 = new TreeNode(0);

        runTest(solver, root1, "Test  1");
        runTest(solver, root2, "Test  2");
        runTest(solver, root3, "Test  3");
    }
}