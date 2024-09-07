package theory.dps;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = new String[]{"leet", "code"};
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
    }

    private static boolean wordBreak(String str, List<String> wordDict) {
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[str.length()];
    }
}
