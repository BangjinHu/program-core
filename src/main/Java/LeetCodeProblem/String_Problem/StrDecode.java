package LeetCodeProblem.String_Problem;

import java.util.LinkedList;

public class StrDecode {

    public static void main(String[] args) {

    }

    public String strDecode(String str) {
        // 解码字符串
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> numsList = new LinkedList<>();
        LinkedList<String> strsList = new LinkedList<>();
        int num = 0;
        for (Character c : str.toCharArray()) {
            if (c == '[') {
                numsList.addLast(num);
                strsList.addLast(sb.toString());
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sbd = new StringBuilder();
                int size = numsList.removeLast();
                for (int i = 0; i < size; i++) {
                    sbd.append(sb);
                }
                sb = new StringBuilder(sbd + strsList.removeLast());
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
