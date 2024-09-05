package theory.arrays;

public class CanJump2 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    private static int canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }
}
