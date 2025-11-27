package Trees.BinaryTree;


import java.util.*;

public class AllPossibleFullBinaryTreesLeetCode894 {

    // Definition for a binary tree node
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
    }

    // ===========================================================
    // 🐢 Brute‑Force Approach (Pure Recursion)
    // Hint: For n nodes, try all splits (i left, n-1-i right)
    // ===========================================================
    public List<TreeNode> allPossibleFBTBrute(int n) {
        List<TreeNode> result = new ArrayList<>();

        if (n % 2 == 0) return result;

        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        for(int i =1;i<n;i+=2){
            int left =i;
            int right = n-left-1;

            List<TreeNode> leftNodes = allPossibleFBTBrute(left);
            List<TreeNode> rightNodes = allPossibleFBTBrute(right);

            for (TreeNode l : leftNodes) {
                for (TreeNode r : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with debug prints)
    // Hint: Add print statements to trace recursive splits
    // ===========================================================
    public List<TreeNode> allPossibleFBTTryYourSelf(int n) {
        // TODO: Same logic as brute but with debug output
        return new ArrayList<>(); // dummy placeholder
    }

    // ===========================================================
    // ⚡ Optimized (Recursion + Memoization) — O(2^n/n^1.5)
    // Hint: Use HashMap to cache results for each n
    // ===========================================================
    public List<TreeNode> allPossibleFBT(int n) {
        // TODO: Use memoization map to avoid recomputing same subproblems
        return new ArrayList<>(); // dummy placeholder
    }

    // ===========================================================
    // Helper: Compare two trees for structural equality
    // ===========================================================
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // ===========================================================
    // Helper: Check if two lists contain same trees (order-independent)
    // ===========================================================
    private static boolean sameTrees(List<TreeNode> list1, List<TreeNode> list2) {
        if (list1.size() != list2.size()) return false;

        // Create copies to avoid modifying originals
        List<TreeNode> temp1 = new ArrayList<>(list1);
        List<TreeNode> temp2 = new ArrayList<>(list2);

        for (TreeNode tree1 : temp1) {
            boolean found = false;
            for (int i = 0; i < temp2.size(); i++) {
                if (isSameTree(tree1, temp2.get(i))) {
                    temp2.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return temp2.isEmpty();
    }

    // ===========================================================
    // Helper: Simple tree visualization (level-order with nulls)
    // ===========================================================
    private static String treeToString(TreeNode root) {
        if (root == null) return "[]";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Remove trailing nulls
        while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        return result.toString();
    }

    // ===========================================================
    // 🧾 Test Runner — compares all methods and prints ✅ / ❌
    // ===========================================================
    private static void runTest(AllPossibleFullBinaryTreesLeetCode894 solver,
                                int n, int expectedCount, String testName) {
        System.out.println("🔹 " + testName);
        System.out.println("Input (n)     : " + n);
        System.out.println("Expected Count: " + expectedCount);

        List<TreeNode> brute = solver.allPossibleFBTBrute(n);
        List<TreeNode> your  = solver.allPossibleFBTTryYourSelf(n);
        List<TreeNode> opt   = solver.allPossibleFBT(n);

        System.out.printf("Brute (Pure Recursion)   : %d trees %s%n",
                brute.size(), brute.size() == expectedCount ? "✅" : "❌");
        System.out.printf("TryYourSelf (Debug)      : %d trees %s%n",
                your.size(), your.size() == expectedCount ? "✅" : "❌");
        System.out.printf("Optimized (Memoization)  : %d trees %s%n",
                opt.size(), opt.size() == expectedCount ? "✅" : "❌");

        // Optional: verify all three produce same set of trees
        if (brute.size() > 0 && your.size() > 0 && opt.size() > 0) {
            boolean allSame = sameTrees(brute, opt) && sameTrees(your, opt);
            System.out.printf("All methods match        : %s%n", allSame ? "✅" : "❌");
        }

        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // 🚀 PSVM — Starter Dashboard
    // ===========================================================
    public static void main(String[] args) {
        AllPossibleFullBinaryTreesLeetCode894 solver = new AllPossibleFullBinaryTreesLeetCode894();

        System.out.println("=================================================");
        System.out.println("🌳  All Possible Full Binary Trees — Three Versions");
        System.out.println("=================================================\n");

        runTest(solver, 1, 1, "Test 1 (single node)");
        runTest(solver, 3, 1, "Test 2");
        runTest(solver, 5, 2, "Test 3");
        runTest(solver, 7, 5, "Test 4");
        runTest(solver, 9, 14, "Test 5");

        // Note: For n > 11, brute force may be slow without memoization
    }
}