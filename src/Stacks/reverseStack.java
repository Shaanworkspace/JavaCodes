package Stacks;

import java.util.Stack;

public class reverseStack {

	void main() {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st);
		reverse(st);
		System.out.println(st);
	}

	private void reverse(Stack<Integer> st) {
		if (st.size() == 1) return;
		int top = st.pop();
		reverse(st);
		insertAtBottom(st, top);
	}

	private void insertAtBottom(Stack<Integer> st, int val) {
		if (st.isEmpty()) {
			st.push(val);
			return;
		}
		int top = st.pop();
		insertAtBottom(st, val);
		st.push(top);
	}
}
