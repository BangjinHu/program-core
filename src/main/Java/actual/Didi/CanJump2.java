package actual.Didi;

public class CanJump2 {

    public static void main(String[] args) {

    }

    private static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }
}
