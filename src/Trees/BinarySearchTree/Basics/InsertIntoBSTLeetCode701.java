package Trees.BinarySearchTree.Basics;


import java.util.*;

/**
 * ===========================================================
 * 🌱 LeetCode 701 — Insert into a Binary Search Tree
 * https://youtu.be/nwySujCaeH0?t=2520
 * ===========================================================
 *
 * You are given the root of a Binary Search Tree (Trees.BST) and a
 * value to insert into the tree. Return the root node after
 * insertion. The new value is guaranteed not to exist initially.
 *
 * Note: There may be multiple valid trees; returning any valid
 * Trees.BST after insertion is acceptable.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 *
 * Example 2:
 * Input : root = [40,20,60,10,30,50,70], val = 25
 * Output: [40,20,60,10,30,50,70,null,null,25]
 *
 * Example 3:
 * Input : root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * Output: [4,2,7,1,3,5]
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 0 ≤ #nodes ≤ 10⁴
 *  • −10⁸ ≤ Node.val, val ≤ 10⁸
 *  • All Node.val are unique.
 * -----------------------------------------------------------
 */

public class InsertIntoBSTLeetCode701 {

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
    // 🐢 Brute‑Force Approach (recursive insertion)
    // ===========================================================
    public TreeNode insertIntoBSTBrute(TreeNode root, int val) {
        if(root==null) {
            return new TreeNode(val);
        }
        else if(root.val<val){
            root.right = insertIntoBSTBrute(root.right,val);
        }
        else if(root.val>val){
            root.left=insertIntoBSTBrute(root.left,val);
        }
        return root;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (iterative / traced)
    // ===========================================================
    public TreeNode insertIntoBSTTryYourSelf(TreeNode root, int val) {
        // TODO: write your own iterative variant with debug prints
        return null; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized Trees.BST Insertion (concise recursive) — O(h)
    // ===========================================================
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // TODO: implement optimized recursion
        return null; // placeholder
    }

    // ===========================================================
    // 🧾 Helper — level‑order print for tree
    // ===========================================================
    private static void printTree(TreeNode root) {
        if (root == null) { System.out.println("[]"); return; }
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
    private static void runTest(InsertIntoBSTLeetCode701 solver,
                                TreeNode root, int val, String name) {
        System.out.println("🔹 " + name + " (insert " + val + ")");
        System.out.print("Original : "); printTree(root);

        TreeNode brute = solver.insertIntoBSTBrute(copy(root), val);
        TreeNode your  = solver.insertIntoBSTTryYourSelf(copy(root), val);
        TreeNode opt   = solver.insertIntoBST(copy(root), val);

        System.out.print("Brute Force      : "); printTree(brute);
        System.out.print("TryYourSelf      : "); printTree(your);
        System.out.print("Optimized (O(h)) : "); printTree(opt);
        System.out.println("--------------------------------------------\n");
    }

    // deep‑copy helper so each version runs independently
    private static TreeNode copy(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = copy(root.left);
        node.right = copy(root.right);
        return node;
    }

    // ===========================================================
    // 🚀 PSVM — Dashboard
    // ===========================================================
    public static void main(String[] args) {
        InsertIntoBSTLeetCode701 solver = new InsertIntoBSTLeetCode701();

        System.out.println("=================================================");
        System.out.println("🌱  Insert into a Binary Search Tree — Tests");
        System.out.println("=================================================\n");

        // Example 1
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7)
        );

        // Example 2
        TreeNode root2 = new TreeNode(40,
                new TreeNode(20, new TreeNode(10), new TreeNode(30)),
                new TreeNode(60, new TreeNode(50), new TreeNode(70))
        );

        // Example 3
        TreeNode root3 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                null
        );

        runTest(solver, root1, 5,  "Test 1");
        runTest(solver, root2, 25, "Test 2");
        runTest(solver, root3, 5,  "Test 3");
    }
}