package LeetCodeProblem.String_Problem;

public class longestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "adbcc", str2 = "adbc";
        System.out.println(longestCommonSubsequence(str1, str2));
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
