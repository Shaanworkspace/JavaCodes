package Array.TwoPointer;

import java.util.*;

public class MoveAllZeroesToEndGFG {

	public void pushZerosToEndMethod1(int[] arr) {
		int i = 0,n=arr.length,j=0;
		while(i<=n-1){
			while((i<=n-1) && (arr[i]!=0)) i++;
			j=i+1;
			while(j<=n-1 && arr[j]==0) j++;

			if(j>=n) break;
			if(arr[i]==0 && arr[j]!=0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

	public void pushZerosToEndMethod2(int[] arr) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int n = arr.length;
		for(int a : arr){
			if(a!=0) arrayList.add(a);
		}
		int nonZero = arrayList.size();
		int idx = 0;
		for(int a : arrayList){
			arr[idx++]  = a;
		}

		for(int i =nonZero ;i<n;i++){
			arr[i] = 0;
		}
	}

	public void pushZerosToEndMethod3(int[] arr) {

	}

	private static void runTest(MoveAllZeroesToEndGFG solver,
	                            int[] arr, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] arr1 = Arrays.copyOf(arr, arr.length);
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, arr.length);

		solver.pushZerosToEndMethod1(arr1);
		solver.pushZerosToEndMethod2(arr2);
		solver.pushZerosToEndMethod3(arr3);

		System.out.printf("Method1   : %-20s %s%n",
				Arrays.toString(arr1), Arrays.equals(arr1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-20s %s%n",
				Arrays.toString(arr2), Arrays.equals(arr2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-20s %s%n",
				Arrays.toString(arr3), Arrays.equals(arr3, expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		MoveAllZeroesToEndGFG solver = new MoveAllZeroesToEndGFG();

		System.out.println("=================================================");
		System.out.println("Move All Zeroes To End - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{1, 2, 0, 4, 3, 0, 5, 0},
				new int[]{1, 2, 4, 3, 5, 0, 0, 0},
				"Test 1");

		runTest(solver,
				new int[]{10, 20, 30},
				new int[]{10, 20, 30},
				"Test 2");



		runTest(solver,
				new int[]{0, 0,0,3,1,4},
				new int[]{3, 1, 4, 0, 0, 0},
				"Test 4");
	}
}