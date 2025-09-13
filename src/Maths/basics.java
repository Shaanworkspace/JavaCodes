package Maths;

import java.util.ArrayList;
import java.util.List;

public class basics {

    public static int[] factorOfNumber(int a ){
        List<Integer> fac = new ArrayList<>();
        int count=0;
        for(int i = 1 ; i <=a/2 ;i++){
            if(a%i == 0){
                fac.add(i);
                count++;
            }
        }
        int[] arr = new int[count];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = fac.get(i);
        }
        return arr;
    }

    public static List<Integer> factorOfNumberListReturn(int a){
        List<Integer> factors = new ArrayList<>();
        for(int i = 1 ; i <=a/2 ;i++){
            if(a%i == 0){
                factors.add(i);
            }
        }
        return factors;
    }


}
