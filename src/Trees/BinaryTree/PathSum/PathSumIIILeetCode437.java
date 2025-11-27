package Trees.BinaryTree.PathSum;

import java.util.*;

/**
 * ===========================================================
 * 🌳 LeetCode 437 — Path Sum III
 * https://youtu.be/ThQ7dGtBdAE?t=20933
 * ===========================================================
 *
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of node values
 * along the path equals targetSum.
 *
 * The path does *not* need to start or end at the root or a leaf,
 * but must go downwards (parent → child path).
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input :
 *  root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 *
 * Example  2:
 * Input :
 *  root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0  ≤  #nodes  ≤  1000
 *  • −10⁹  ≤  Node.val  ≤  10⁹
 *  • −1000  ≤  targetSum  ≤  1000
 * -----------------------------------------------------------
 */

public class PathSumIIILeetCode437 {

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
            this.val = val; this.left = left; this.right = right;
        }
        @Override
        public String toString() { return String.valueOf(val); }
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach (DFS starting at each node)
    // ===========================================================

    /*
    public int pathSumBrute(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int count = noOfPaths(root, (long) targetSum);
        count += pathSum(root.left, targetSum)
            + pathSum(root.right, targetSum);
        return count;
    }
     */
    public int pathSumBrute(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int totalCount = 0;

        int pathsStartingHere = noOfPaths(root, (long) targetSum);
        int pathsInLeftSubtree = pathSumBrute(root.left, targetSum);
        int pathsInRightSubtree = pathSumBrute(root.right, targetSum);

        totalCount += pathsStartingHere;
        totalCount += pathsInLeftSubtree;
        totalCount += pathsInRightSubtree;

        return totalCount;

    }
    public int noOfPaths(TreeNode root, long targetSum) {
        if (root == null) return 0;

        int count = 0;
        if (root.val == targetSum) count++;

        long remainingSum = targetSum - root.val;

        int leftPaths = noOfPaths(root.left, remainingSum);
        int rightPaths = noOfPaths(root.right, remainingSum);
        int totalPathsFromThisNode = count + leftPaths + rightPaths;
        return totalPathsFromThisNode;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (debug tracing)
    // ===========================================================
    public int pathSumTryYourSelf(TreeNode root, int targetSum) {
        // TODO: implement traced recursion for debugging
        return 0; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Prefix‑Sum Approach — O(n)
    // ===========================================================
    public int pathSum(TreeNode root, int targetSum) {
        // TODO: implement prefix‑sum solution
        return 0; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compares all methods
    // ===========================================================
    private static void runTest(PathSumIIILeetCode437 solver,
                                TreeNode root, int targetSum,
                                int expected, String name) {
        System.out.println("🔹 " + name);
        System.out.println("Target Sum : " + targetSum);

        int brute = solver.pathSumBrute(root, targetSum);
        int your  = solver.pathSumTryYourSelf(root, targetSum);
        int opt   = solver.pathSum(root, targetSum);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-5d%n", brute);
        System.out.printf("TryYourSelf      : %-5d%n", your);
        System.out.printf("Optimized (O(n)) : %-5d%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {
        PathSumIIILeetCode437 solver = new PathSumIIILeetCode437();

        System.out.println("=================================================");
        System.out.println("🌳  Path Sum III — Tests");
        System.out.println("=================================================\n");

        // Example  1
        TreeNode root1 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))
                ),
                new TreeNode(-3, null, new TreeNode(11))
        );

        // Example  2
        TreeNode root2 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );

        runTest(solver, root1, 8, 3, "Test  1");
        runTest(solver, root2, 22, 3, "Test  2");
    }
}