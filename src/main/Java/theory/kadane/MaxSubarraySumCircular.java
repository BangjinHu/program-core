package theory.kadane;

public class MaxSubarraySumCircular {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, -2, 3, -2};
        int[] nums = new int[]{5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums));
    }

    private static int maxSubarraySumCircular(int[] nums) {
        // 最大的环形子数组和 = max(最大子数组和，数组总和-最小子数组和)
        int total = 0, sumMax = nums[0], sumMin = nums[0], curMin = 0, curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            sumMax = Math.max(curMax, sumMax);
            curMin = Math.min(nums[i], curMin + nums[i]);
            sumMin = Math.min(curMin, sumMin);
            total += nums[i];
        }
        return sumMax > 0 ? Math.max(sumMax, total - sumMin) : sumMax;
    }
}
