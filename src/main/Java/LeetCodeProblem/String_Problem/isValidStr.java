package LeetCodeProblem.String_Problem;

import java.util.Deque;
import java.util.LinkedList;

public class isValidStr {

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValidStr(str));
    }

    public static boolean isValidStr(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{'){
                stack.push('}');
            } else {
                if (stack.isEmpty() || c != stack.poll()) {
                    return false;
                }
            }
        }
        return true;
    }
}
