package theory.arrays;

public class longestSubArrLen {

    public static void main(String[] args) {

    }

    public int longestSubArrLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int maxLen = 0;//保存结果
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;//统一加偏移量，使下标非负
                dp[i][d] = dp[j][d] + 1; //根据 d 去填充dp[k][d]
                maxLen = Math.max(maxLen, dp[i][d]);//维护最大值
            }
        }
        return maxLen + 1;
    }
}
