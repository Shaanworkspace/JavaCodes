package Strings;
import java.util.*;

public class PathCrossingLeetCode1496 {
	public boolean isPathCrossingBrute(String path) {
		int n = path.length();
		if(n==1) return false;
		HashSet<String> hashSet = new HashSet<>();
		int x = 0,y=0;
		hashSet.add("0,0");
		for(char a : path.toCharArray()){
			if(a=='N'){
				x=x+1;
			}
			else if(a=='S'){
				x=x-1;
			}
			else if(a=='E'){
				y+=1;
			}
			else{
				y-=1;
			}
			String pos = x + "," + y;

			if(hashSet.contains(pos)){
				return true;
			}
			hashSet.add(pos);
		}
		return false;
	}

	public boolean isPathCrossingTryYourSelf(String path) {
		return false;
	}

	public boolean isPathCrossing(String path) {
		return false;
	}

	private static void runTest(PathCrossingLeetCode1496 solver,
	                            String path, boolean expected, String testName) {
		System.out.println(testName);
		System.out.println("Input     : path = \"" + path + "\"");
		System.out.println("Expected  : " + expected);

		boolean brute = solver.isPathCrossingBrute(path);
		boolean your  = solver.isPathCrossingTryYourSelf(path);
		boolean opt   = solver.isPathCrossing(path);

		System.out.printf("Brute Force      : %-10s %s%n",
				brute, brute == expected ? "PASS" : "FAIL");
		System.out.printf("TryYourSelf      : %-10s %s%n",
				your,  your == expected ? "PASS" : "FAIL");
		System.out.printf("Optimized (O(n)) : %-10s %s%n",
				opt,   opt == expected ? "PASS" : "FAIL");
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		PathCrossingLeetCode1496 solver = new PathCrossingLeetCode1496();

		System.out.println("=================================================");
		System.out.println("Path Crossing - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				"NES",
				false,
				"Test 1");

		runTest(solver,
				"NESWW",
				true,
				"Test 2");
	}
}