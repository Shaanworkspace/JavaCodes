package Trees.BinaryTree.Basics.Traversal;

import java.util.*;

/**
 * ===========================================================
 * 🌲 LeetCode 103 — Binary Tree Zigzag Level Order Traversal
 * ===========================================================
 *
 * Given the root of a binary tree, return the zigzag level‑order
 * traversal of its nodes' values.
 *
 * (Left→Right for one level, then Right→Left for the next, and so on.)
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : root = [3,9,20,null,null,15,7]
 * Output: [[3], [20,9], [15,7]]
 *
 * Example  2:
 * Input : root = [1]
 * Output: [[1]]
 *
 * Example  3:
 * Input : root = []
 * Output: []
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0  ≤  #nodes  ≤  2000
 *  • −100  ≤  Node.val  ≤  100
 * -----------------------------------------------------------
 */

public class BinaryTreeZigzagLevelOrderTraversalLeetCode103 {

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
    // 🐢 Brute‑Force Approach (collect all levels, then reverse alternate)
    // ===========================================================

    public List<List<Integer>> zigzagLevelOrderBrute(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int levels = levelOfBT(root);

        for(int i =0;i<levels;i++){
            if(i%2==0){
                result.add(printNthLevelLeftToRight(root,i+1,new ArrayList<>()));
            }else{
                result.add(printNthLevelRightToLeft(root,i+1,new ArrayList<>()));
            }
        }
        return result;
    }

    public static int levelOfBT(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levelOfBT(root.left),levelOfBT(root.right));
    }
    public static List<Integer> printNthLevelLeftToRight(TreeNode root, int level,List<Integer> integerList) {

        if(root==null) return null;

        if(level==1) {
            integerList.add(root.val);
            return integerList;
        }

        printNthLevelLeftToRight(root.left,level-1,integerList);

        printNthLevelLeftToRight(root.right,level-1,integerList);
        return integerList;
    }

    public static List<Integer> printNthLevelRightToLeft(TreeNode root,int level,List<Integer> integerList) {

        if(root==null) return null;

        if(level==1) {
            integerList.add(root.val);
            return integerList;
        }

        printNthLevelRightToLeft(root.right,level-1,integerList);
        printNthLevelRightToLeft(root.left,level-1,integerList);
        return integerList;

    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with print tracing)
    // ===========================================================
    public List<List<Integer>> zigzagLevelOrderTryYourSelf(TreeNode root) {
        // TODO: implement your own traced version
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Single‑Pass BFS — O(n)
    // ===========================================================
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // TODO: implement direction‑aware BFS traversal
        return null; // placeholder
    }

    // ===========================================================
    // 🧾 Helper — pretty‑print a list of levels
    // ===========================================================
    private static void printLevels(List<List<Integer>> levels) {
        if (levels == null) {
            System.out.println("null");
            return;
        }
        System.out.println(levels);
    }

    // ===========================================================
    // 🧾 Test Runner — to compare methods
    // ===========================================================
    private static void runTest(BinaryTreeZigzagLevelOrderTraversalLeetCode103 solver,
                                TreeNode root, List<List<Integer>> expected, String name) {
        System.out.println("🔹 " + name);

        List<List<Integer>> brute = solver.zigzagLevelOrderBrute(root);
        List<List<Integer>> your  = solver.zigzagLevelOrderTryYourSelf(root);
        List<List<Integer>> opt   = solver.zigzagLevelOrder(root);

        System.out.println("Expected : " + expected);
        System.out.print("Brute Force      : "); printLevels(brute);
        System.out.print("TryYourSelf      : "); printLevels(your);
        System.out.print("Optimized (O(n)) : "); printLevels(opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversalLeetCode103 solver =
                new BinaryTreeZigzagLevelOrderTraversalLeetCode103();

        System.out.println("=================================================");
        System.out.println("🌲  Binary Tree Zigzag Level Order Traversal — Tests");
        System.out.println("=================================================\n");

        // Example  1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        // Example  2
        TreeNode root2 = new TreeNode(1);

        // Example  3
        TreeNode root3 = null;

        runTest(solver, root1,
                Arrays.asList(
                        Arrays.asList(3),
                        Arrays.asList(20, 9),
                        Arrays.asList(15, 7)
                ), "Test  1");

        runTest(solver, root2,
                Arrays.asList(Arrays.asList(1)),
                "Test  2");

        runTest(solver, root3,
                new ArrayList<>(),
                "Test  3");
    }
}