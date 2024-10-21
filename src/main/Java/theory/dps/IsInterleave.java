package theory.dps;

public class IsInterleave {

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println("string s1 & s2 can be combinated with s3? -> " + isInterleave(s1, s2, s3));
    }

    private static boolean isInterleave(String s1, String s2, String s3) {

        int x = s1.length(), y = s2.length(), z = s3.length();
        if (x + y != z) {
            return false;
        }
        boolean[][] dp = new boolean[x + 1][y + 1];
        dp[0][0] = true;
        for (int i = 1; i <= x && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= y && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[x][y];
    }
}
