package SegmentTrees;
import java.util.*;

public class RangeSumQueryImmutableLeetCode303 {

	public static class NumArray {

		int[] segmentTree;
		int n ;
		public NumArray(int[] nums) {
			n = nums.length;
			segmentTree = new int[4*n];
			buildTree(nums,0,0,n-1);
		}
		public int sumRange(int left, int right) {
			return query(0,0,n-1,left,right);
		}

		private void buildTree(int[] nums, int node, int start, int end) {
			if(start==end){
				segmentTree[node] = nums[start];
				return;
			}
			int mid = (start + end)/2;
			buildTree(nums,2*node+1,start,mid);
			buildTree(nums,2*node+2,mid+1,end);
			segmentTree[node] = segmentTree[2*node+1] + segmentTree[2*node+2];
		}


		private int query(int node, int start, int end, int left, int right) {
			if(left > end || right < start ){
				return 0;
			}
			else if(left<=start && right>=end){
				return segmentTree[node];
			}
			int mid =(start + end)/2;
			int leftSum = query(2 * node + 1, start, mid, left, right);
			int rightSum = query(2 * node + 2, mid + 1, end, left, right);

			return leftSum + rightSum;
		}
	}

	public static class NumArrayMethod2 {

		public NumArrayMethod2(int[] nums) {
		}

		public int sumRange(int left, int right) {
			return 0;
		}
	}

	public static class NumArrayMethod3 {

		public NumArrayMethod3(int[] nums) {
		}

		public int sumRange(int left, int right) {
			return 0;
		}
	}

	private static void runTest(int[] nums, int[][] queries, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : nums = " + Arrays.toString(nums));
		System.out.println("Queries   : " + Arrays.deepToString(queries));
		System.out.println("Expected  : " + Arrays.toString(expected));

		NumArray m1 = new NumArray(nums);
		NumArrayMethod2 m2 = new NumArrayMethod2(nums);
		NumArrayMethod3 m3 = new NumArrayMethod3(nums);

		boolean pass1 = true, pass2 = true, pass3 = true;

		for (int i = 0; i < queries.length; i++) {
			int l = queries[i][0], r = queries[i][1];

			if (m1.sumRange(l, r) != expected[i]) pass1 = false;
			if (m2.sumRange(l, r) != expected[i]) pass2 = false;
			if (m3.sumRange(l, r) != expected[i]) pass3 = false;
		}

		System.out.printf("Method 1         : %-10s %s%n",
				"Checked", pass1 ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				"Checked", pass2 ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				"Checked", pass3 ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	static void main(String[] args) {

		System.out.println("=================================================");
		System.out.println("Range Sum Query - Immutable - Tests");
		System.out.println("=================================================\n");

		runTest(
				new int[]{-2, 0, 3, -5, 2, -1},
				new int[][]{{0, 2}, {2, 5}, {0, 5}},
				new int[]{1, -1, -3},
				"Test 1"
		);
	}
}