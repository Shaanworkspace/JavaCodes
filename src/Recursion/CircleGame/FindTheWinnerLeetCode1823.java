package Recursion.CircleGame;


import java.util.*;

/**
 * ===========================================================
 * 🌀 LeetCode 1823 — Find the Winner of the Circular Game
 * ===========================================================
 *
 * There are n friends sitting in a circle numbered 1 → n.
 * Starting from friend 1, we count k friends (including the current)
 * clockwise. The k‑th friend is removed from the circle.
 * Repeat from the next friend clockwise until one remains.
 *
 * Return the number of the friend who wins the game.
 *
 * -----------------------------------------------------------
 * Example 1:
 * Input : n = 5, k = 2
 * Output: 3
 *
 * Example 2:
 * Input : n = 6, k = 5
 * Output: 1
 *
 * -----------------------------------------------------------
 * Constraints:
 *  • 1 ≤ k ≤ n ≤ 500
 * -----------------------------------------------------------
 * Follow‑up:
 *  Can you solve it in linear time with O(1) extra space?
 * -----------------------------------------------------------
 */

public class FindTheWinnerLeetCode1823 {

    // ===========================================================
    // 🐢 Brute‑Force Approach (simulate list removals)
    // ===========================================================
    public int findTheWinnerBrute(int n, int k) {
        ArrayList<Integer> friends = new ArrayList<>();
        for(int i =1;i<=n;i++){
            friends.add(i);
        }

        int i=0;
        while(friends.size()>1){
            i = (i + k-1)%friends.size();
            friends.remove(i);
        }
        return friends.getFirst();

    }

    // ===========================================================
    // ✍️ TryYourSelf Variant (recursive trace)
    // ===========================================================
    public int findTheWinnerTryYourSelf(int n, int k) {
        // TODO: implement print tracing of elimination steps
        return 0; // placeholder
    }
    public int findTheWinnerQueue(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i =1;i<=n;i++){
            queue.offer(i);
        }
        while(queue.size()>1){
            int a = k%queue.size();
            int idx = (a==0)?queue.size():a;
            for(int i =0;i<idx-1;i++){
                queue.offer(queue.remove());
            }
            queue.remove();
            System.out.println(queue);
        }
        return queue.peek();
    }

    // ===========================================================
    // ⚡ Optimized Recursive / Josephus Formula — O(n)
    // ===========================================================
    public int findTheWinner(int n, int k) {
        // TODO: implement efficient recursive / iterative formula
        return 0; // placeholder
    }

    // ===========================================================
    // 🧾 Test Runner — compares results from each variant
    // ===========================================================
    private static void runTest(FindTheWinnerLeetCode1823 solver,
                                int n, int k, int expected, String name) {
        System.out.println("=> " + name + "  |  n = " + n + ", k = " + k);

        int brute = solver.findTheWinnerBrute(n, k);
        int your  = solver.findTheWinnerTryYourSelf(n, k);
        int opt   = solver.findTheWinner(n, k);
        int opt2   = solver.findTheWinnerQueue(n, k);

        System.out.println("Expected : " + expected);
        System.out.printf("Brute Force      : %-5d%n", brute);
        System.out.printf("TryYourSelf      : %-5d%n", your);
        System.out.printf("Queue : %-5d%n", opt2);
        System.out.printf("Optimized (O(n)) : %-5d%n", opt);
        System.out.println("--------------------------------------------\n");
    }

    // ===========================================================
    // PSVM — Testing Dashboard
    // ===========================================================
    public static void main(String[] args) {
        FindTheWinnerLeetCode1823 solver = new FindTheWinnerLeetCode1823();

        System.out.println("=================================================");
        System.out.println("🌀  Find the Winner of the Circular Game — Tests");
        System.out.println("=================================================\n");

        runTest(solver, 5, 2, 3, "Test 1");
        runTest(solver, 6, 5, 1, "Test 2");
        runTest(solver, 1, 1, 1, "Test 3");
    }
}