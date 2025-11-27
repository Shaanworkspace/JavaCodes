package Trees.BinaryTree;

import java.util.*;

/**
 * ===========================================================
 * 🌳 LeetCode 236 — Lowest Common Ancestor of a Binary Tree
 *
 * https://youtu.be/ThQ7dGtBdAE?t=13565
 * ===========================================================
 *
 * Given a binary tree, find the lowest common ancestor (LCA)
 * of two given nodes.
 *
 * Definition (Wikipedia):
 * “The lowest common ancestor is the lowest node that has both
 *  p and q as descendants (allowing a node to be a descendant of itself).”
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 *
 * Example  2:
 * Input : same tree, p = 5, q = 4
 * Output: 5
 *
 * Example  3:
 * Input : root = [1,2], p = 1, q = 2
 * Output: 1
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 2  ≤  #nodes  ≤  10⁵
 *  • −10⁹  ≤  Node.val  ≤  10⁹
 *  • All Node.val are unique
 *  • p  ≠  q and both exist in the tree
 * -----------------------------------------------------------
 */

public class LowestCommonAncestorLeetCode236 {

    // ===========================================================
    // 🧱 TreeNode Definition
    // ===========================================================
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() { return String.valueOf(val); }
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach (path storage & comparison)
    // ===========================================================
    public TreeNode lowestCommonAncestorBrute(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        int i = 0;
        while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i)) {
            i++;
        }
        return pathP.get(i - 1);
    }
    public static void findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return;
        path.add(root);
        if(root==target){
            return;
        }

        if (!path.contains(target)) {
            findPath(root.left, target, path);
        }
        if (!path.contains(target)) {
            findPath(root.right, target, path);
        }

        if (!path.contains(target)) {
            path.remove(path.size() - 1);
        }
    }
    public static boolean findPathByBoolean(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;

        // Step 1: add current node to path
        path.add(root);

        // Step 2: target found
        if (root == target) return true;

        // Step 3: explore children
        if (findPathByBoolean(root.left, target, path) || findPathByBoolean(root.right, target, path)) {
            return true;
        }

        // Step 4: backtrack (target not found here)
        path.remove(path.size() - 1);
        return false;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (for step tracing)
    // ===========================================================
    public TreeNode lowestCommonAncestorTryYourSelf(TreeNode root, TreeNode p, TreeNode q) {
        // TODO: implement recursive variant with debug printing
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Recursive Approach — O(n)
    // ===========================================================
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TODO: implement optimized DFS to return lowest common ancestor
        return null; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compares all implementations
    // ===========================================================
    private static void runTest(LowestCommonAncestorLeetCode236 solver,
                                TreeNode root, TreeNode p, TreeNode q,
                                int expected, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Nodes: p=" + p.val + ", q=" + q.val);

        TreeNode brute = solver.lowestCommonAncestorBrute(root, p, q);
        TreeNode your  = solver.lowestCommonAncestorTryYourSelf(root, p, q);
        TreeNode opt   = solver.lowestCommonAncestor(root, p, q);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-5s%n", brute);
        System.out.printf("TryYourSelf      : %-5s%n", your);
        System.out.printf("Optimized (O(n)) : %-5s%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        LowestCommonAncestorLeetCode236 solver = new LowestCommonAncestorLeetCode236();

        System.out.println("=================================================");
        System.out.println("🌳  Lowest Common Ancestor of a Binary Tree — Tests");
        System.out.println("=================================================\n");

        // Tree for test samples
        TreeNode root = new TreeNode(3);
        root.left  = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left  = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left  = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left  = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p1 = root.left;               // node 5
        TreeNode q1 = root.right;              // node 1
        TreeNode p2 = root.left;               // node 5
        TreeNode q2 = root.left.right.right;   // node 4
        TreeNode singleRoot = new TreeNode(1, new TreeNode(2), null);

        runTest(solver, root, p1, q1, 3, "Test  1");
        runTest(solver, root, p2, q2, 5, "Test  2");
        runTest(solver, singleRoot, singleRoot, singleRoot.left, 1, "Test  3");
    }
}