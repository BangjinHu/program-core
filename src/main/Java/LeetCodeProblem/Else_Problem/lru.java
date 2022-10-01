package LeetCodeProblem.Else_Problem;

import java.util.*;

public class lru {

    public static void main(String[] args) {

    }

    Map<Integer, Integer> countMap = new HashMap<>();
    int capacity = 10;

    public int get(int k) {
        if (countMap.get(k) != null) {
            int val = countMap.get(k);
            countMap.remove(k);
            countMap.put(k, val);
            return val;
        }
        return -1;
    }

    public void put(int k, int val) {
        if (countMap.size() >= capacity) {
            Iterator<Map.Entry<Integer, Integer>> it = countMap.entrySet().iterator();
            countMap.remove(it.next());
            countMap.put(k, val);
        } else {
            countMap.put(k, val);
        }
    }
}
