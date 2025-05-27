package array.jumpGame;

public class JumpGame1 {
    public static boolean canJump(int[] arr) {
        int i =0,n=arr.length,result=0;
        if(n==1) return true;
        if(arr[0]==0) return false;
        while(i<n){
            result+=arr[i];
            if(result > n-1){
                return true;
            }
            if(arr[i]==0) return false;
            i=i+arr[i];
        }
        return false;
    }
    public static boolean canJumpGreedy(int[] arr) {
        int n = arr.length;
        int flag = n-1;
        if(n==1) return true;
        for(int i =n-2;i>=0;i--){
            if(i+arr[i]>=flag){
                flag = i;
                if(flag==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 0, 0};
        boolean t = canJumpGreedy(arr);
        System.out.println(t);
    }
}
