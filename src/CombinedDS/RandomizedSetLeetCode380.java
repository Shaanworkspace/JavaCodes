package CombinedDS;

import java.util.*;

public class RandomizedSetLeetCode380 {
    private Map<Integer, Integer> indexMap;   // value → index
    private List<Integer> values;             // store elements
    private Random rng;
    // for getRandom()
    public RandomizedSetLeetCode380() {
        indexMap = new HashMap<>();
        values   = new ArrayList<>();
        rng      = new Random();
    }
    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        indexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!indexMap.containsKey(val)) return false;

        //if present
        int indexOfTarget = indexMap.get(val);
        int lastIndexValue = values.getLast();

        //swap from last to index where want to  delete --> now array become [1,3,3] from [1,2,3]
        values.set(indexOfTarget,lastIndexValue);
        //update the map
        indexMap.put(lastIndexValue,indexOfTarget);



        values.removeLast();
        indexMap.remove(val);

        return true;
    }

    public int getRandom() {
        int i = rng.nextInt(values.size());
        return values.get(i);
    }



    // Simple test runner
    public static void main(String[] args) {
        System.out.println("---- Optimized Version ----");
        RandomizedSetLeetCode380 obj = new RandomizedSetLeetCode380();
        System.out.println("Insert 1: " + obj.insert(1));  // Expected true
        System.out.println("Insert 1 again: " + obj.insert(1)); // Expected false
        System.out.println("Insert 2: " + obj.insert(2));  // Expected true
        System.out.println("Random: " + obj.getRandom());  // Should be 1 or 2
        System.out.println("Remove 1: " + obj.remove(1));  // Expected true
        System.out.println("Remove 3: " + obj.remove(3));  // Expected false
        System.out.println("Random: " + obj.getRandom());  // Should be remaining element(s)

        System.out.println("\n---- Brute Version ----");
        RandomizedSetLeetCode380 brute = new RandomizedSetLeetCode380();
        System.out.println("Insert 5: " + brute.insert(5));
        System.out.println("Insert 7: " + brute.insert(7));
        System.out.println("Random: " + brute.getRandom());
        System.out.println("Remove 5: " + brute.remove(5));
        System.out.println("Random: " + brute.getRandom());
    }
}