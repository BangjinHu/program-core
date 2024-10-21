package theory.backtraces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LettersCombinations {

    static Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public static void main(String[] args) {
        String digits = "23";
        List<String> ansList = letterCombinations(digits);
        ansList.forEach(System.out::println);
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() != 0) {
            backTrace("", digits, result);
        }
        return result;
    }

    private static void backTrace(String combinations, String digits, List<String> result) {
        if (digits.length() == 0) {
            result.add(combinations);
        } else {
            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                backTrace(combinations + letters.charAt(i), digits.substring(1), result);
            }
        }
    }
}
