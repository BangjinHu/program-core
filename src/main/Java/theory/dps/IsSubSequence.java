package theory.dps;

public class IsSubSequence {

    public static void main(String[] args) {

        String s = "abc", t = "ahbgdc";
        boolean isSub = isSubSequence(s, t);
        System.out.println("is string t's subsequence is s ? " + isSub);

    }

    private static boolean isSubSequence(String s, String t) {

        int sL = s.length(), tL = t.length();
        if (tL < sL) {
            return false;
        }
        if (sL == 0) {
            return true;
        }
        boolean[][] dp = new boolean[sL + 1][tL + 1];
        for (int i = 0; i < tL; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= sL; i++) {
            for (int j = 1; j <= tL; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[sL][tL];
    }
}
