package actual.HuaWei;

public class StringMatch {

//    子序列
//    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//    示例 1：
//    输入：s = "abc", t = "ahbgdc"
//    输出：true
//    示例 2：
//    输入：s = "axc", t = "ahbgdc"
//    输出：false

    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        System.out.println("is Match? " + isMatch(s, t));
    }

    private static boolean isMatch(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int len1 = s.length(), len2 = t.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i < len2; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
