package theory.strings;

public class IsSubSequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubSequence(s, t));
    }

    private static boolean isSubSequence(String source, String target) {
        //source 是否是 target 的子序列
        if (source.length() < target.length()) {
            return true;
        }
        if (source.length() > target.length()) {
            return false;
        }
        int idx = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                idx++;
                if (idx >= source.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
