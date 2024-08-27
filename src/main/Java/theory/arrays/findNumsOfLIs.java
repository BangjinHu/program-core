package theory.arrays;

import java.util.Arrays;

public class findNumsOfLIs {

    public static void main(String[] args) {

        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findNumsOfLIS(nums));

    }

    public static int findNumsOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] coms = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(coms, 1);
        int max = 1, ans = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[i] > nums[k]) {
                    if (dp[k] + 1 > dp[i]) {
                        dp[i] = dp[k] + 1;
                        coms[i] = coms[k];
                    } else if (dp[k] + 1 == dp[i]) {
                        coms[i] += coms[k];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                ans += coms[i];
            }
        }

        return ans;
    }
}
