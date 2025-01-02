package actual.Tencent;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = maxSubStr(s);
        System.out.println("current string max sub character length is : " + length);
    }

    private static int maxSubStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0, right = 0, count = 0;
        while (right < str.length()) {
            char c = str.charAt(right);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            right++;
            while (countMap.get(c) > 1) {
                char ch = str.charAt(left);
                left++;
                countMap.put(ch, countMap.getOrDefault(ch, 0) - 1);
            }
            count = Math.max(count, right - left);
        }
        return count;
    }
}
