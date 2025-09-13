package Maths;
import array.commonInArrays;

public class HCF {

    public static int[] hcf(int a, int b) {
    int[] fac1 = basics.factorOfNumber(a);
    int[] fac2 = basics.factorOfNumber(b);

    return commonInArrays.commonInArrayByHashSet(fac1,fac2);
    }
    
    public static int gcf(int a , int b ){
        int[] arr = hcf(a,b);
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        int[] ans = hcf(9, 12);
        for(int n : ans){
            System.out.println(n);
        }

        System.out.println("-------------------------------------------------------");

        System.out.println("Greatest Common Factor: "+gcf(9,12));
    }
}
