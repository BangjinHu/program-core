package LeetCodeProblem.String_Problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    public static void main(String[] args) {
        String str = "/home/././cxs/";
        System.out.println(simplifyPath(str));
    }

    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        String[] paths = path.split("/");
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].length() == 0 || paths[i].equals(".")) {
                continue;
            }
            if (!stack.isEmpty()) {
                if (paths[i].equals("..")) {
                    stack.pop();
                } else {
                    stack.push(paths[i]);
                }
            } else {
                if (!paths[i].equals("..")) {
                    stack.push(paths[i]);
                }
            }
        }
        if (stack.isEmpty()) {
            return sb.append("/").toString();
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
