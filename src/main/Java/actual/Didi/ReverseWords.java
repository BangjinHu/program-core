package actual.Didi;

public class ReverseWords {

    public static void main(String[] args) {

    }

    private static String reverseWords(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int m = str.length() - 1, i = m;
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && str.charAt(i) != ' ') {
                i--;
            }
            sb.append(str.substring(i + 1, m + 1) + " ");
            while (i >= 0 && str.charAt(i) == ' ') {
                i--;
            }
            m = i;
        }
        return sb.toString().trim();
    }
}
