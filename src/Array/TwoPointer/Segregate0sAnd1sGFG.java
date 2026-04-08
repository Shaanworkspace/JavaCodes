package Array.TwoPointer;
import java.util.*;

public class Segregate0sAnd1sGFG {

	public void segregate0and1Method1(int[] arr) {
		int n = arr.length;
		int i =0,j=n-1;

		while(i<j){
			if(j==0) break;
			if(arr[j]==1) j--;
			else if(arr[i]==0) i++;
			else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

	public void segregate0and1Method2(int[] arr) {
	}

	public void segregate0and1Method3(int[] arr) {
	}

	private static void runTest(Segregate0sAnd1sGFG solver,
	                            int[] arr, int[] expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : " + Arrays.toString(arr));
		System.out.println("Expected  : " + Arrays.toString(expected));

		int[] arr1 = Arrays.copyOf(arr, arr.length);
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, arr.length);

		solver.segregate0and1Method1(arr1);
		solver.segregate0and1Method2(arr2);
		solver.segregate0and1Method3(arr3);

		System.out.printf("Method 1         : %-15s %s%n",
				Arrays.toString(arr1), Arrays.equals(arr1, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-15s %s%n",
				Arrays.toString(arr2), Arrays.equals(arr2, expected) ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-15s %s%n",
				Arrays.toString(arr3), Arrays.equals(arr3, expected) ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {

		Segregate0sAnd1sGFG solver = new Segregate0sAnd1sGFG();

		System.out.println("=================================================");
		System.out.println("Segregate 0s and 1s - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new int[]{0,1,0,1,0,0,1,1,1,0},
				new int[]{0,0,0,0,0,1,1,1,1,1},
				"Test 1");

		runTest(solver,
				new int[]{1,1},
				new int[]{1,1},
				"Test 2");
	}
}