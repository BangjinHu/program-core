package actual.Baidu;

public class MaxPalidormStr {

    public static void main(String[] args) {
        //给定一个字符串 s，找到 s 中最长的回文子串
        //ui23levelasejsjmm
        String str = "ui23levelasejsjmm";
        String subs = maxStr(str);
        System.out.println("current string max sub string is : " + subs);

    }

    private static String maxStr(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        for (int i = 0; i < str.length(); i++) {
            i = findMaxStr(str, i, range);
        }
        return str.substring(range[0], range[1] + 1);
    }

    private static int findMaxStr(String str, int start, int[] range) {
        int high = start, low = start;
        while (high < str.length() - 1 && str.charAt(high + 1) == str.charAt(start)) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < str.length() - 1 && str.charAt(low - 1) == str.charAt(high + 1)) {
            low--;
            high++;
        }
        if (range[1] - range[0] < high - low) {
            range[1] = high;
            range[0] = low;
        }
        return ans;
    }
}
