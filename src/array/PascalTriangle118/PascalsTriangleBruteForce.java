package array.PascalTriangle118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleBruteForce {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows==0) return result;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        if(numRows==1) return result;


        for(int i = 1 ; i< numRows;i++){
            List<Integer> previousList = result.get(i-1);
            List<Integer> midList = new ArrayList<>();
            midList.add(1);
            for(int j = 1 ; j<i-1 ;j++){
                midList.add(previousList.get(j)+previousList.get(j-1));
            }
            midList.add(1);
            result.add(midList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> n = generate(2 );
    }
}
