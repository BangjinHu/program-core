package actual.Didi;

public class LongestPalindrome {

    public static void main(String[] args) {

    }

    private static String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            i = findLongest(chars, i, range);
        }
        return str.substring(range[0], range[1] + 1);
    }

    private static int findLongest(char[] chars, int low, int[] range) {
        int high = low;
        while (high < chars.length && chars[high + 1] == chars[low]) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < chars.length - 1 && chars[low - 1] == chars[high + 1]) {
            high++;
            low--;
        }
        if (range[1] - range[0] < high - low) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
