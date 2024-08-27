package theory.strings;

public class reverseStr {

    public static void main(String[] args) {

    }

    public String reverseWords(String word) {
        if (word == null || word.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = word.length();
        int idx = 0;
        while (idx < length) {
            int start = idx;
            while (idx < length && word.charAt(idx) != ' ') {
                idx++;
            }
            for (int i = start; i < idx; i++) {
                sb.append(word.charAt(start + idx - 1 - i));
            }
            while (idx < length && word.charAt(idx) == ' ') {
                idx++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
