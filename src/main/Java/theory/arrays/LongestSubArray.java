package theory.arrays;

import java.util.TreeMap;

public class LongestSubArray {

    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums, int limit) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
