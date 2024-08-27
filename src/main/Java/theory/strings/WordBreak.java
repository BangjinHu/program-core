package theory.strings;

import java.util.*;

/**
 * 单词拆分
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];//dp[i]表示长度为i的s前缀字串可以拆分成wordDict的单词
        dp[0] = true;
        for (int right = 1; right <= length; right++){
            for (int left = right - 1; left >= 0; left--){
                //从后往前截取，动态规划
                if (wordSet.contains(s.substring(left, right)) && dp[left]){
                    dp[right] = true;
                    break;
                }
            }
        }

        //2. 回溯
        List<String> res = new ArrayList<>();
        if (dp[length]){
            Deque<String> path = new ArrayDeque<>();
            dfs(s, length, wordSet, dp, path, res);
            return res;
        }
        return res;
    }

    private static void dfs(String s, int length, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (length == 0){
            res.add(String.join(" ", path));
            return;
        }
        for (int i = length - 1; i >= 0; i--){
            String suffix = s.substring(i, length);
            if (wordSet.contains(suffix) && dp[i]){
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }

}
