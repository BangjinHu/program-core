package theory.strings;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubString {


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString(s));
    }

    private static int lengthOfLongestSubString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < str.length()) {
            char rch = str.charAt(right);
            right++;
            map.put(rch, map.getOrDefault(rch, 0) + 1);
            while (map.get(rch) > 1) {
                char lch = str.charAt(left);
                map.put(lch, map.get(lch) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

}
