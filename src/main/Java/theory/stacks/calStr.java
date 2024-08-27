package theory.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class calStr {

    public static void main(String[] args) {
        String str = "1 + 2 - 2 + 3 * 3 + 4 / 2";
        System.out.println(calStr(str));
    }

    public static int calStr(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
