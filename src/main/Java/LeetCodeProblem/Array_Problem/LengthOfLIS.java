package LeetCodeProblem.Array_Problem;

public class LengthOfLIS {
    public static void main(String[] args) {

        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums){
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


}
