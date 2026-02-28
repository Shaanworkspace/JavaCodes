package Trees.BinaryTree.Basics.Traversal.DFS;
import java.util.*;

public class SumRootToLeafNumbersLeetCode129 {

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

	public int sumNumbersBrute(TreeNode root) {
		List<Integer> arr = new ArrayList<>();
		int sum=0;
		dfsBrute(root,arr,0);
		for(int a : arr){
			sum+=a;
		}
		return sum;
	}

	private void dfsBrute(TreeNode root, List<Integer> arr, int sum) {
		if(root.left==null && root.right==null) {
			sum=(sum*10)+root.val;
			arr.add(sum);
			return;
		}
		sum=(sum*10)+root.val;
		if(root.left!=null) dfsBrute(root.left,arr,sum);
		if(root.right!=null) dfsBrute(root.right,arr,sum);
	}

	public int sumNumbersTryYourSelf(TreeNode root) {
		return 0;
	}

	public int sumNumbers(TreeNode root) {
		return dfs(root,0);
	}

	private int dfs(TreeNode root, int sum) {
		if(root==null) return 0;
		sum=(sum*10)+root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}

		int left = dfs(root.left,sum);
		int right = dfs(root.right,sum);
		return left+right;
	}

	private static void runTest(SumRootToLeafNumbersLeetCode129 solver,
	                            TreeNode root, int expected, String name) {
		System.out.println(name);

		int brute = solver.sumNumbersBrute(root);
		int your  = solver.sumNumbersTryYourSelf(root);
		int opt   = solver.sumNumbers(root);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		SumRootToLeafNumbersLeetCode129 solver = new SumRootToLeafNumbersLeetCode129();

		TreeNode root1 = new TreeNode(1,
				new TreeNode(2),
				new TreeNode(3)
		);

		TreeNode root2 = new TreeNode(4,
				new TreeNode(9, new TreeNode(5), new TreeNode(1)),
				new TreeNode(0)
		);

		TreeNode root3 = new TreeNode(0);

		TreeNode root4 = new TreeNode(1,
				new TreeNode(2, new TreeNode(4), null),
				new TreeNode(3)
		);

		TreeNode root5 = new TreeNode(9,
				new TreeNode(9,
						new TreeNode(9),
						new TreeNode(9)
				),
				new TreeNode(9)
		);

		TreeNode root6 = new TreeNode(1,
				new TreeNode(0),
				null
		);

		TreeNode root7 = new TreeNode(5,
				new TreeNode(3,
						new TreeNode(2),
						new TreeNode(4)
				),
				new TreeNode(7,
						new TreeNode(6),
						new TreeNode(8)
				)
		);

		runTest(solver, root1, 25, "Test 1");
		runTest(solver, root2, 1026, "Test 2");
		runTest(solver, root3, 0, "Test 3 - Single node zero");
		runTest(solver, root4, 137, "Test 4");
		runTest(solver, root5, 2097, "Test 5 - All nines");
		runTest(solver, root6, 10, "Test 6 - Path with zero");
		runTest(solver, root7, 2220, "Test 7 - Full tree");
	}
}