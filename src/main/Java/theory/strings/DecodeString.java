package theory.strings;

public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println("decoded string is: " + decodeStr(s));
    }

    private static String decodeStr(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return dfs(str, 0)[0];
    }

    private static String[] dfs(String str, int idx) {
        StringBuilder sb = new StringBuilder();
        int repeatNum = 0;
        while (idx < str.length()) {
            char c = str.charAt(idx);
            if (c >= '0' && c <= '9') {
                repeatNum = repeatNum * 10 + c - '0';
            } else if (c == '[') {
                String[] res = dfs(str, idx + 1);
                idx = Integer.parseInt(res[0]);
                while (repeatNum > 0) {
                    sb.append(res[1]);
                    repeatNum--;
                }
            } else if (c == ']') {
                return new String[]{String.valueOf(idx), sb.toString()};
            } else {
                sb.append(c);
            }
            idx++;
        }
        return new String[]{sb.toString()};
    }
}
