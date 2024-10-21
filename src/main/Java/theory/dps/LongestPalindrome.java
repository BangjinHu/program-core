package theory.dps;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("current string palindrome is : -> " + longestPalindrome(s));
    }

    private static String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        for (int i = 0; i < str.length(); i++) {
            i = findLongest(str, i, range);
        }
        return str.substring(range[0], range[1] + 1);
    }

    private static int findLongest(String str, int low, int[] range) {
        int high = low;
        while (high < str.length() - 1 && str.charAt(high + 1) == str.charAt(low)) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < str.length() - 1 && str.charAt(high + 1) == str.charAt(low - 1)) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
