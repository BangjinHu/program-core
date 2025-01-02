package theory.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 5, 6};
        int maxLength = maxSum(nums);
        System.out.println("current nums max length is: " + maxLength);
    }

    // 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和，输出子数组
    private static int maxSum(int[] nums) {
        int length = nums.length;
        int right = 1;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> countMap = new HashMap<>();
        while (right < length) {
            int curLen = 0;
            int curSum = 0;
            List<Integer> ansList = new ArrayList<>();
            while (nums[right] - 1 == nums[right - 1]) {
                ansList.add(nums[right]);
                curSum += nums[right];
                curLen += 1;
                right++;
            }
            max = Math.max(max, curSum);
            countMap.put(max, ansList);
        }
        List<Integer> ans = countMap.get(max);
        ans.stream().forEach(i -> System.out.print(i + " "));
        return max;
    }
}
