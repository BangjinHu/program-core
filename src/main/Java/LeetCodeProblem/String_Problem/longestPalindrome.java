package LeetCodeProblem.String_Problem;

public class longestPalindrome {

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String str) {
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
        while (high < chars.length - 1 && chars[high + 1] == chars[low]) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < chars.length - 1 && chars[low - 1] == chars[high + 1]) {
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
