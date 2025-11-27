package Trees.BinaryTree.Basics.Traversal;

import java.util.*;

/**
 * ===========================================================
 * 🌿 LeetCode 257 — Binary Tree Paths
 * ===========================================================
 *
 * Given the root of a binary tree, return all root‑to‑leaf paths
 * (in any order). A leaf is a node with no children.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 * Example 2:
 * Input : root = [1]
 * Output: ["1"]
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1 ≤ #nodes ≤ 100
 *  • −100 ≤ Node.val ≤ 100
 * -----------------------------------------------------------
 */

public class BinaryTreePathsLeetCode257 {

    // Basic TreeNode
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
        public String toString() { return String.valueOf(val); }
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach (explicitly build full paths)
    // ===========================================================
    public List<String> binaryTreePathsBrute(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root,"",result);
        return result;
    }

    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        if (path.isEmpty()) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        if(root.left==null && root.right==null){
            result.add(path);
            return;
        }

        helper(root.left, path,result);

        helper(root.right, path,result);
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug printing)
    // ===========================================================
    public List<String> binaryTreePathsTryYourSelf(TreeNode root) {
        // TODO: implement traced recursion
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Backtracking DFS — O(n)
    // ===========================================================
    public List<String> binaryTreePaths(TreeNode root) {
        // TODO: implement efficient recursive solution
        return null; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compares outputs of all variants
    // ===========================================================
    private static void runTest(BinaryTreePathsLeetCode257 solver,
                                TreeNode root, List<String> expected, String name) {
        System.out.println("🔹 " + name);

        List<String> brute = solver.binaryTreePathsBrute(root);
        List<String> your  = solver.binaryTreePathsTryYourSelf(root);
        List<String> opt   = solver.binaryTreePaths(root);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-20s%n", brute);
        System.out.printf("TryYourSelf      : %-20s%n", your);
        System.out.printf("Optimized (O(n)) : %-20s%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Manual Demo Dashboard
    // ===========================================================
    public static void main(String[] args) {
        BinaryTreePathsLeetCode257 solver = new BinaryTreePathsLeetCode257();

        System.out.println("=================================================");
        System.out.println("🌿  Binary Tree Paths — Tests");
        System.out.println("=================================================\n");

        // Example 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3)
        );

        // Example 2
        TreeNode root2 = new TreeNode(1);

        runTest(solver, root1, Arrays.asList("1->2->5","1->3"), "Test 1");
        runTest(solver, root2, Arrays.asList("1"), "Test 2");
    }
}