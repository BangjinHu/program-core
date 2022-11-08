package LeetCodeProblem.Array_Problem;

import java.util.Arrays;

public class unSortNums {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 1, 6, 3, 5, 9};
        int[] nums2 = new int[]{3, 3};
        int[] nums3 = new int[]{3};
        System.out.println("1:" + unSortNum(nums));
        System.out.println("2:" + unSortNum(nums2));
        System.out.println("3:" + unSortNum(nums3));
    }

    public static int unSortNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
