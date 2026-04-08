package Trees.BinaryTree.Basics.Traversal;
import java.util.*;

public class InorderTraversalGFG {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public ArrayList<Integer> inOrderMethod1(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		inorder(root, res);
		return res;
	}

	private void inorder(Node node, List<Integer> res) {
		if (node == null) return;

		inorder(node.left, res);
		res.add(node.data);
		inorder(node.right, res);
	}

	public ArrayList<Integer> inOrderMethod2(Node root) {
		return new ArrayList<>();
	}

	public ArrayList<Integer> inOrderMethod3(Node root) {
		return new ArrayList<>();
	}

	private static void runTest(InorderTraversalGFG solver,
	                            Node root, List<Integer> expected, String testName) {

		System.out.println(testName);
		System.out.println("Expected  : " + expected);

		List<Integer> m1 = solver.inOrderMethod1(root);
		List<Integer> m2 = solver.inOrderMethod2(root);
		List<Integer> m3 = solver.inOrderMethod3(root);

		System.out.printf("Method 1         : %-20s %s%n",
				m1, m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-20s %s%n",
				m2, m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-20s %s%n",
				m3, m3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		InorderTraversalGFG solver = new InorderTraversalGFG();

		System.out.println("=================================================");
		System.out.println("Inorder Traversal - Tests");
		System.out.println("=================================================\n");

		// Test 1: [1,2,3,4,5]
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		runTest(solver,
				root1,
				Arrays.asList(4, 2, 5, 1, 3),
				"Test 1");
	}
}