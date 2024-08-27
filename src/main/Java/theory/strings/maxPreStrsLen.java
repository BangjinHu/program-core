package theory.strings;

public class maxPreStrsLen {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(maxPrefixStrsLen(strs));
    }

    public static String maxPrefixStrsLen(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < str.length() && j < strs[i].length(); j++) {
                if (str.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            str = str.substring(0, j);
            if ("".equals(str)) {
                return str;
            }
        }
        return str;
    }
}
