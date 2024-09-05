package theory.strings;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", word = "dog cat cat dog";
        System.out.println(wordPattern(word, pattern));
    }

    private static boolean wordPattern(String word, String pattern) {
        if (word == null || pattern == null) {
            return false;
        }
        String[] strs = word.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strs[i])) {
                    return false;
                } else {
                    map.put(c, strs[i]);
                }
            }
        }
        return true;
    }
}
