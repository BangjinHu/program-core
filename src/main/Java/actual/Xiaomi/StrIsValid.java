package actual.Xiaomi;

import java.util.*;

/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = 20;
            String[] strs = new String[n];
            for(int i = 0; i < n; i++){
                strs[i] = sc.nextLine();
            }
            //String str = sc.nextLine();
            String[] ansList = new String[n];
            for(int k = 0; k < n; k++){
                Stack<Character> stack = new Stack<>();
                char[] chars = strs[k].toCharArray();
                if ((chars.length & 1) == 1){
                    System.out.println("false");
                }
                for (int i = 0; i < chars.length; i++){
                    if (stack.isEmpty() || !isMatch(stack.peek(), chars[i])){
                        stack.push(chars[i]);
                    }else {
                        stack.pop();
                    }
                }
                ansList[k] = stack.isEmpty() ? "true" : "false";
            }
            for(int i = 0; i < n; i++){
                System.out.println(ansList[i]);
            }
        }
    }

    private static boolean isMatch(char c, char h) {
        switch (c) {
            case '(':
                if (h == ')'){
                    return true;
                }else {
                    return false;
                }
            case '[':
                if (h == ']'){
                    return true;
                }else {
                    return false;
                }
            case '{':
                if (h == '}'){
                    return true;
                }else {
                    return false;
                }
            default:
                return false;
        }
    }
}*/

public class StrIsValid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            /*if (str.length() % 2 == 1){
                System.out.println("false");
            }
            Map<Character, Character> chairMap = new HashMap<Character, Character>(){{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if (chairMap.containsKey(c)){
                    if (stack.isEmpty() || stack.peek() != chairMap.get(c)){
                        System.out.println("false");
                    }
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            System.out.println(stack.isEmpty() ? "true" : "false");*/

            /*Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()){
                if (c == '('){
                    stack.push(')');
                }else if (c == '['){
                    stack.push(']');
                }else if (c == '{'){
                    stack.push('}');
                }else if (stack.isEmpty() || c != stack.pop()){
                    System.out.println("false");
                }
            }
            System.out.println(stack.isEmpty() ? "true" : "false");*/

            Stack<Character> stack = new Stack<>();
            char[] chars = str.toCharArray();
            if ((chars.length & 1) == 1){
                System.out.println("false");
            }
            for (int i = 0; i < chars.length; i++){
                if (stack.isEmpty() || !isMatch(stack.peek(), chars[i])){
                    stack.push(chars[i]);
                }else {
                    stack.pop();
                }
            }
            System.out.println(stack.isEmpty() ? "true" : "false");
            System.out.println();
        }
    }

    private static boolean isMatch(char c, char h) {
        switch (c) {
            case '(':
                if (h == ')'){
                    return true;
                }else {
                    return false;
                }
            case '[':
                if (h == ']'){
                    return true;
                }else {
                    return false;
                }
            case '{':
                if (h == '}'){
                    return true;
                }else {
                    return false;
                }
            default:
                return false;
        }
    }
}
