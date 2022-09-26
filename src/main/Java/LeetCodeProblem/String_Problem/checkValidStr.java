package LeetCodeProblem.String_Problem;

import java.util.Stack;

public class checkValidStr {

    public static void main(String[] args) {
        String str = "(*)))";
        System.out.println(checkValidStr(str));
    }

    public static boolean checkValidStr(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftStack.push(i);
            } else if (str.charAt(i) == '*') {
                starStack.push(i);
            } else {
                if (leftStack.isEmpty() && starStack.isEmpty()) {
                    return false;
                }
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else {
                    starStack.pop();
                }
            }
        }
        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.peek() > starStack.peek()) {
                return false;
            }
            leftStack.pop();
            starStack.pop();
        }
        return leftStack.isEmpty();


//        int low = 0, high = 0;
//        for (char c : str.toCharArray()) {
//            if (c == '(') {
//                low++;
//                high++;
//            } else if (c == ')') {
//                low = Math.max(0, low - 1);
//                high--;
//                if (high < 0) {
//                    return false;
//                }
//            } else {
//                low = Math.max(low - 1, 0);
//                high++;
//            }
//        }
//        return low <= 0;
    }
}
