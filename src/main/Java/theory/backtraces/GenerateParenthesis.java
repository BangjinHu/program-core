package theory.backtraces;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> ansList = generateParenthesis(4);
        ansList.forEach(System.out::println);
    }

    private static List<String> generateParenthesis(int n) {

        List<String> parenthesis = new ArrayList<>();
        generate("", n, 0, 0, parenthesis);
        return parenthesis;
    }

    private static void generate(String prefix, int n, int left, int right, List<String> parenthesis) {
        if (right == n) {
            parenthesis.add(prefix);
        }
        if (left < n) {
            generate(prefix + "(", n, left + 1, right, parenthesis);
        }
        if (right < left) {
            generate(prefix + ")", n, left, right + 1, parenthesis);
        }
    }
}
