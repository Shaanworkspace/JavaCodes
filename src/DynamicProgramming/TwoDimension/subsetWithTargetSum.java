package DynamicProgramming.TwoDimension;

public class subsetWithTargetSum {


	static void main() {
		int[] arr = {8,1,2,4};
		int target = 18;
		int sum =0;
		System.out.println(subsetFinder(arr,0,target));
	}

	// Recursion approach
	private static boolean subsetFinder(int[] arr,int idx , int target) {
		if(idx>=arr.length){
			if(target==0) return true;
			else return false;
		}
		boolean skip = subsetFinder(arr,idx+1,target);
		if(target+arr[idx]<0) return false;
		boolean pick = subsetFinder(arr,idx+1,target-arr[idx]);
		return skip || pick;
	}
}
