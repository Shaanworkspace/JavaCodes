package Graphs.TopologicalSort;

import java.util.*;

public class CourseScheduleIILeetCode210 {

	public int[] findOrderRecursion(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		//making adjacency list
		List<List<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjM.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			adjM.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}


		int[] inbound = new int[numCourses];
		for (List<Integer> a : adjM) {
			for (int b : a) {
				inbound[b] = inbound[b] + 1;
			}
		}


		boolean[] isVisited = new boolean[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inbound[i] == 0) {
				queue.offer(i);
				isVisited[i] = true;
			}
		}

		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			int top = queue.poll();
			res.add(top);
			for (int a : adjM.get(top)) {
				if (!isVisited[a]) {
					inbound[a] = inbound[a] - 1;
					if (inbound[a] == 0) {
						queue.offer(a);
						isVisited[a] = true;
					}
				}
			}
		}

		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	public int[] findOrderRecursionMemo(int numCourses, int[][] prerequisites) {
		return new int[0];
	}

	public int[] findOrderTabulation(int numCourses, int[][] prerequisites) {
		return new int[0];
	}

	private static void runTest(CourseScheduleIILeetCode210 solver,
	                            int numCourses,
	                            int[][] prerequisites,
	                            int[] expected,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Input     : numCourses = " + numCourses +
				", prerequisites = " + Arrays.deepToString(prerequisites));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] recursion = solver.findOrderRecursion(numCourses, prerequisites);
		int[] memo = solver.findOrderRecursionMemo(numCourses, prerequisites);
		int[] tabulation = solver.findOrderTabulation(numCourses, prerequisites);

		System.out.printf("Recursion        : %-20s %s%n",
				Arrays.toString(recursion),
				recursion.length == expected.length ? "PASS" : "FAIL");
		System.out.printf("Memoization      : %-20s %s%n",
				Arrays.toString(memo),
				memo.length == expected.length ? "PASS" : "FAIL");
		System.out.printf("Tabulation       : %-20s %s%n",
				Arrays.toString(tabulation),
				tabulation.length == expected.length ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		CourseScheduleIILeetCode210 solver =
				new CourseScheduleIILeetCode210();

		System.out.println("=================================================");
		System.out.println("Course Schedule II - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				2,
				new int[][]{{1,0}},
				new int[]{0,1},
				"Test 1");

		runTest(solver,
				4,
				new int[][]{{1,0},{2,0},{3,1},{3,2}},
				new int[]{0,2,1,3},
				"Test 2");

		runTest(solver,
				1,
				new int[][]{},
				new int[]{0},
				"Test 3");
	}
}
