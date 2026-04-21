package Graph.UnionFind;
import DynamicProgramming.OneDimension.PaintingTheFenceGFG;

import java.util.*;

public class MinimizeHammingDistanceLeetCode1722 {

	class DisJointSet{
		int[] size;
		int[] parent;

		DisJointSet(int n){
			size = new int[n+1];
			parent = new int[n+1];

			for(int i=0;i<=n;i++){
				size[i] =1;
				parent[i] = i;
			}
		}

		int find(int node){
			if(node == parent[node]) return node;
			return  parent[node] = find(parent[node]); // path compration
		}

		void union(int u , int v){
			int rootU = find(u);
			int rootV = find(v);
			if(rootV==rootU) return;
			if(size[rootU]<size[rootV]){
				size[rootV]+=size[rootU];
				parent[rootU] = rootV;
			}else {
				size[rootU] += size[rootV];
				parent[rootV] = rootU;
			}
		}
	}

	public int minimumHammingDistanceMethod1(int[] source, int[] target, int[][] allowedSwaps) {
			int n = source.length;
			DisJointSet dsu = new DisJointSet(n);

			for (int[] swap : allowedSwaps) {
				dsu.union(swap[0], swap[1]);
			}

			// parent -> freq map
			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				int parent = dsu.find(i);
				map.putIfAbsent(parent, new HashMap<>());
				HashMap<Integer, Integer> freq = map.get(parent);
				freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
			}

			int count = 0;

			for (int i = 0; i < n; i++) {
				int parent = dsu.find(i);
				HashMap<Integer, Integer> freq = map.get(parent);

				if (freq.getOrDefault(target[i], 0) > 0) {
					freq.put(target[i], freq.get(target[i]) - 1);
				} else {
					count++;
				}
			}

			return count;
		}
	public int minimumHammingDistanceMethod2(int[] source, int[] target, int[][] allowedSwaps) {
		return 0;
	}

	public int minimumHammingDistanceMethod3(int[] source, int[] target, int[][] allowedSwaps) {
		return 0;
	}

	private static void runTest(MinimizeHammingDistanceLeetCode1722 solver,
	                            int[] source, int[] target, int[][] allowedSwaps,
	                            int expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : source = " + Arrays.toString(source));
		System.out.println("            target = " + Arrays.toString(target));
		System.out.println("            allowedSwaps = " + Arrays.deepToString(allowedSwaps));
		System.out.println("Expected  : " + expected);

		int m1 = solver.minimumHammingDistanceMethod1(source, target, allowedSwaps);
		int m2 = solver.minimumHammingDistanceMethod2(source, target, allowedSwaps);
		int m3 = solver.minimumHammingDistanceMethod3(source, target, allowedSwaps);

		System.out.printf("Method 1         : %-10d %s%n",
				m1, m1 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10d %s%n",
				m2, m2 == expected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10d %s%n",
				m3, m3 == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		MinimizeHammingDistanceLeetCode1722 solver =
				new MinimizeHammingDistanceLeetCode1722();

		System.out.println("=================================================");
		System.out.println("Minimize Hamming Distance After Swap Operations - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1,2,3,4},
				new int[]{2,1,4,5},
				new int[][]{{0,1},{2,3}},
				1,
				"Test 1");

		runTest(solver,
				new int[]{1,2,3,4},
				new int[]{1,3,2,4},
				new int[][]{},
				2,
				"Test 2");

		runTest(solver,
				new int[]{5,1,2,4,3},
				new int[]{1,5,4,2,3},
				new int[][]{{0,4},{4,2},{1,3},{1,4}},
				0,
				"Test 3");
		runTest(solver,
				new int[]{2,3,1},
				new int[]{1,1,2},
				new int[][]{{0,2},{1,2}},
				1,
				"Test 4");

		runTest(solver,
				new int[]{1,5,5},
				new int[]{5,1,1},
				new int[][]{{0,1}},
				1,
				"Test 5");
	}
}
