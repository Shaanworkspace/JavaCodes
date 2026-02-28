package Trees.BinarySearchTree.Deletion;

import java.util.*;

public class DeleteNodeInBSTLeetCode450 {

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

	public TreeNode deleteNodeBrute(TreeNode root, int key) {
		if(root == null) return null;

		// we have to delete left root
		if(key<root.val){
			root.left = deleteNodeBrute(root.left,key);
		}
		//delete right root
		else if (key>root.val){
			root.right = deleteNodeBrute(root.right,key);
		}
		//delete root
		else{
			//root with no value
			if(root.left==null){
				return root.right;
			}
			if(root.right==null){
				return root.left;
			}

			//both as avaliable
			int a = findMinValue(root.right);
			root.val = a;
			root.right = deleteNodeBrute(root.right,a);
		}
		return root;
	}

	private int findMinValue(TreeNode right) {
		TreeNode temp=right;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp.val;
	}

	public TreeNode deleteNodeTryYourSelf(TreeNode root, int key) {
		return null;
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		return null;
	}

	private static TreeNode copyTree(TreeNode root) {
		if (root == null) return null;
		TreeNode node = new TreeNode(root.val);
		node.left = copyTree(root.left);
		node.right = copyTree(root.right);
		return node;
	}

	private static void printTree(TreeNode root) {
		if (root == null) {
			System.out.println("[]");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<String> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				result.add("null");
			} else {
				result.add(String.valueOf(node.val));
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
			result.remove(result.size() - 1);
		}
		System.out.println(result);
	}

	private static void runTest(DeleteNodeInBSTLeetCode450 solver,
	                            TreeNode root, int key, String name) {
		System.out.println(name);
		System.out.println("Key to delete: " + key);
		System.out.print("Original Tree: ");
		printTree(root);

		TreeNode brute = solver.deleteNodeBrute(copyTree(root), key);
		TreeNode your  = solver.deleteNodeTryYourSelf(copyTree(root), key);
		TreeNode opt   = solver.deleteNode(copyTree(root), key);

		System.out.print("Brute Force      : ");
		printTree(brute);
		System.out.print("TryYourSelf      : ");
		printTree(your);
		System.out.print("Optimized        : ");
		printTree(opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		DeleteNodeInBSTLeetCode450 solver = new DeleteNodeInBSTLeetCode450();

		TreeNode root1 = new TreeNode(5,
				new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7))
		);

		TreeNode root2 = new TreeNode(5,
				new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7))
		);

		TreeNode root3 = null;

		TreeNode root4 = new TreeNode(5,
				new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7))
		);

		TreeNode root5 = new TreeNode(5,
				new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7))
		);

		TreeNode root6 = new TreeNode(5);

		TreeNode root7 = new TreeNode(5,
				new TreeNode(3),
				null
		);

		runTest(solver, root1, 3, "Test 1 - Delete node with two children");
		runTest(solver, root2, 0, "Test 2 - Delete non-existent node");
		runTest(solver, root3, 0, "Test 3 - Empty tree");
		runTest(solver, root4, 5, "Test 4 - Delete root node");
		runTest(solver, root5, 7, "Test 5 - Delete leaf node");
		runTest(solver, root6, 5, "Test 6 - Single node tree");
		runTest(solver, root7, 3, "Test 7 - Delete node with no children");
	}
}