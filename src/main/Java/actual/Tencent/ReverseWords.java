package actual.Tencent;

public class ReverseWords {

    public static void main(String[] args) {

    }

    private static String reverseWords(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        str = str.trim();
        int left = str.length() - 1, right = left;
        StringBuilder sb = new StringBuilder();
        while (left > 0) {
            while (left >= 0 && str.charAt(left) != ' ') {
                left--;
            }
            sb.append(str, left + 1, right + 1);
            while (left >= 0 && str.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return sb.toString().trim();
    }
}
