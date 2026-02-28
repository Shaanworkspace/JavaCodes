package Stacks.Expression;

import java.util.*;

public class InfixExpressionEvaluationGFG {

	// Method 1: Brute / conceptual approach (try yourself)
	public int evaluateInfixMethod1(String[] arr) {
		int n = arr.length;
		Stack<Integer> characters = new Stack<>();
		Stack<String> operators = new Stack<>();

		for(String a : arr){
			if(Character.isDigit(a.charAt(0))) characters.push(Integer.valueOf(a));
			else{
				while (!operators.isEmpty() &&
						(priority(a) < priority(operators.peek()) ||
								(priority(a) == priority(operators.peek()) && !a.equals("^")))) {

					int v2 = characters.pop();
					int v1 = characters.pop();
					String op = operators.pop();
					characters.push(calculate(v1, v2, op));
				}
				operators.push(a);
			}
		}

		while (!operators.isEmpty()) {
			int val2 = characters.pop();
			int val1 = characters.pop();
			String op = operators.pop();
			characters.push(calculate(val1, val2, op));
		}

		return characters.pop();
	}

	private int calculate(int a, int b, String op) {
		if (op.equals("+")) return a + b;
		if (op.equals("-")) return a - b;
		if (op.equals("*")) return a * b;

		// Floor Division
		if (op.equals("/")) {
			if (a * b < 0 && a % b != 0)
				return a / b - 1;
			return a / b;
		}

		if (op.equals("^")) return (int) Math.pow(a, b);
		return 0;
	}


	private int priority(String op) {
		if (op.equals("+") || op.equals("-")) return 1;
		if (op.equals("*") || op.equals("/")) return 2;
		if (op.equals("^")) return 3;
		return 0;
	}

	// Method 2: Using stacks (operators + operands) (try yourself)
	public int evaluateInfixMethod2(String[] arr) {
		return 0;
	}

	// Method 3: Optimized / final approach with precedence & associativity (try yourself)
	public int evaluateInfixMethod3(String[] arr) {
		return 0;
	}

	private static void runTest(InfixExpressionEvaluationGFG solver,
	                            String[] arr, int expected, String testName) {

		System.out.println(testName);
		System.out.println("Expression : " + Arrays.toString(arr));
		System.out.println("Expected   : " + expected);

		int r1 = solver.evaluateInfixMethod1(arr);
		int r2 = solver.evaluateInfixMethod2(arr);
		int r3 = solver.evaluateInfixMethod3(arr);

		System.out.printf("Method 1        : %-5d %s%n",
				r1, r1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-5d %s%n",
				r2, r2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-5d %s%n",
				r3, r3 == expected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		InfixExpressionEvaluationGFG solver =
				new InfixExpressionEvaluationGFG();

		System.out.println("=================================================");
		System.out.println("Expression Evaluation (Infix) - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new String[]{"100", "+", "200", "/", "2", "*", "5", "+", "7"},
				607,
				"Test 1");

		runTest(solver,
				new String[]{"2", "^", "3", "^", "2"},
				512,
				"Test 2");
	}
}