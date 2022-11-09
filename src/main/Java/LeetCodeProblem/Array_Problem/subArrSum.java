package LeetCodeProblem.Array_Problem;

import java.util.HashMap;
import java.util.Map;

public class subArrSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 3;
        System.out.println(subArrSum(nums, target));
    }

    public static int subArrSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int curSum = sum - k;
            if (preSum.containsKey(curSum)) {
                ans += preSum.get(curSum);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static int subNumsCount(int[] nums, int target) {

        // 前缀和
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int curSum = sum - target;
            if (preSumMap.containsKey(curSum)) {
                ans += preSumMap.get(curSum);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
