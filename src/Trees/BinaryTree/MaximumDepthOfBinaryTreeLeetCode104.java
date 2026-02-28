package Trees.BinaryTree;

import java.util.*;

public class MaximumDepthOfBinaryTreeLeetCode104 {

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

	public int maxDepthBrute(TreeNode root) {
		if(root==null) return 0;
		if(root.left ==null && root.right==null) return 1;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return 1+Math.max(left,right);
	}

	public int maxDepthTryYourSelf(TreeNode root) {
		return 0;
	}

	public int maxDepth(TreeNode root) {
		return 0;
	}

	private static void runTest(MaximumDepthOfBinaryTreeLeetCode104 solver,
	                            TreeNode root, int expected, String testName) {
		System.out.println(testName);
		System.out.println("Expected  : " + expected);

		int brute = solver.maxDepthBrute(root);
		int your  = solver.maxDepthTryYourSelf(root);
		int opt   = solver.maxDepth(root);

		System.out.printf("Brute Force      : %-10d %s%n",
				brute, brute == expected ? "PASS" : "FAIL");
		System.out.printf("TryYourSelf      : %-10d %s%n",
				your,  your == expected ? "PASS" : "FAIL");
		System.out.printf("Optimized (O(n)) : %-10d %s%n",
				opt,   opt == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTreeLeetCode104 solver = new MaximumDepthOfBinaryTreeLeetCode104();

		System.out.println("=================================================");
		System.out.println("Maximum Depth of Binary Tree - Tests");
		System.out.println("=================================================\n");

		TreeNode root1 = new TreeNode(3,
				new TreeNode(9),
				new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		runTest(solver, root1, 3, "Test 1");

		TreeNode root2 = new TreeNode(1,
				null,
				new TreeNode(2));
		runTest(solver, root2, 2, "Test 2");
	}
}