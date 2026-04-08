package Trees.BinarySearchTree;

public class LargestBSTGFG {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static int largestBST(Node root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		if(checkBst(root)) return finder(root);

		if((root.left!=null && root.right!=null) && checkBst(root.left) && checkBst(root.right)) return Math.max(finder(root.left),finder(root.right));
		else if(root.left==null && root.right.data>root.data) return largestBST(root.right);
		else if(root.right==null && root.left.data<root.data) return largestBST(root.left);
		else if(checkBst(root.left)) return finder(root.left);
		else if(checkBst(root.right)) return finder(root.right);
		return 1+ Math.max(largestBST(root.left), largestBST(root.right));
	}

	private static boolean checkBst(Node root) {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean isBST(Node node, long min, long max) {
		if (node == null) return true;

		if (node.data <= min || node.data >= max) return false;

		return isBST(node.left, min, node.data) &&
				isBST(node.right, node.data, max);
	}

	private static int finder(Node node) {
		if(node == null) return 0;
		int sl = finder(node.left);
		int sr = finder(node.right);
		return 1+sl+sr;
	}

	public int largestBSTMethod2(Node root) {
		return 0;
	}

	public int largestBSTMethod3(Node root) {
		return 0;
	}

	private static void runTest(LargestBSTGFG solver,
	                            Node root, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Expected  : " + expected);

		int m1 = solver.largestBST(root);
		int m2 = solver.largestBSTMethod2(root);
		int m3 = solver.largestBSTMethod3(root);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		LargestBSTGFG solver = new LargestBSTGFG();

		System.out.println("=================================================");
		System.out.println("Largest BST in Binary Tree - Tests");
		System.out.println("=================================================\n");

		Node root1 = new Node(5);
		root1.left = new Node(2);
		root1.right = new Node(4);
		root1.left.left = new Node(1);
		root1.left.right = new Node(3);

		runTest(solver, root1, 3, "Test 1");

		Node root2 = new Node(6);
		root2.left = new Node(7);
		root2.right = new Node(3);
		root2.left.right = new Node(2);
		root2.right.left = new Node(2);
		root2.right.right = new Node(4);

		runTest(solver, root2, 3, "Test 2");



		Node root3 = new Node(1);
		root3.left = new Node(4);
		root3.right = new Node(4);
		root3.left.right = new Node(8);
		root3.left.left = new Node(6);
		runTest(solver, root3, 1, "Test 3");


		Node root4 = new Node(7);
		root4.left = new Node(4);
		root4.right = new Node(5);
		root4.left.right = new Node(9);
		runTest(solver, root4, 2, "Test 4");
	}
}