package Trees.BinaryTree.Basics.Traversal.DFS;
import java.util.*;

public class CountNodesEqualToAverageOfSubtreeLeetCode2265 {

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

	int ansBrute=0;
	public int averageOfSubtreeBrute(TreeNode root) {
		ansBrute=0;
		dfs(root);
		return ansBrute;
	}

	private int[] dfs(TreeNode root) {
		if(root==null) return new int[] {0,0};
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		int sum = left[0]+right[0]+root.val;
		int count = left[1]+right[1]+1;
		if(((int)sum/count)==root.val){
			ansBrute++;
		}
		return new int[] {sum,count};
	}

	public int averageOfSubtreeTryYourSelf(TreeNode root) {
		return 0;
	}

	public int averageOfSubtree(TreeNode root) {
		return 0;
	}

	private static void runTest(CountNodesEqualToAverageOfSubtreeLeetCode2265 solver,
	                            TreeNode root, int expected, String name) {
		System.out.println(name);

		int brute = solver.averageOfSubtreeBrute(root);
		int your  = solver.averageOfSubtreeTryYourSelf(root);
		int opt   = solver.averageOfSubtree(root);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CountNodesEqualToAverageOfSubtreeLeetCode2265 solver = new CountNodesEqualToAverageOfSubtreeLeetCode2265();

		TreeNode root1 = new TreeNode(4,
				new TreeNode(8, new TreeNode(0), new TreeNode(1)),
				new TreeNode(5, null, new TreeNode(6))
		);

		TreeNode root2 = new TreeNode(1);

		TreeNode root3 = new TreeNode(5,
				new TreeNode(5),
				new TreeNode(5)
		);

		TreeNode root4 = new TreeNode(10,
				new TreeNode(5, new TreeNode(2), new TreeNode(8)),
				new TreeNode(15, new TreeNode(12), new TreeNode(18))
		);

		TreeNode root5 = new TreeNode(0,
				new TreeNode(0),
				new TreeNode(0)
		);

		TreeNode root6 = new TreeNode(3,
				new TreeNode(1),
				null
		);

		TreeNode root7 = new TreeNode(6,
				new TreeNode(2, new TreeNode(1), new TreeNode(3)),
				new TreeNode(8, new TreeNode(7), new TreeNode(9))
		);

		runTest(solver, root1, 5, "Test 1");
		runTest(solver, root2, 1, "Test 2 - Single node");
		runTest(solver, root3, 3, "Test 3 - All same values");
		runTest(solver, root4, 5, "Test 4");
		runTest(solver, root5, 3, "Test 5 - All zeros");
		runTest(solver, root6, 2, "Test 6 - Left child only");
		runTest(solver, root7, 5, "Test 7");
	}
}