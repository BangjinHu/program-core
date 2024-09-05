package theory.arrays;

public class MaxProfit2 {

    public static void main(String[] args) {
        //允许多次买卖
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    private static int maxProfit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][2];//表示第i天是否持有 0-不持有 1-持有
        dp[0][0] = 0;
        dp[0][1] = -arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - arr[i]);
        }
        return dp[arr.length - 1][0];
    }
}
