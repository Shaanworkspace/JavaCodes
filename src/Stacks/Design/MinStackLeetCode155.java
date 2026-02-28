package Stacks.Design;

import java.util.*;

public class MinStackLeetCode155 {

	Stack<Integer> main = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	// Try yourself
	public MinStackLeetCode155() {

	}

	// Try yourself
	public void push(int val) {
		main.push(val);
		if(minStack.isEmpty()) minStack.push(val);
		else if (val<minStack.peek()) minStack.push(val);
		else minStack.push(minStack.peek());
	}

	// Try yourself
	public void pop() {
		if(main.isEmpty()) return;
		main.pop();
		minStack.pop();
	}

	// Try yourself
	public int top() {
		return main.peek();
	}

	// Try yourself
	public int getMin() {
		return minStack.peek();
	}

	// Manual test driver (for local practice)
	public static void main(String[] args) {

		System.out.println("=================================================");
		System.out.println("Min Stack - Manual Test");
		System.out.println("=================================================\n");

		MinStackLeetCode155 minStack = new MinStackLeetCode155();

		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);

		System.out.println("getMin()  -> expected -3");
		System.out.println("getMin()  -> " + minStack.getMin());

		minStack.pop();

		System.out.println("top()     -> expected 0");
		System.out.println("top()     -> " + minStack.top());

		System.out.println("getMin()  -> expected -2");
		System.out.println("getMin()  -> " + minStack.getMin());
	}
}