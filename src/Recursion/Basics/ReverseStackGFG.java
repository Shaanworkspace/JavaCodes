package Recursion.Basics;
import java.util.*;

public class ReverseStackGFG {

    // ===========================================================
    // Brute‑Force Approach (using auxiliary list O(n) -> S.C.)
    // ===========================================================
    public Stack<Integer> reverseStackBrute(Stack<Integer> st) {
        if(st.isEmpty()){
            return st;
        }

        int top = st.pop();

        reverseStackBrute(st);


        Stack<Integer> temp = new Stack<>();

        while(!st.empty()){
            temp.push(st.pop());
        }

        st.push(top);

        while(!temp.empty()){
            st.push(temp.pop());
        }
        return st;
    }


    // ===========================================================
    // Optimized Recursive Approach (Need to avoid the extra space of "TempStack" we are using in brute force)
    // ===========================================================
    public Stack<Integer> reverseStack(Stack<Integer> st) {
        /*
        To avoid O(n) -> O(1)  Space complexity we need to think like:
        -> As we were taking extra space when we were inserting the element at bottom, so we can do it with a function call by passing the same stack and number to insert

         YOUTUBE: https://www.youtube.com/watch?v=aDQeF8Izv5I&list=PLpIkg8OmuX-IBcXsfITH5ql0Lqci1MYPM&index=6
         */

        if (st.isEmpty()) return st;

        int top = st.pop();
        reverseStack(st);

        insertAtBottom(st, top);   // helper handles insertion at bottom
        return st;
    }

    private void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }
        int temp = st.pop();
        insertAtBottom(st, val);
        st.push(temp);
    }



    // ===========================================================
    // TryYourSelf Variant (with debug steps)
    // ===========================================================
    public Stack<Integer> reverseStackTryYourSelf(Stack<Integer> st) {

        return st;
    }

    private static void runTest(ReverseStackGFG solver,
                                List<Integer> inputList,
                                List<Integer> expectedList,
                                String testName) {
        System.out.println("🔹 " + testName);

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        st1.addAll(inputList);
        st2.addAll(inputList);
        st3.addAll(inputList);

        List<Integer> expected = new ArrayList<>(expectedList);

        Stack<Integer> brute = solver.reverseStackBrute(st1);
        Stack<Integer> your  = solver.reverseStackTryYourSelf(st2);
        Stack<Integer> opt   = solver.reverseStack(st3);

        System.out.println("Input     : " + inputList);
        System.out.println("Expected  : " + expected);
        System.out.printf("Brute Force      : %-15s %s%n",
                brute, brute.equals(expected) ? "✅" : "❌");
        System.out.printf("TryYourSelf      : %-15s %s%n",
                your,  your.equals(expected) ? "✅" : "❌");
        System.out.printf("Optimized (O(n²)) : %-15s %s%n",
                opt,   opt.equals(expected) ? "✅" : "❌");
        System.out.println("--------------------------------------------\n");
    }

    public static void main(String[] args) {
        ReverseStackGFG solver = new ReverseStackGFG();

        System.out.println("=================================================");
        System.out.println("GFG — Reverse a Stack (Recursive) — Tests");
        System.out.println("=================================================\n");

        runTest(solver,
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(4, 3, 2, 1),
                "Test 1");

        runTest(solver,
                Arrays.asList(3, 2, 1),
                Arrays.asList(1, 2, 3),
                "Test 2");

        runTest(solver,
                Arrays.asList(10, 20, 30, 40, 50),
                Arrays.asList(50, 40, 30, 20, 10),
                "Test 3");
    }
}