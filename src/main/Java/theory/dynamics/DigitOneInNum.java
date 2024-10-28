package theory.dynamics;

import java.util.Arrays;

public class DigitOneInNum {

    public static void main(String[] args) {

    }

    public int digitOneInNumber(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int length = chars.length;
        int[][] dp = new int[length][length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, chars, dp);
    }

    private int dfs(int idx, int count, boolean isLimit, char[] chars, int[][] dp) {
        if (idx == chars.length) {
            return count;
        }
        if (!isLimit && dp[idx][count] >= 0) {
            return dp[idx][count];
        }
        int res = 0;
        int up = isLimit ? chars[idx] - '0' : 9;
        for (int i = 0; i <= up; i++) {
            res += dfs(idx + 1, count + (i == 1 ? 1 : 0), isLimit && i == up, chars, dp);
        }
        if (!isLimit) {
            dp[idx][count] = res;
        }
        return res;
    }
}
