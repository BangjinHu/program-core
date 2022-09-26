package LeetCodeProblem.Array_Problem;

import java.util.*;

public class topK {

    public static void main(String[] args) {

    }

    public List<Integer> topK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ansList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((Comparator.comparingInt(Map.Entry::getValue)));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            ansList.add(queue.poll().getKey());
        }
        return ansList;
    }
}
