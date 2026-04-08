package Stacks;
import java.util.*;

public class InsertAtBottomOfStackGFG {

	public Stack<Integer> insertAtBottomMethod1(Stack<Integer> st, int x) {
		insert(st,x);
		return st;
	}

	private void insert(Stack<Integer> st, int val) {
		if(st.isEmpty()) {
			st.push(val);
			return;
		}
		int curr = st.pop();
		insert(st,val);
		st.push(curr);
	}

	public Stack<Integer> insertAtBottomMethod2(Stack<Integer> st, int x) {
		return st;
	}

	public Stack<Integer> insertAtBottomMethod3(Stack<Integer> st, int x) {
		return st;
	}

	private static void runTest(InsertAtBottomOfStackGFG solver,
	                            Stack<Integer> st, int x, List<Integer> expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : stack = " + st + ", x = " + x);
		System.out.println("Expected  : " + expected);

		Stack<Integer> m1 = (Stack<Integer>) st.clone();
		Stack<Integer> m2 = (Stack<Integer>) st.clone();
		Stack<Integer> m3 = (Stack<Integer>) st.clone();

		m1 = solver.insertAtBottomMethod1(m1, x);
		m2 = solver.insertAtBottomMethod2(m2, x);
		m3 = solver.insertAtBottomMethod3(m3, x);

		System.out.printf("Method 1         : %-15s %s%n",
				m1, m1.toString().equals(expected.toString()) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-15s %s%n",
				m2, m2.toString().equals(expected.toString()) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-15s %s%n",
				m3, m3.toString().equals(expected.toString()) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		InsertAtBottomOfStackGFG solver = new InsertAtBottomOfStackGFG();

		System.out.println("=================================================");
		System.out.println("Insert Element at Bottom of Stack - Tests");
		System.out.println("=================================================\n");

		Stack<Integer> st1 = new Stack<>();
		Collections.addAll(st1, 4, 3, 2, 1, 8);

		runTest(solver,
				st1,
				2,
				Arrays.asList(2,4,3,2,1,8),
				"Test 1");

		Stack<Integer> st2 = new Stack<>();
		Collections.addAll(st2, 5, 3, 1);

		runTest(solver,
				st2,
				4,
				Arrays.asList(4,5,3,1),
				"Test 2");
	}
}