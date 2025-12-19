package Trees.BinaryTree;
import Recursion.MazePath.DeadMaze.RatInADeadMazeFourDirection;

import java.util.*;

/**
 * ===========================================================
 * 🌳 LeetCode 543 — Diameter of Binary Tree
 * ===========================================================
 *
 * Given the root of a binary tree, return the length of the
 * diameter of the tree.
 *
 * The diameter is the length of the longest path between any
 * two nodes in a tree (in edges), possibly passing through the root.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : root = [1,2,3,4,5]
 * Output: 3
 * Explanation: paths [4,2,1,3] or [5,2,1,3]
 *
 * Example 2:
 * Input : root = [1,2]
 * Output: 1
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1 ≤ #nodes ≤ 10⁴
 *  • −100 ≤ Node.val ≤ 100
 * -----------------------------------------------------------
 */

public class DiameterOfBinaryTreeLeetCode543 {

    // Node structure for internal tests
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
    // 🐢 Brute‑Force Approach (baseline)
    // ===========================================================
    public int diameterOfBinaryTreeBrute(TreeNode root) {

        if(root==null || (root.left==null && root.right==null)) return 0;


        int mid = size(root.left)+size(root.right);
        if(root.left!=null) mid++;
        if(root.right!=null) mid++;

        int left = diameterOfBinaryTreeBrute(root.left);
        int right = diameterOfBinaryTreeBrute(root.right);

        int max = Math.max(mid,Math.max(left,right));
        return max;

    }
    public static int size(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return 0;
        // our work is to get the sum of left and right then add the root vala node in it and return
        int left = size(root.left);
        int right = size(root.right);
        return 1+Math.max(left,right);
    }

    // ===========================================================
    // TryYourSelf Variant (with debug tracing)
    // ===========================================================
    public int diameterOfBinaryTreeTryYourSelf(TreeNode root) {
        int height = height(root);
        int dia=0;
        for(int i =1;i<=height+1;i++){
            List<Integer> arr = new ArrayList<>();
            findDia(root,i,arr);
            for(int n:arr){
                dia=Math.max(dia,n);
            }
        }
        return dia;
    }

    private void findDia(TreeNode root, int level,List<Integer> arr) {
        if(root==null) return;
        if(level==1){
            int left =0;
            int right =0;
            int mid=0;
            if(root.left!=null) left=height(root.left);
            if(root.right!=null) right=height(root.right);
            mid=left+right;
            if(root.left!=null) mid++;
            if(root.right!=null) mid++;
            arr.add(mid);
            return ;
        }
        findDia(root.left,level-1,arr);
        findDia(root.right,level-1,arr);
    }

    public static int height(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1+Math.max(left,right);
    }

    // ===========================================================
    // ⚡ Optimized O(n) DFS — compute height & diameter together
    // ===========================================================
    public int diameterOfBinaryTree(TreeNode root) {
        // TODO: implement optimized single‑DFS algorithm
        return 0; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — helper to compare outputs
    // ===========================================================
    private static void runTest(DiameterOfBinaryTreeLeetCode543 solver,
                                TreeNode root, int expected, String name) {
        System.out.println("🔹 " + name);

        int brute = solver.diameterOfBinaryTreeBrute(root);
        int your  = solver.diameterOfBinaryTreeTryYourSelf(root);
        int opt   = solver.diameterOfBinaryTree(root);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-4d%n", brute);
        System.out.printf("TryYourSelf      : %-4d%n", your);
        System.out.printf("Optimized (O(n)) : %-4d%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Manual Test Dashboard
    // ===========================================================
    public static void main(String[] args) {
        DiameterOfBinaryTreeLeetCode543 solver = new DiameterOfBinaryTreeLeetCode543();

        System.out.println("=================================================");
        System.out.println("🌳  Diameter of Binary Tree — Tests");
        System.out.println("=================================================\n");

        // Example 1: [1,2,3,4,5]
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );

        // Example 2: [1,2]
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);

        runTest(solver, root1, 3, "Test 1");
        runTest(solver, root2, 1, "Test 2");
    }
}