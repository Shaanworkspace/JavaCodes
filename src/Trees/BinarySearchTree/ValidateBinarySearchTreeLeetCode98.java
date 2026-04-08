package Trees.BinarySearchTree;

import java.util.*;

public class ValidateBinarySearchTreeLeetCode98 {

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isValidBSTMethod1(TreeNode root) {
		return helper(root,null,null);
	}

	private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
		if(root==null) return true;
		if(min!=null && root.val<=min.val) return false;
		if(max!=null && root.val>=max.val) return false;
		return helper(root.left,min,root) && helper(root.right,root,max);
	}


	public boolean isValidBSTMethod2(TreeNode root) {
		return false;
	}

	public boolean isValidBSTMethod3(TreeNode root) {
		return false;
	}

	private static void runTest(ValidateBinarySearchTreeLeetCode98 solver,
	                            TreeNode root, boolean expected, String testName) {

		System.out.println(testName);
		System.out.println("Expected  : " + expected);

		boolean m1 = solver.isValidBSTMethod1(root);
		boolean m2 = solver.isValidBSTMethod2(root);
		boolean m3 = solver.isValidBSTMethod3(root);

		System.out.printf("Method 1         : %-5b %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-5b %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-5b %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		ValidateBinarySearchTreeLeetCode98 solver =
				new ValidateBinarySearchTreeLeetCode98();

		System.out.println("=================================================");
		System.out.println("Validate Binary Search Tree - Tests");
		System.out.println("=================================================\n");

		TreeNode root1 = new TreeNode(2,
				new TreeNode(1),
				new TreeNode(3));

		TreeNode root2 = new TreeNode(5,
				new TreeNode(1),
				new TreeNode(4, new TreeNode(3), new TreeNode(6)));

		runTest(solver, root1, true, "Test 1");
		runTest(solver, root2, false, "Test 2");
	}
}