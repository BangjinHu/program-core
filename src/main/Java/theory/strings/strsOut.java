package theory.strings;

import java.util.Stack;

public class strsOut {

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(strsOut(str));
    }

    public static String strsOut(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int left = 0, right = 1;
        String ans = "";
        while (right < str.length()) {
            String subStr = str.substring(left, right);
            if (isValid(subStr)) {
                right++;
                ans = subStr.length() > ans.length() ? subStr : ans;
            } else {
                left++;
            }
        }
        return ans;
    }

    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int mid = str.length() % 2 == 0 ? str.length() / 2 : str.length() / 2 + 1;
        for (int i = 0; i < mid; i++) {
            stack.push(str.charAt(i));
        }
        for (int i = mid + 1; i < str.length(); i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
