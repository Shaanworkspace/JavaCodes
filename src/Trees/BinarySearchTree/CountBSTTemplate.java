package Trees.BinarySearchTree;

import java.util.*;

public class CountBSTTemplate {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	// You implement this
	public int countBST(Node root) {
		return 0;
	}

	private static void runTest(CountBSTTemplate solver,
	                            Node root, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Expected  : " + expected);

		int result = solver.countBST(root);

		System.out.printf("Result    : %-10d %s%n",
				result, result == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		CountBSTTemplate solver = new CountBSTTemplate();

		System.out.println("=================================================");
		System.out.println("Count BST Subtrees - Tests");
		System.out.println("=================================================\n");

		// 🔥 Test 1: Mixed valid + invalid
		Node root1 = new Node(10);
		root1.left = new Node(5);
		root1.right = new Node(15);
		root1.left.left = new Node(1);
		root1.left.right = new Node(8);
		root1.right.left = new Node(7);   // breaks BST
		root1.right.right = new Node(20);

		runTest(solver, root1, 3, "Test 1");

		// 🔥 Test 2: All nodes valid BST
		Node root2 = new Node(8);
		root2.left = new Node(4);
		root2.right = new Node(12);
		root2.left.left = new Node(2);
		root2.left.right = new Node(6);
		root2.right.left = new Node(10);
		root2.right.right = new Node(14);

		runTest(solver, root2, 7, "Test 2");

		// 🔥 Test 3: Duplicates present (break BST rule)
		Node root3 = new Node(5);
		root3.left = new Node(3);
		root3.right = new Node(5); // duplicate → invalid
		root3.left.left = new Node(2);
		root3.left.right = new Node(4);

		runTest(solver, root3, 3, "Test 3");

		// Test 4: Deep violation inside subtree
		Node root4 = new Node(25);
		root4.left = new Node(18);
		root4.right = new Node(50);
		root4.left.left = new Node(19);  // violates BST
		root4.left.right = new Node(20);
		root4.right.left = new Node(35);
		root4.right.right = new Node(60);

		runTest(solver, root4, 3, "Test 4");
	}
}