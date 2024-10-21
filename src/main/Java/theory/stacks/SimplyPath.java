package theory.stacks;

import java.util.Stack;

public class SimplyPath {

    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        System.out.println("current path simply is: " + simplyPath(path));
    }

    private static String simplyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
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
