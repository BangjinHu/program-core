package LeetCodeProblem.String_Problem;

import java.util.Objects;

public class addStrings {

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "456";
        System.out.println(addStrings(str1, str2));
    }

    /**
     * 字符串相加
     * @param str1
     * @param str2
     * @return
     */
    public static String addStrings(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return Objects.isNull(str1) ? str2 : str1;
        }
        StringBuilder sb = new StringBuilder();
        int m = str1.length() - 1, n = str2.length() - 1;
        int carry = 0;
        while (m >= 0 || n >= 0 || carry != 0) {
            carry += str1.charAt(m--) - '0';
            carry += str2.charAt(n--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

}
