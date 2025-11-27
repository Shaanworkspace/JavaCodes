package Trees.BinaryTree;

import java.util.*;

/**
 * ===========================================================
 * 🌲 LeetCode 110 — Balanced Binary Tree
 * ===========================================================
 *
 * Determine if a binary tree is height‑balanced.
 *
 * A binary tree in which the left and right subtrees of every node
 * differ in height by no more than 1 is called balanced.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 * Input : root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 * Input : root = []
 * Output: true
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0 ≤ #nodes ≤ 5000
 *  • −10⁴ ≤ Node.val ≤ 10⁴
 * -----------------------------------------------------------
 */

public class BalancedBinaryTreeLeetCode110 {

    // Basic TreeNode class for testing
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach (compute height repeatedly)
    // ===========================================================
    public boolean isBalancedBrute(TreeNode root) {
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        boolean leftBalanced = isBalancedBrute(root.left);
        boolean rightBalanced = isBalancedBrute(root.right);

        return leftBalanced && rightBalanced;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug tracing)
    // ===========================================================
    public boolean isBalancedTryYourSelf(TreeNode root) {
        // TODO: implement traced recursion for learning
        return false; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Bottom‑Up DFS — O(n)
    // ===========================================================
    public boolean isBalanced(TreeNode root) {
        // TODO: implement efficient height check in single traversal
        return false; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compares all approaches
    // ===========================================================
    private static void runTest(BalancedBinaryTreeLeetCode110 solver,
                                TreeNode root, boolean expected, String name) {
        System.out.println("🔹 " + name);

        boolean brute = solver.isBalancedBrute(root);
        boolean your  = solver.isBalancedTryYourSelf(root);
        boolean opt   = solver.isBalanced(root);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-5b%n", brute);
        System.out.printf("TryYourSelf      : %-5b%n", your);
        System.out.printf("Optimized (O(n)) : %-5b%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {
        BalancedBinaryTreeLeetCode110 solver = new BalancedBinaryTreeLeetCode110();

        System.out.println("=================================================");
        System.out.println("🌲  Balanced Binary Tree — Tests");
        System.out.println("=================================================\n");

        // Example 1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        // Example 2
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)),
                new TreeNode(2)
        );

        // Example 3
        TreeNode root3 = null;

        runTest(solver, root1, true,  "Test 1");
        runTest(solver, root2, false, "Test 2");
        runTest(solver, root3, true,  "Test 3");
    }
}