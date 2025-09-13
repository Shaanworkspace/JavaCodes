package array.HackerRank;


import java.util.*;

/// [...](https://www.hackerrank.com/challenges/missing-numbers/problem)
public class MissingNumber {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (Integer integer : brr) {
            if (hashMap.containsKey(integer)) {
                hashMap.put(integer, hashMap.get(integer) + 1);
            } else {
                hashMap.put(integer, 1);
            }
        }
        for (Integer integer : arr) {
            hashMap.put(integer, hashMap.get(integer) - 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > 0) {
                list.add(integer);
            }
        }
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);

        List<Integer> result = missingNumbers(arr, brr);

        System.out.println("Missing Numbers: " + result);
    }
}
