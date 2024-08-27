package theory.strings;

public class compressStr {

    public static void main(String[] args) {

    }

    public int compressStr(char[] chars) {

//        StringBuilder sb = new StringBuilder();
//        int left = 0, right = 0;
//        int length = chars.length;
//        while (right < length) {
//            right++;
//            while (right < length && chars[left] == chars[right]) {
//                right++;
//            }
//            sb.append(chars[left]);
//            if (right - left > 1) {
//                sb.append(right - left);
//            }
//            left = right;
//        }
//        String s = sb.toString();
//        for (int i = 0; i < s.length(); i++) {
//            chars[i] = s.charAt(i);
//        }
//        return s.length();

        // 滑动窗口
        int left = 0, size = 0;
        for (int right = 0; right <= chars.length; right++) {
            if (right == chars.length || chars[right] != chars[left]) {
                chars[size++] = chars[left];
                if (right - left > 1) {
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }
}
