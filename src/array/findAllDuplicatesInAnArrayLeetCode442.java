package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAllDuplicatesInAnArrayLeetCode442 {
    public static List<Integer> findDuplicates(int[] nums) {

        return List.of();
    }
    public static List<Integer> findDuplicatesBruteForce(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //Store in hashmap with frequency
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        //make a list to add the elements that repeats
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            if (map.get(key) > 1) {
                list.add(key);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(findDuplicatesBruteForce(arr));

    }
}
