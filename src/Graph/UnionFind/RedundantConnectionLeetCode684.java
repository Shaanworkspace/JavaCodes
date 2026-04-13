package Graph.UnionFind;

import java.util.*;

public class RedundantConnectionLeetCode684 {

	static int[] parent,size;
	public static int leader(int a ){
		if(parent[a] == a) return a;
		int  leaderA = leader(parent[a]);
		parent[a] = leaderA;
		return leaderA;
	}

	public static void union(int a ,int b ){
		int la = leader(a);
		int lb = leader(b);

		if(la!=lb){
			if(size[la]>size[lb]){
				parent[lb] = la;
				size[la] +=size[lb];
			}else{
				parent[la] = lb;
				size[lb] +=size[la];
			}
		}

	}
	// Try yourself
	public int[] findRedundantConnection(int[][] edges) {


		int n = edges.length;

		parent = new int[n+1];
		size = new int[n+1];

		for(int i =0;i<n;i++){
			parent[i] = i;
			size[i]=1;
		}
		int[] ans = new int[2];

		for(int[] a : edges){
			int u = a[0];
			int v = a[1];

			if(leader(u) == leader(v)){
				ans[0] = u;
				ans[1] = v;
				break;
			} else {
				union(u,v);
			}
		}
		return ans;
	}

	private static void runTest(RedundantConnectionLeetCode684 solver,
	                            int[][] edges, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.deepToString(edges));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] result = solver.findRedundantConnection(edges);

		System.out.printf("Result          : %-15s %s%n",
				Arrays.toString(result),
				Arrays.equals(result, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		RedundantConnectionLeetCode684 solver =
				new RedundantConnectionLeetCode684();

		System.out.println("=================================================");
		System.out.println("Redundant Connection - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[][]{{1,2},{1,3},{2,3}},
				new int[]{2,3},
				"Test 1");

		runTest(solver,
				new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}},
				new int[]{1,4},
				"Test 2");
	}
}
