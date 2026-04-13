package Graph.TopologicalSort;

import java.util.*;

public class CourseScheduleLeetCode207 {

	public boolean canFinishRecursionTopoDFS(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		ArrayList<ArrayList<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) adjM.add(new ArrayList<>());
		for (int[] a : prerequisites) adjM.get(a[1]).add(a[0]);


		return false;
	}

	public boolean canFinishRecursionTopoBFS(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) adjM.add(new ArrayList<>());

		int[] inbound = new int[numCourses];
		for (int[] a : prerequisites) {
			int u = a[0];
			int v = a[1];
			inbound[u]++;
			adjM.get(v).add(u);
		}

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < inbound.length; i++) {
			if (inbound[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			count++;
			for (int a : adjM.get(curr)) {
				if (inbound[a] == 0) continue;
				inbound[a]--;
				if (inbound[a] == 0) queue.add(a);
			}
		}
		return count == numCourses;
	}

	public boolean canFinishTabulation(int numCourses, int[][] prerequisites) {
		return false;
	}

	private static void runTest(CourseScheduleLeetCode207 solver,
	                            int numCourses,
	                            int[][] prerequisites,
	                            boolean expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : numCourses = " + numCourses +
				", prerequisites = " + Arrays.deepToString(prerequisites));
		System.out.println("Expected  : " + expected);

		boolean recursion = solver.canFinishRecursionTopoDFS(numCourses, prerequisites);
		boolean memo = solver.canFinishRecursionTopoBFS(numCourses, prerequisites);
		boolean tabulation = solver.canFinishTabulation(numCourses, prerequisites);

		System.out.printf("Recursion        : %-7b %s%n",
				recursion, recursion == expected ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-7b %s%n",
				memo, memo == expected ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-7b %s%n",
				tabulation, tabulation == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CourseScheduleLeetCode207 solver =
				new CourseScheduleLeetCode207();

		System.out.println("=================================================");
		System.out.println("Course Schedule - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				2,
				new int[][]{{1, 0}},
				true,
				"Test 1");

		runTest(solver,
				2,
				new int[][]{{1, 0}, {0, 1}},
				false,
				"Test 2");
	}
}
