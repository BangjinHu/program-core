package actual.YouZan;

public class EditorLength {

    public static void main(String[] args) {

        //    给定 2 个字符串 a, b. 编辑距离是将 a 转换为 b 的最少操作次数，操作只允许如下 3 种：
        //            1. 插入一个字符，例如：fj -> fxj
        //	2. 删除一个字符，例如：fxj -> fj
        //	3. 替换一个字符，例如：fxj -> fyj
        String str1 = "fxj", str2 = "fj";
        int min = minLength(str1, str2);
        System.out.println("str1 -> str2 needs min length is: " + min);
    }


    private static int minLength(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        int len1 = str1.length(), len2 = str2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 1; i < len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < len2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
