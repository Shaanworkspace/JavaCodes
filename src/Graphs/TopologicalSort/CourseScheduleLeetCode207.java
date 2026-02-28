package Graphs.TopologicalSort;

import java.util.*;

public class CourseScheduleLeetCode207 {

	public boolean canFinishRecursion(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;

		//making adjacency list
		List<List<Integer>> adjM = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjM.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			adjM.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
//		System.out.println(adjM);

		//kahn's algoritm
		//It is like checking the cycle in graph directed

		//making inbound array
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

		return res.size() == numCourses;
	}

	public boolean canFinishRecursionMemo(int numCourses, int[][] prerequisites) {
		return false;
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

		boolean recursion = solver.canFinishRecursion(numCourses, prerequisites);
		boolean memo = solver.canFinishRecursionMemo(numCourses, prerequisites);
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
