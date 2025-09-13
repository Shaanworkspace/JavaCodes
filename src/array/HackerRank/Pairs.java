package array.HackerRank;

import java.util.*;

public class Pairs {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k (the target difference)
     *  2. INTEGER_ARRAY arr
     */
    public static int pairs(int k, List<Integer> arr) {
       for(int i =0;i<arr.size();i++){
           for(int j =0;j<arr.size();j++){

           }
       }
       return 0;
    }

    public static void main(String[] args) {
        // Hardcoded sample input from HackerRank
        int k = 2;
        List<Integer> arr = Arrays.asList(1, 5, 3, 4, 2);

        int result = pairs(k, arr);

        System.out.println("Number of pairs with difference " + k + " = " + result);
    }
}