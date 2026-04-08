package LinkedList;

import java.util.*;

public class ReverseLinkedListGFG {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}


	// Three Pointers
	public Node reverseListMethod1(Node head) {
		if (head == null || head.next == null) return head;
		Node prev = null;
		Node curr = head;

		while (curr!=null) {
			Node nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		return prev;
	}

	public Node reverseListMethod2(Node head) {
		Stack<Integer> st = new Stack<>();
		Node temp = head;
		while (temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			temp.data = st.pop();
			temp = temp.next;
		}
		return head;
	}

	public Node reverseListMethod3(Node head) {
		if(head==null || head.next==null) return head;
		Node newHead = reverseListMethod3(head.next);
		Node next = head.next;
		next.next = head;
		head.next = null;
		return newHead;
	}

	private static Node buildList(int[] arr) {
		if (arr.length == 0) return null;

		Node head = new Node(arr[0]);
		Node curr = head;

		for (int i = 1; i < arr.length; i++) {
			curr.next = new Node(arr[i]);
			curr = curr.next;
		}
		return head;
	}

	private static String listToString(Node head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.data);
			if (head.next != null) sb.append(" -> ");
			head = head.next;
		}
		return sb.toString();
	}

	private static void runTest(ReverseLinkedListGFG solver,
	                            int[] input, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(input));
		System.out.println("Expected  : " + expected);

		Node head1 = buildList(input);
		Node head2 = buildList(input);
		Node head3 = buildList(input);

		Node m1 = solver.reverseListMethod1(head1);
		Node m2 = solver.reverseListMethod2(head2);
		Node m3 = solver.reverseListMethod3(head3);

		String r1 = listToString(m1);
		String r2 = listToString(m2);
		String r3 = listToString(m3);

		System.out.printf("Method 1         : %-20s %s%n",
				r1, r1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-20s %s%n",
				r2, r2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-20s %s%n",
				r3, r3.equals(expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		ReverseLinkedListGFG solver = new ReverseLinkedListGFG();

		System.out.println("=================================================");
		System.out.println("Reverse Linked List - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 2, 3, 4},
				"4 -> 3 -> 2 -> 1",
				"Test 1");

		runTest(solver,
				new int[]{2, 7, 10, 9, 8},
				"8 -> 9 -> 10 -> 7 -> 2",
				"Test 2");

		runTest(solver,
				new int[]{8},
				"8",
				"Test 3");
	}
}