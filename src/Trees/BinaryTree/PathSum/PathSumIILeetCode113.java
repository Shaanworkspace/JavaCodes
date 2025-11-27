package Trees.BinaryTree.PathSum;
import java.util.*;

/**
 * ===========================================================
 * 🍂 LeetCode 113 — Path Sum II
 * https://youtu.be/ThQ7dGtBdAE?t=19955
 * ===========================================================
 *
 * Given the root of a binary tree and an integer targetSum,
 * return all root‑to‑leaf paths such that the sum of node values
 * in the path equals targetSum.
 *
 * Each path should be returned as a list of node values.
 * A root‑to‑leaf path starts at root and ends at a leaf node.
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input :
 *  root = [5,4,8,11,null,13,4,7,2,null,null,5,1],
 *  targetSum = 22
 * Output : [[5,4,11,2],[5,8,4,5]]
 *
 * Example  2:
 * Input : root = [1,2,3], targetSum = 5
 * Output: []
 *
 * Example  3:
 * Input : root = [1,2], targetSum = 0
 * Output: []
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0  ≤  #nodes  ≤  5000
 *  • −1000  ≤  Node.val  ≤  1000
 *  • −1000  ≤  targetSum  ≤  1000
 * -----------------------------------------------------------
 */

public class PathSumIILeetCode113 {

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
    // 🐢 Brute‑Force Approach (enumerate all paths)
    // ===========================================================
    public List<List<Integer>> pathSumBrute(TreeNode root, int targetSum) {
        List<List<Integer>> result= new ArrayList<>();
        helper(root,targetSum,new ArrayList<>(),result);
        return result;

    }

    private void helper(TreeNode root, int targetSum, ArrayList<Integer> currList, List<List<Integer>> result) {
        if(root==null) return;
        currList.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == targetSum) {
                result.add(new ArrayList<>(currList));
                currList.removeLast(); //ye bhut jroori hai <--
                return;
            }
        }

        helper(root.left,targetSum-root.val,currList,result);
        helper(root.right,targetSum-root.val,currList,result);
        currList.removeLast();
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for tracing / step‑debugging)
    // ===========================================================
    public List<List<Integer>> pathSumTryYourSelf(TreeNode root, int targetSum) {
        // TODO: implement recursive version with debug prints
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Backtracking Approach — O(n)
    // ===========================================================
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // TODO: implement efficient backtracking
        return null; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compare all results
    // ===========================================================
    private static void runTest(PathSumIILeetCode113 solver,
                                TreeNode root, int targetSum,
                                List<List<Integer>> expected, String name) {
        System.out.println("🔹 " + name);
        System.out.println("Target Sum : " + targetSum);

        List<List<Integer>> brute = solver.pathSumBrute(root, targetSum);
        List<List<Integer>> your  = solver.pathSumTryYourSelf(root, targetSum);
        List<List<Integer>> opt   = solver.pathSum(root, targetSum);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-25s%n", brute);
        System.out.printf("TryYourSelf      : %-25s%n", your);
        System.out.printf("Optimized (O(n)) : %-25s%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {
        PathSumIILeetCode113 solver = new PathSumIILeetCode113();

        System.out.println("=================================================");
        System.out.println("🍂  Path Sum II — Tests");
        System.out.println("=================================================\n");

        // Example  1
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );

        // Example  2
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        // Example  3
        TreeNode root3 = new TreeNode(1, new TreeNode(2), null);

        runTest(solver, root1, 22,
                Arrays.asList(
                        Arrays.asList(5, 4, 11, 2),
                        Arrays.asList(5, 8, 4, 5)),
                "Test  1");

        runTest(solver, root2, 5, new ArrayList<>(), "Test  2");
        runTest(solver, root3, 0, new ArrayList<>(), "Test  3");
    }
}