package Trees.BinaryTree;

import java.util.*;

/**
 * ===========================================================
 * 🌸 LeetCode 101 — Symmetric Tree
 * ===========================================================
 *
 * Given the root of a binary tree, determine whether it is a
 * mirror of itself (i.e., symmetric around its center).
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example  2:
 * Input : root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1  ≤  #nodes  ≤  1000
 *  • −100  ≤  Node.val  ≤  100
 * -----------------------------------------------------------
 * Follow‑up:
 *  Solve both recursively and iteratively.
 */

public class SymmetricTreeLeetCode101 {


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
    // 🐢 Brute‑Force Approach (build mirror & compare)
    // ===========================================================
    public boolean isSymmetricBrute(TreeNode root) {
        // TODO: implement by constructing mirror and comparing
        return false; // placeholder
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug tracing)
    // ===========================================================
    public boolean isSymmetricTryYourSelf(TreeNode root) {
        // TODO: implement traced recursion for self‑practice
        return false; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Recursive + Iterative Versions — O(n)
    // ===========================================================
    public boolean isSymmetric(TreeNode root) {
        // TODO: implement recursion comparing left/right subtrees
        return false; // placeholder
    }

    // ===========================================================
    // 🧾 Helper — print tree level‑order
    // ===========================================================
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<String> nodes = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                nodes.add("null");
                continue;
            }
            nodes.add(String.valueOf(node.val));
            if (node.left != null || node.right != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.println(nodes);
    }

    // ===========================================================
    // 🧾 Test Runner
    // ===========================================================
    private static void runTest(SymmetricTreeLeetCode101 solver,
                                TreeNode root, boolean expected, String name) {
        System.out.println("🔹 " + name);
        System.out.print("Tree : ");
        printTree(root);

        boolean brute = solver.isSymmetricBrute(root);
        boolean your  = solver.isSymmetricTryYourSelf(root);
        boolean opt   = solver.isSymmetric(root);

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
        SymmetricTreeLeetCode101 solver = new SymmetricTreeLeetCode101();

        System.out.println("=================================================");
        System.out.println("🌸  Symmetric Tree — Tests");
        System.out.println("=================================================\n");

        // Example  1: symmetric
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        // Example  2: not symmetric
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );

        // Example  3: single node
        TreeNode root3 = new TreeNode(5);

        runTest(solver, root1, true,  "Test  1");
        runTest(solver, root2, false, "Test  2");
        runTest(solver, root3, true,  "Test  3");
    }
}