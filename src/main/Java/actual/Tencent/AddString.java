package actual.Tencent;

public class AddString {

    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        String s = addStr(num1, num2);
        System.out.println("num1 + num2 = " + s);
    }

    private static String addStr(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
