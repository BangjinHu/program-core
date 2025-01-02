package actual.Didi;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {

    }

    private static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0, right = 0, ans = 0, length = str.length();
        while (right < length) {
            char c = str.charAt(right);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            right++;
            while (countMap.get(c) > 1) {
                char ch = str.charAt(left);
                countMap.put(ch, countMap.getOrDefault(ch, 0) - 1);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
