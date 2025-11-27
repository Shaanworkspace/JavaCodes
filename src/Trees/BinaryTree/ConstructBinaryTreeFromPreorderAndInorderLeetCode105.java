package Trees.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * ===========================================================
 * 🌳 LeetCode 105 — Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://youtu.be/ThQ7dGtBdAE?t=17162
 * ===========================================================
 *
 * Given two integer arrays preorder and inorder —
 * where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree —
 * construct and return the binary tree.
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : preorder = [3,9,20,15,7]
 *         inorder  = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example  2:
 * Input : preorder = [-1]
 *         inorder  = [-1]
 * Output: [-1]
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1 ≤ preorder.length ≤ 3000
 *  • inorder.length == preorder.length
 *  • −3000  ≤  preorder[i],  inorder[i]  ≤  3000
 *  • preorder & inorder contain unique values.
 *  • Both traversals are valid and consistent.
 * -----------------------------------------------------------
 */

public class ConstructBinaryTreeFromPreorderAndInorderLeetCode105 {

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
    // 🐢 Brute‑Force Approach (recursive slicing arrays)
    // ===========================================================
    public TreeNode buildTreeBrute(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return treemaker(preorder,0,n-1,inorder,0,n-1);
    }

    private TreeNode treemaker(int[] preorder, int prelow, int preHigh, int[] inorder, int inLow, int inHigh) {
        if(prelow>preHigh) return null;

        TreeNode node = new TreeNode(preorder[prelow]);

        int i = inLow;
        while(inorder[i]!=preorder[prelow]){
            i++;
        }
        int leftSize = i-inLow;
        node.left=treemaker(preorder,prelow+1,prelow+leftSize,inorder,inLow,i-1);
        node.right=treemaker(preorder,prelow+leftSize+1,preHigh,inorder,i+1,inHigh);
        return node;

    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug statements)
    // ===========================================================
    public TreeNode buildTreeTryYourSelf(int[] preorder, int[] inorder) {
        // TODO: implement recursive construction with printed trace
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized HashMap‑based O(n) Construction
    // ===========================================================
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TODO: implement efficient pointer & hashmap solution
        return null; // placeholder
    }

    // ===========================================================
    // 🧾 Helper — print tree in level order
    // ===========================================================
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                result.add("null");
                continue;
            }
            result.add(String.valueOf(node.val));
            if (node.left != null || node.right != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.println(result);
    }

    // ===========================================================
    // 🧾 Test Runner — executes all variants
    // ===========================================================
    private static void runTest(ConstructBinaryTreeFromPreorderAndInorderLeetCode105 solver,
                                int[] preorder, int[] inorder, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Preorder : " + Arrays.toString(preorder));
        System.out.println("Inorder  : " + Arrays.toString(inorder));

        TreeNode brute = solver.buildTreeBrute(preorder, inorder);
        TreeNode your  = solver.buildTreeTryYourSelf(preorder, inorder);
        TreeNode opt   = solver.buildTree(preorder, inorder);

        System.out.print("Brute Force      : "); printTree(brute);
        System.out.print("TryYourSelf      : "); printTree(your);
        System.out.print("Optimized (O(n)) : "); printTree(opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Demo Dashboard
    // ===========================================================
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderLeetCode105 solver =
                new ConstructBinaryTreeFromPreorderAndInorderLeetCode105();

        System.out.println("=================================================");
        System.out.println("🌳  Construct Binary Tree from Preorder and Inorder — Tests");
        System.out.println("=================================================\n");

        // Example  1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1  = {9, 3, 15, 20, 7};

        // Example  2
        int[] preorder2 = {-1};
        int[] inorder2  = {-1};

        runTest(solver, preorder1, inorder1, "Test  1");
        runTest(solver, preorder2, inorder2, "Test  2");
    }
}