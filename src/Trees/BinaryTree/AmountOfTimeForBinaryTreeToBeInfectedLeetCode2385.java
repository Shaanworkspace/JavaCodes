package Trees.BinaryTree;

import java.util.*;

/**
 * ===========================================================
 * LeetCode 2385 — Amount of Time for Binary Tree to Be Infected
 * ===========================================================
 *
 * You are given the root of a binary tree with unique values,
 * and an integer `start`. At minute  0, infection starts
 * from the node having value  =start=.
 *
 * Each minute, a node becomes infected if:
 *   • It is uninfected, and
 *   • It is adjacent to an infected node.
 *
 * Return the total minutes required for the entire tree
 * to become infected.
 *
 * -----------------------------------------------------------
 * Example  1:
 * Input : root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 *
 * Example  2:
 * Input : root = [1], start = 1
 * Output: 0
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1  ≤  #nodes  ≤  10⁵
 *  • 1  ≤  Node.val  ≤  10⁵
 *  • All Node.val are unique
 *  • start exists in the tree
 * -----------------------------------------------------------
 */

public class AmountOfTimeForBinaryTreeToBeInfectedLeetCode2385 {

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
    // 🐢 Brute‑Force Approach (rebuild as undirected graph)
    // ===========================================================
    public int amountOfTimeBrute(TreeNode root, int start) {
        //first get the node of the value provided as to know from where to start
        TreeNode node = getNode(root,start);

        //Make a hashmap of parent child combination
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        preorderMapper(root,parent);


        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        HashMap<TreeNode,Integer> isVisited = new HashMap<>();
        isVisited.put(node,0);

        while(!queue.isEmpty()){
            TreeNode temp = queue.peek();
            int level = isVisited.get(temp);
            if(temp.left!=null && (!isVisited.containsKey(temp.left))){
                queue.add(temp.left);
                isVisited.put(temp.left,level+1);
            }

            if(temp.right!=null && (!isVisited.containsKey(temp.right))){
                queue.add(temp.right);
                isVisited.put(temp.right,level+1);
            }
            if((parent.containsKey(temp))  &&(!isVisited.containsKey(parent.get(temp)))){
                queue.add(parent.get(temp));
                isVisited.put(parent.get(temp),level+1);
            }
            queue.remove();
        }
        int max=0;
        for(int level:isVisited.values()){
            max = Math.max(max, level);
        }

        return max;
    }

    private void preorderMapper(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        if(root==null){
            return;
        }
        if(root.left !=null){
            parent.put(root.left,root);
        }
        if(root.right !=null){
            parent.put(root.right,root);
        }
        preorderMapper(root.left,parent);
        preorderMapper(root.right,parent);
    }

    private TreeNode getNode(TreeNode root, int start) {
        if(root==null) return null;
        if(root.val==start) return root;
        TreeNode left = getNode(root.left,start);
        if(left!=null) return left;
        return getNode(root.right,start);
    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (with step tracing)
    // ===========================================================
    public int amountOfTimeTryYourSelf(TreeNode root, int start) {
        // TODO: implement traced BFS for understanding
        return 0; // placeholder
    }

    // ===========================================================
    // ⚡ Optimized BFS / DFS Approach — O(n)
    // ===========================================================
    public int amountOfTime(TreeNode root, int start) {
        // TODO: implement efficient recursive backtracking or BFS method
        return 0; // placeholder
    }

    // ===========================================================
    // Helper — build adjacency map
    // ===========================================================
    private static void buildAdjacency(TreeNode node,
                                       Map<Integer, List<Integer>> graph) {
        if (node == null) return;
        graph.putIfAbsent(node.val, new ArrayList<>());
        if (node.left != null) {
            graph.get(node.val).add(node.left.val);
            graph.putIfAbsent(node.left.val, new ArrayList<>());
            graph.get(node.left.val).add(node.val);
            buildAdjacency(node.left, graph);
        }
        if (node.right != null) {
            graph.get(node.val).add(node.right.val);
            graph.putIfAbsent(node.right.val, new ArrayList<>());
            graph.get(node.right.val).add(node.val);
            buildAdjacency(node.right, graph);
        }
    }

    // ===========================================================
    // Test Runner — Runs all implementations
    // ===========================================================
    private static void runTest(AmountOfTimeForBinaryTreeToBeInfectedLeetCode2385 solver,
                                TreeNode root, int start, int expected, String name) {
        System.out.println("🔹 " + name + "  |  start = " + start);

        int brute = solver.amountOfTimeBrute(root, start);
        int your  = solver.amountOfTimeTryYourSelf(root, start);
        int opt   = solver.amountOfTime(root, start);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-5d%n", brute);
        System.out.printf("TryYourSelf      : %-5d%n", your);
        System.out.printf("Optimized (O(n)) : %-5d%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // PSVM — Testing Dashboard
    // ===========================================================
    public static void main(String[] args) {
        AmountOfTimeForBinaryTreeToBeInfectedLeetCode2385 solver =
                new AmountOfTimeForBinaryTreeToBeInfectedLeetCode2385();

        System.out.println("=================================================");
        System.out.println("Amount of Time for Binary Tree to Be Infected — Tests");
        System.out.println("=================================================\n");

        // Example  1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))),
                new TreeNode(3, new TreeNode(10), new TreeNode(6))
        );

        // Example  2
        TreeNode root2 = new TreeNode(1);

        runTest(solver, root1, 3, 4, "Test  1");
        runTest(solver, root2, 1, 0, "Test  2");
    }
}