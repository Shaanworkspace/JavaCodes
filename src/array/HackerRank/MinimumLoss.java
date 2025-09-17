package array.HackerRank;

import java.util.*;

public class MinimumLoss {
    public static void pairs(List<Long> price){
        for(int i =0;i<price.size();i++){
            for(int j =i+1;j<price.size();j++){
                if(price.get(i)>price.get(j)){
                    System.out.print("{ "+price.get(i)+" , "+price.get(j)+" } : ");
                    System.out.println(price.get(i) - price.get(j));
                }
            }
        }
    }
    public static int minimumLossBrute(List<Long> price) {
        //find all the pairs
        long min = Integer.MAX_VALUE;
        for(int i =0;i<price.size();i++){
            for(int j =i+1;j<price.size();j++){
                long left = price.get(i);
                long right = price.get(j);
                if(left>right){
                    long diff = left-right;
                    if(diff < min){
                        min = diff;
                    }
                }
            }
        }

        return (int) min;
    }
    public static int minimumLossMap(List<Long> price) {
        // Step 1: store original indices
        Map<Long, Integer> yearMap = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            yearMap.put(price.get(i), i);
        }

        // Step 2: sort prices
        List<Long> sorted = new ArrayList<>(price);
        Collections.sort(sorted);

        long minLoss = Long.MAX_VALUE;

        // Step 3: check consecutive pairs in sorted list
        for (int i = 1; i < sorted.size(); i++) {
            long higher = sorted.get(i);
            long lower = sorted.get(i - 1);

            // Only valid if higher came earlier than lower
            if (yearMap.get(higher) < yearMap.get(lower)) {
                minLoss = Math.min(minLoss, higher - lower);
            }
        }

        return (int) minLoss;
    }

    public static void main(String[] args) {
        List<Long> test2 = Arrays.asList(20L, 7L, 8L, 2L, 5L);
        System.out.println(test2);
        System.out.println("Test2: " + minimumLossBrute(test2));
        System.out.println("Test2 Map : " + minimumLossMap(test2));

    }
}