package Trees.BinaryTree;

import java.util.*;

/**
 * ===========================================================
 * 🌲 LeetCode 226 — Invert Binary Tree
 *
 * https://youtu.be/ThQ7dGtBdAE?t=14453
 * ===========================================================
 *
 * Given the root of a binary tree, invert the tree and
 * return its root.
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Example  2:
 * Input : root = [2,1,3]
 * Output: [2,3,1]
 *
 * Example  3:
 * Input : root = []
 * Output: []
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0  ≤  #nodes  ≤  100
 *  • −100  ≤  Node.val  ≤  100
 * -----------------------------------------------------------
 */

public class InvertBinaryTreeLeetCode226 {

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
    // 🐢 Brute‑Force Approach (recursive swap)
    // ===========================================================
    public TreeNode invertTreeBrute(TreeNode root) {
        if(root==null){
            return null;
        }
        //swap
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        invertTreeBrute(root.left);
        invertTreeBrute(root.right);
        return root;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug tracing)
    // ===========================================================
    public TreeNode invertTreeTryYourSelf(TreeNode root) {
        // TODO: implement traced recursion for practice
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Iterative BFS Solution — O(n)
    // ===========================================================
    public TreeNode invertTree(TreeNode root) {
        // TODO: implement optimal queue‑based BFS inversion
        return null; // placeholder
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
        List<String> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                list.add("null");
                continue;
            }
            list.add(String.valueOf(node.val));
            if (node.left != null || node.right != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.println(list);
    }

    // ===========================================================
    // 🧾 Test Runner
    // ===========================================================
    private static void runTest(InvertBinaryTreeLeetCode226 solver,
                                TreeNode root, String testName) {
        System.out.println("🔹 " + testName);
        System.out.print("Original : ");
        printTree(root);

        TreeNode brute = solver.invertTreeBrute(root);
        TreeNode your  = solver.invertTreeTryYourSelf(root);
        TreeNode opt   = solver.invertTree(root);

        System.out.print("Brute Force      : "); printTree(brute);
        System.out.print("TryYourSelf      : "); printTree(your);
        System.out.print("Optimized (O(n)) : "); printTree(opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {
        InvertBinaryTreeLeetCode226 solver = new InvertBinaryTreeLeetCode226();

        System.out.println("=================================================");
        System.out.println("🌲  Invert Binary Tree — Tests");
        System.out.println("=================================================\n");

        // Example  1
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        // Example  2
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        // Example  3
        TreeNode root3 = null;

        runTest(solver, root1, "Test  1");
        runTest(solver, root2, "Test  2");
        runTest(solver, root3, "Test  3");
    }
}