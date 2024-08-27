package theory.elses;

public class StrAppend {

    public static void main(String[] args) {
        String hello = append("hello");
        String word = append(hello + "word");
        System.out.println(word);
    }

    public static String append(String str) {
        // 数组扩大倍数
        int mSize = 2;
        char[] chars = new char[str.length()];
        if (str == null || str.length() == 0) {
            return "";
        }
        int idx = 0;
        char[] destArr = new char[0];
        for (char c : str.toCharArray()) {
            // 不够用扩展数组长度
            if (idx >= str.length()) {
                destArr = new char[chars.length * mSize];
                System.arraycopy(chars, 0, destArr, 0, chars.length);
                destArr[idx++] = c;
            } else {
                // 塞值
                chars[idx++] = c;
            }
        }
        return destArr.length == 0 ? new String(chars) : new String(destArr);
    }
}
