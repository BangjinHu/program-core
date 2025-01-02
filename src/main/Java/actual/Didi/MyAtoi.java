package actual.Didi;

public class MyAtoi {

    public static void main(String[] args) {

    }

    // string convert to integer
    private static int strConvertInteger(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        boolean flag = false;
        if (str.charAt(index) == '-') {
            flag = true;
            index++;
        } else if (str.charAt(index) == '+') {
            flag = false;
            index++;
        } else if (!Character.isDigit(str.charAt(index))) {
            return 0;
        }
        int ans = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index);
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return flag ? -ans : ans;
    }
}
