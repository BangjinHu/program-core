package theory.strings;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }
        Map<Character, Character> dataMap = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            if (!dataMap.containsKey(source.charAt(i))) {
                if (dataMap.containsValue(target.charAt(i))) {
                    return false;
                } else {
                    dataMap.put(source.charAt(i), target.charAt(i));
                }
            } else {
                if (dataMap.get(source.charAt(i)) != target.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
