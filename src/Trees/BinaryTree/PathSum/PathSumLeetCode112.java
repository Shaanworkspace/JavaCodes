package Trees.BinaryTree.PathSum;

import java.util.*;

/**
 * ===========================================================
 * 🍃 LeetCode 112 — Path Sum
 * ===========================================================
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if there exists a root‑to‑leaf path such that
 * adding up all values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : root = [5,4,8,11,null,13,4,7,2,null,null,null,1],
 *         targetSum = 22
 * Output: true
 *
 * Example  2:
 * Input : root = [1,2,3], targetSum = 5
 * Output: false
 *
 * Example  3:
 * Input : root = [], targetSum = 0
 * Output: false
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0  ≤  #nodes  ≤  5000
 *  • −1000  ≤  Node.val  ≤  1000
 *  • −1000  ≤  targetSum  ≤  1000
 * -----------------------------------------------------------
 */

public class PathSumLeetCode112 {

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
    // Brute‑Force Approach (recursively sum paths)
    // ===========================================================
    public boolean hasPathSumBrute(TreeNode root, int targetSum) {
        return helper(root,targetSum,0);
    }

    private boolean helper(TreeNode root, int targetSum, int currSum) {
        if(root==null) return false;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            return currSum == targetSum;
        }
        boolean leftVala = helper(root.left,targetSum,currSum);
        boolean rightVala = helper(root.right,targetSum,currSum);
        return leftVala || rightVala;
    }

    // ===========================================================
    // TryYourSelf Variant (with debug tracing)
    // ===========================================================
    public boolean hasPathSumTryYourSelf(TreeNode root, int targetSum) {
        // TODO: implement monitored recursion with printed steps
        return false; // placeholder
    }

    // ===========================================================
    // Optimized DFS Solution — O(n)
    // ===========================================================
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // TODO: implement optimized recursion returning boolean early
        return false; // placeholder
    }

    // ===========================================================
    // Test Runner — compares all versions
    // ===========================================================
    private static void runTest(PathSumLeetCode112 solver,
                                TreeNode root, int targetSum, boolean expected, String name) {
        System.out.println("🔹 " + name);
        System.out.println("Target Sum : " + targetSum);

        boolean brute = solver.hasPathSumBrute(root, targetSum);
        boolean your  = solver.hasPathSumTryYourSelf(root, targetSum);
        boolean opt   = solver.hasPathSum(root, targetSum);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-5b%n", brute);
        System.out.printf("TryYourSelf      : %-5b%n", your);
        System.out.printf("Optimized (O(n)) : %-5b%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Demo Dashboard
    // ===========================================================
    public static void main(String[] args) {
        PathSumLeetCode112 solver = new PathSumLeetCode112();

        System.out.println("=================================================");
        System.out.println("  Path Sum — Tests");
        System.out.println("=================================================\n");

        // Example  1
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, null, new TreeNode(1)))
        );

        // Example  2
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        // Example  3
        TreeNode root3 = null;

        runTest(solver, root1, 22, true,  "Test  1");
        runTest(solver, root2, 5,  false, "Test  2");
        runTest(solver, root3, 0,  false, "Test  3");
    }
}