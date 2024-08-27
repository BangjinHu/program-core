package theory.strings;

import java.util.HashMap;
import java.util.Map;

public class minWindow {

    public static void main(String[] args) {

    }

    public String minWindow(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c : s2.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, length = Integer.MAX_VALUE;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char c1 = s1.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s1.substring(start, start + length);
    }
}
