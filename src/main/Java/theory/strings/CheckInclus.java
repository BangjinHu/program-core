package theory.strings;

public class CheckInclus {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        boolean isMatch = checkInClus(s1, s2);
        System.out.println("s2 is concluded s1? " + isMatch);
    }

    private static boolean checkInClus(String s1, String s2) {
        // 判断 s2 是否包含 s1
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (isMatch(s1Arr, s2Arr)) {
                return true;
            }
            s2Arr[s2.charAt(i + s1.length()) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']--;
        }
        return isMatch(s1Arr, s2Arr);
    }

    private static boolean isMatch(int[] s1Arr, int[] s2Arr) {
        for (int i = 0; i < 26; i++) {
            if (s1Arr[i] != s2Arr[i]) {
                return false;
            }
        }
        return true;
    }
}
