package Array.SlidingWindow;

public class MaximumTillIndex {
	static void main() {
		int[] arr = {2,4,3,29,6,19,15};
		int n = arr.length;
		int[] res = new int[n];
		res[0]=arr[0];
		for(int i=1;i<n;i++){
			if(arr[i]>=res[i-1]){
				res[i]=arr[i];
			}else{
				res[i]=res[i-1];
			}
		}

		for(int a : res){
			System.out.println(a+" ");
		}
	}
}
