package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class commonInArrays {
    public static int[] commonInArrayByBruteForce(int[] arr1,int[] arr2){
        int minArray  = Math.min(arr1.length, arr2.length);
        int maxArray = Math.max(arr1.length, arr2.length);

        List<Integer> common = new ArrayList<>();
        int count = 0;
        for(int i = 0; i<minArray ;i++){
            for(int j = 0 ; j<maxArray ;j++){
                if(arr1[i]==arr2[j]){
                    common.add(arr1[i]);
                    count++;
                }
            }
        }

        int[] arr = new int[count];
        //converting list to array
        for(int i = 0 ; i < arr.length ;i++){
            arr[i]=common.get(i);
        }

        return arr;
    }


    public static  int[] commonInArrayByHashSet(int[] a , int[] b){
        Set<Integer> c = new HashSet<>();
        List<Integer> common = new ArrayList<>();
        for(int num : a){
            c.add(num);
        }
        int arrLength = 0 ;
        for(int n : b){
            if(c.contains(n)){
                common.add(n);
                arrLength++;
            }
        }

        int[] arr = new int[arrLength];
        for(int i = 0 ; i < arr.length ;i++){
            arr[i]=common.get(i);
        }

        return arr;
    }


}
