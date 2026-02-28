package Trees.BinaryTree.Basics.Traversal.DFS;
import Recursion.MazePath.DeadMaze.RatInADeadMazeFourDirection;

import java.util.*;

public class BinaryTreeTiltLeetCode563 {

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


	int sum=0;
	public int findTiltBrute(TreeNode root) {
		sum=0;
		dfs(root);
		return sum;
	}

	private int dfs(TreeNode root) {
		if(root==null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		sum=sum+Math.abs(left-right);
		return left + right + root.val;
	}




	int a =0;
	public int findTiltTryYourSelf(TreeNode root) {
		a=0;
		preorder(root);
		return a;
	}

	private void preorder(TreeNode root) {
		if(root==null) return;
		a+=tilt(root);
		preorder(root.left);
		preorder(root.right);
	}

	private int tilt(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null){
			return 0;
		}
		int left = getSum(root.left);
		int right = getSum(root.right);
		return Math.abs(left-right);
	}
	private int getSum(TreeNode root){
		if(root==null) return 0;
		int left=getSum(root.left);
		int right = getSum(root.right);
		return left + right+root.val;
	}






	public int findTilt(TreeNode root) {
		return 0;
	}

	private static void runTest(BinaryTreeTiltLeetCode563 solver,
	                            TreeNode root, int expected, String name) {
		System.out.println(name);

		int brute = solver.findTiltBrute(root);
		int your  = solver.findTiltTryYourSelf(root);
		int opt   = solver.findTilt(root);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		BinaryTreeTiltLeetCode563 solver = new BinaryTreeTiltLeetCode563();

		TreeNode root1 = new TreeNode(1,
				new TreeNode(2),
				new TreeNode(3)
		);

		TreeNode root2 = new TreeNode(4,
				new TreeNode(2, new TreeNode(3), new TreeNode(5)),
				new TreeNode(9, null, new TreeNode(7))
		);

		TreeNode root3 = new TreeNode(21,
				new TreeNode(7,
						new TreeNode(1, new TreeNode(3), new TreeNode(3)),
						new TreeNode(1)
				),
				new TreeNode(14,
						new TreeNode(2),
						new TreeNode(2)
				)
		);

		TreeNode root4 = null;

		TreeNode root5 = new TreeNode(5);

		TreeNode root6 = new TreeNode(1,
				new TreeNode(2, new TreeNode(4), null),
				new TreeNode(3, null, new TreeNode(5))
		);

		TreeNode root7 = new TreeNode(0,
				new TreeNode(0),
				new TreeNode(0)
		);

		runTest(solver, root1, 1, "Test 1");
		runTest(solver, root2, 15, "Test 2");
		runTest(solver, root3, 9, "Test 3");
		runTest(solver, root4, 0, "Test 4 - Empty tree");
		runTest(solver, root5, 0, "Test 5 - Single node");
		runTest(solver, root6, 11, "Test 6");
		runTest(solver, root7, 0, "Test 7 - All zeros");
	}
}