package theory.arrays;

import java.util.Arrays;

public class LengthOfLIS {
    public static void main(String[] args) {

        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS1(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;//初始化
        int ans = 1;//长度初始化为1，就最起码是有一个的
        for (int i = 1; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(max, dp[i]);
        }
        return ans;
    }

    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int res = dp[0];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

}
