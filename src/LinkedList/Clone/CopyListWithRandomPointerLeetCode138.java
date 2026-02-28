package LinkedList.Clone;

import java.util.*;

public class CopyListWithRandomPointerLeetCode138 {

	// Definition for a Node.
	static class Node {
		int val;
		Node next;
		Node random;

		Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	// Method 1: Try yourself
	public Node copyRandomListMethod1(Node head) {
		return null;
	}

	// Method 2: Try yourself
	public Node copyRandomListMethod2(Node head) {
		return null;
	}

	private static void runTest(CopyListWithRandomPointerLeetCode138 solver,
	                            Node head, String testName) {

		System.out.println(testName);
		System.out.println("Input List  : " + serialize(head));

		Node result1 = solver.copyRandomListMethod1(head);
		Node result2 = solver.copyRandomListMethod2(head);

		System.out.println("Method 1    : " + serialize(result1));
		System.out.println("Method 2    : " + serialize(result2));
		System.out.println("--------------------------------------------\n");
	}

	// Helper method to visualize list (value, randomIndex)
	private static String serialize(Node head) {
		if (head == null) return "[]";

		List<Node> nodes = new ArrayList<>();
		Node curr = head;
		while (curr != null) {
			nodes.add(curr);
			curr = curr.next;
		}

		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			sb.append("[")
					.append(node.val)
					.append(",");

			if (node.random == null) {
				sb.append("null");
			} else {
				sb.append(nodes.indexOf(node.random));
			}
			sb.append("]");
			if (i < nodes.size() - 1) sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		CopyListWithRandomPointerLeetCode138 solver =
				new CopyListWithRandomPointerLeetCode138();

		System.out.println("=================================================");
		System.out.println("Copy List with Random Pointer - Tests");
		System.out.println("=================================================\n");

		// Test 1
		Node a = new Node(7);
		Node b = new Node(13);
		Node c = new Node(11);
		Node d = new Node(10);
		Node e = new Node(1);

		a.next = b; b.next = c; c.next = d; d.next = e;
		b.random = a;
		c.random = e;
		d.random = c;
		e.random = a;

		runTest(solver, a, "Test 1");

		// Test 2
		Node x = new Node(1);
		Node y = new Node(2);

		x.next = y;
		x.random = y;
		y.random = y;

		runTest(solver, x, "Test 2");
	}
}