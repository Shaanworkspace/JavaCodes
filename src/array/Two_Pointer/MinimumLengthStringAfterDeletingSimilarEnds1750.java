package array.Two_Pointer;

public class MinimumLengthStringAfterDeletingSimilarEnds1750 {
    public static int minimumLength(String s) {
        int i =0,j=s.length()-1;
        boolean flag = false;
        while(i<=j){
            if(i==j){
                return 1;
            }
            char target =  s.charAt(i);

            while(s.charAt(j)==target && j>i){
                j--;
                flag = true;
            }
            while (s.charAt(i)==target && flag == true && j>i){
                i++;
                flag = true;
            }
            if(!flag){
                return j-i+1;
            }else{
                flag = false;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbbbbbbb";
        System.out.println(minimumLength(s));
    }
}
