package theory.strings;

public class atoiStr {

    public static void main(String[] args) {

    }

    /**
     * 字符串转整数
     * @param str
     * @return
     */
    public int atoiStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int length = str.length();
        boolean flag = true;
        int curNum = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else if (str.charAt(i) == '-') {
                flag = false;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                curNum = curNum * 10 + str.charAt(i) - '0';
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                break;
            }
        }
        if (!flag) {
            curNum = -curNum;
        }
        if (curNum < Math.pow(2, -31)) {
            curNum = (int) Math.pow(2, -31);
        } else if (curNum > Math.pow(2, 31)) {
            curNum = (int) Math.pow(2, 31);
        } else {
            curNum = curNum;
        }
        return curNum;
    }

    public int AtoiStrs(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int lenghth = str.length();
        int idx = 0;
        while (idx < lenghth && chars[idx] == ' ') {
            idx++;
        }
        if (idx == lenghth) {
            return 0;
        }
        boolean flag = false;
        if (chars[idx] == '-') {
            flag = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }
        int ans = 0;
        while (idx < lenghth && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return flag ? -ans : ans;
    }
}
