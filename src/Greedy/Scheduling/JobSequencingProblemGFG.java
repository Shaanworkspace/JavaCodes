package Greedy.Scheduling;

import java.util.*;

public class JobSequencingProblemGFG {

	// ================= Pair class =================
	static class Pair implements Comparable<Pair> {
		int deadline;
		int profit;

		public Pair(int deadline, int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(o.profit, this.profit); // max profit first
		}

		@Override
		public String toString() {
			return "(deadline=" + deadline + ", profit=" + profit + ")";
		}
	}

	// ================= Method 1: Brute Force =================
	public ArrayList<Integer> jobSequencingMethod1(int[] deadline, int[] profit) {

		int maxDeadline = 0, maxProfit = 0, jobs = 0;

		for (int d : deadline) maxDeadline = Math.max(maxDeadline, d);

		PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < deadline.length; i++)
			priorityQueue.add(new Pair(deadline[i], profit[i]));

		int[] arr = new int[maxDeadline + 1];
		Arrays.fill(arr, -1);

		while (!priorityQueue.isEmpty()) {
			Pair pair = priorityQueue.poll();
			int idx = pair.deadline;
			int pro = pair.profit;
			System.out.println(pair.toString());
			if (arr[idx] == -1) {
				arr[idx] = 1;
				jobs++;
				maxProfit += pro;
			} else {
				idx -= 1;
				while (idx > 0) {
					if (arr[idx] == -1) {
						arr[idx] = 1;
						jobs++;
						maxProfit += pro;
						break;
					}
					idx--;
				}
			}
		}

		return new ArrayList<>(Arrays.asList(jobs, maxProfit));
	}

	// ================= Method 2: Greedy using Sorting =================
	public ArrayList<Integer> jobSequencingMethod2(int[] deadline, int[] profit) {

		return new ArrayList<>(Arrays.asList(1, 1));
	}

	// ================= Method 3: Optimized Greedy using DSU =================
	static int find(int x, int[] parent) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x], parent);
	}

	public ArrayList<Integer> jobSequencingMethod3(int[] deadline, int[] profit) {
		int maxDeadline = 0, maxProfit = 0, jobs = 0;

		for (int d : deadline) maxDeadline = Math.max(maxDeadline, d);

		PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < deadline.length; i++)
			priorityQueue.add(new Pair(deadline[i], profit[i]));

		int[] parent = new int[maxDeadline + 1];
		for (int i = 0; i <= maxDeadline; i++) parent[i] = i; // each are parent of self initially

		while (!priorityQueue.isEmpty()) {
			Pair pair = priorityQueue.poll();
			int slot = find(pair.deadline, parent);

			System.out.println(pair);
			if (slot > 0) {
				jobs++;
				maxProfit += pair.profit;
				parent[slot] = slot - 1;
			}
		}

		return new ArrayList<>(Arrays.asList(jobs, maxProfit));
	}

	// ================= Utility =================
	static ArrayList<Integer> toArrayList(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int x : arr) list.add(x);
		return list;
	}

	// ================= Test Runner =================
	private static void runTest(JobSequencingProblemGFG solver,
	                            int[] deadline, int[] profit,
	                            int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Deadline : " + Arrays.toString(deadline));
		System.out.println("Profit   : " + Arrays.toString(profit));
		System.out.println("Expected : " + Arrays.toString(expected));

		ArrayList<Integer> expectedList = toArrayList(expected);

		ArrayList<Integer> r1 = solver.jobSequencingMethod1(deadline, profit);
		ArrayList<Integer> r2 = solver.jobSequencingMethod2(deadline, profit);
		ArrayList<Integer> r3 = solver.jobSequencingMethod3(deadline, profit);

		System.out.printf("Method 1        : %-15s %s%n",
				r1, r1.equals(expectedList) ? "PASS" : "FAIL");
		System.out.printf("Method 2        : %-15s %s%n",
				r2, r2.equals(expectedList) ? "PASS" : "FAIL");
		System.out.printf("Method 3        : %-15s %s%n",
				r3, r3.equals(expectedList) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	// ================= Main =================
	public static void main(String[] args) {

		JobSequencingProblemGFG solver = new JobSequencingProblemGFG();

		System.out.println("=================================================");
		System.out.println("Job Sequencing Problem - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{4, 1, 1, 1},
				new int[]{20, 10, 40, 30},
				new int[]{2, 60},
				"Test 1");

		runTest(solver,
				new int[]{2, 1, 2, 1, 1},
				new int[]{100, 19, 27, 25, 15},
				new int[]{2, 127},
				"Test 2");

		runTest(solver,
				new int[]{3, 1, 2, 2},
				new int[]{50, 10, 20, 30},
				new int[]{3, 100},
				"Test 3");
	}
}